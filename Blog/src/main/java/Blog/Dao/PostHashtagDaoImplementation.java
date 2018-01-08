/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao;

import Blog.Dto.Hashtag;
import Blog.Dto.Post;
import Blog.Dto.PostHashtag;
import Blog.Service.BlogServiceException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author EJB Laptop
 */
public class PostHashtagDaoImplementation implements PostHashtagDaoInterface {

    private final String SQL_INSERT_POSTHASHTAG = "insert into PostsHashtags (postId, hashtagId) VALUES (?,?)";
    private final String SQL_SELECT_POSTHASHTAG = "select * from PostsHashtags where postHashtagId = ?";   
    private final String SQL_SELECT_POSTHASHTAGS = "select * from PostsHashtags limit ? offset ?";  
    private final String SQL_UPDATE_POSTHASHTAG = "update PostsHashtags set postId = ?, hashtagId = ? where postHashtagId = ?";
    private final String SQL_DELETE_POSTHASHTAG = "delete from PostsHashtags where postHashtagId = ?";
    private final String SQL_SELECT_POSTHASHTAGS_BY_POST = "select * from PostsHashtags where postId = ? limit ? offset ?";
    private final String SQL_SELECT_POSTHASHTAGS_BY_HASHTAG = "select * from PostsHashtags where hashtagId = ? limit ? offset ?";
    private final String SQL_DELETE_POSTHASHTAG_BY_POST = "delete from PostsHashtags where postId = ?";
    private final String SQL_DELETE_POSTHASHTAG_BY_HASHTAG = "delete from PostsHashtags where hashtagId = ?";  
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    //crud methods:
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public PostHashtag createPostHashtag(PostHashtag postHashtag) {
        jdbcTemplate.update(SQL_INSERT_POSTHASHTAG,
            postHashtag.getPost().getPostId(),
            postHashtag.getHashtag().getHashtagId());
        int postHashtagId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        postHashtag.setPostHashtagId(postHashtagId);
        return postHashtag;
    }

    @Override
    public PostHashtag getPostHashtagById(Integer postHashtagId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_POSTHASHTAG,
                    new PostHashtagMapper(), postHashtagId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<PostHashtag> findAllPostHashtags(int limit, int offset) {
        return jdbcTemplate.query(SQL_SELECT_POSTHASHTAGS, new PostHashtagMapper(), limit, offset);
    }

    @Override
    public PostHashtag updatePostHashtag(PostHashtag postHashtag) {
        jdbcTemplate.update(SQL_UPDATE_POSTHASHTAG,
            postHashtag.getPost().getPostId(),
            postHashtag.getHashtag().getHashtagId(),            
            postHashtag.getPostHashtagId());
        return postHashtag;
    }

    @Override
    public void deletePostHashtag(Integer postHashtagId) throws BlogServiceException {
        jdbcTemplate.update(SQL_DELETE_POSTHASHTAG, postHashtagId);
    }

    //relational methods:
    
    @Override
    public List<PostHashtag> findAllPostHashtagsByPost(Post post, int limit, int offset) {
        return jdbcTemplate.query(SQL_SELECT_POSTHASHTAGS_BY_POST, new PostHashtagMapper(), post.getPostId(), limit, offset);
    }

    @Override
    public List<PostHashtag> findAllPostHashtagsByHashtag(Hashtag hashtag, int limit, int offset) {
        return jdbcTemplate.query(SQL_SELECT_POSTHASHTAGS_BY_HASHTAG, new PostHashtagMapper(), hashtag.getHashtagId(), limit, offset);
    }
    
    @Override
    public void deletePostHashtagByPost(Post post) {
        jdbcTemplate.update(SQL_DELETE_POSTHASHTAG_BY_POST, post.getPostId());
    }
    
    @Override
    public void deletePostHashtagByHashtag(Hashtag hashtag) {
        jdbcTemplate.update(SQL_DELETE_POSTHASHTAG_BY_HASHTAG, hashtag.getHashtagId());
    }
    
    private static final class PostHashtagMapper implements RowMapper<PostHashtag> {

        public PostHashtag mapRow(ResultSet rs, int rowNum) throws SQLException {
            PostHashtag postHashtag = new PostHashtag();
            postHashtag.setPostHashtagId(rs.getInt("postHashtagId"));
            Post post = new Post();
            post.setPostId(rs.getInt("postId"));
            postHashtag.setPost(post);
            Hashtag hashtag = new Hashtag();
            hashtag.setHashtagId(rs.getInt("hashtagId"));
            postHashtag.setHashtag(hashtag);
            return postHashtag;
        }
    }
    
}
