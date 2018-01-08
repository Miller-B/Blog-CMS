/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao;

import Blog.Dto.Category;
import Blog.Dto.Hashtag;
import Blog.Dto.Post;
import Blog.Dto.PostHashtag;
import Blog.Dto.User;
import Blog.Service.BlogServiceException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author EJB Laptop
 */
public class PostDaoImplementation implements PostDaoInterface {

    private final String SQL_INSERT_POST = "insert into Posts (userId,startDate,endDate,createDate,approvalDate,approval,postTitle,postContent,categoryId) VALUES (?,?,?,?,?,?,?,?,?)";
    private final String SQL_SELECT_POST = "select * from Posts where postId = ?";
    private final String SQL_SELECT_POSTS = "select * from Posts ORDER BY Posts.startDate DESC limit ? offset ?";
    private final String SQL_UPDATE_POST = "update Posts set userId = ?, startDate = ?, endDate = ?, createDate = ?, approvalDate = ?, approval = ?, postTitle = ?, postContent = ?, categoryId = ? where postId = ?";
    private final String SQL_DELETE_POST = "delete from Posts where postId = ?";
    private final String SQL_SELECT_POSTS_BY_USER = "select * from Posts where userId = ? ORDER BY Posts.startDate DESC limit ? offset ?";
    private final String SQL_SELECT_POSTS_BY_STARTDATE = "select * from Posts where startDate = ? limit ? offset ?";
    private final String SQL_SELECT_POSTS_BY_ENDDATE = "select * from Posts where endDate = ? limit ? offset ?";
    private final String SQL_SELECT_POSTS_BY_NULL_ENDDATE = "select * from Posts where endDate IS NULL ORDER BY Posts.startDate DESC limit ? offset ?";
    private final String SQL_SELECT_POSTS_BY_CREATEDATE = "select * from Posts where createDate = ? limit ? offset ?";
    private final String SQL_SELECT_POSTS_BY_APPROVALDATE = "select * from Posts where approvalDate = ? limit ? offset ?";
    private final String SQL_SELECT_POSTS_BY_APPROVAL = "select * from Posts where approval = ? ORDER BY Posts.startDate DESC limit ? offset ?";
    private final String SQL_SELECT_POSTS_BY_CATEGORY = "select * from Posts where categoryId = ? ORDER BY Posts.startDate DESC limit ? offset ?";
    private final String SQL_SELECT_POSTS_BY_HASHTAG = "select * from Posts INNER JOIN postshashtags ON postshashtags.postId = posts.postId WHERE postshashtags.hashtagId = ? ORDER BY Posts.startDate DESC LIMIT ? offset ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //crud methods
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Post createPost(Post post) {
        jdbcTemplate.update(SQL_INSERT_POST,
                post.getUser().getUserId(),
                Timestamp.valueOf(post.getStartDate()),
                Timestamp.valueOf(post.getEndDate()),
                Timestamp.valueOf(post.getCreateDate()),
                Timestamp.valueOf(post.getApprovalDate()),
                post.getApproval(),
                post.getPostTitle(),
                post.getPostContent(),
                post.getCategory().getCategoryId());
        int postId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        post.setPostId(postId);
        return post;
    }

    @Override
    public Post getPostById(Integer postId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_POST, new PostMapper(), postId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Post> findAllPosts(int limit, int offset) {
        return jdbcTemplate.query(SQL_SELECT_POSTS, new PostMapper(), limit, offset);
    }

    @Override
    public Post updatePost(Post post) {
        try {
            jdbcTemplate.update(SQL_UPDATE_POST,
                    post.getUser().getUserId(),
                    Timestamp.valueOf(post.getStartDate()),
                    Timestamp.valueOf(post.getEndDate()),
                    Timestamp.valueOf(post.getCreateDate()),
                    Timestamp.valueOf(post.getApprovalDate()),
                    post.getApproval(),
                    post.getPostTitle(),
                    post.getPostContent(),
                    post.getCategory().getCategoryId(),
                    post.getPostId());
        } catch (NullPointerException e) {
        }
        return post;
    }

    @Override
    public void deletePost(Integer postId) throws BlogServiceException {
        jdbcTemplate.update(SQL_DELETE_POST, postId);
    }

    //relational methods:
    @Override
    public List<Post> findAllPostsByUser(User user, int limit, int offset) {
        return jdbcTemplate.query(SQL_SELECT_POSTS_BY_USER, new PostMapper(), user.getUserId(), limit, offset);
    }

    @Override
    public List<Post> findAllPostsByStartDate(LocalDateTime startDate, int limit, int offset) {
        return jdbcTemplate.query(SQL_SELECT_POSTS_BY_STARTDATE, new PostMapper(), startDate.toString(), limit, offset);
    }

    @Override
    public List<Post> findAllPostsByEndDate(LocalDateTime endDate, int limit, int offset) {
        if (endDate != null) {
            return jdbcTemplate.query(SQL_SELECT_POSTS_BY_ENDDATE, new PostMapper(), endDate.toString(), limit, offset);
        }
        return jdbcTemplate.query(SQL_SELECT_POSTS_BY_NULL_ENDDATE, new PostMapper(), limit, offset);
    }

    @Override
    public List<Post> findAllPostsByCreateDate(LocalDateTime createDate, int limit, int offset) {
        return jdbcTemplate.query(SQL_SELECT_POSTS_BY_CREATEDATE, new PostMapper(), createDate.toString(), limit, offset);
    }

    @Override
    public List<Post> findAllPostsByApprovalDate(LocalDateTime approvalDate, int limit, int offset) {
        return jdbcTemplate.query(SQL_SELECT_POSTS_BY_APPROVALDATE, new PostMapper(), approvalDate.toString(), limit, offset);
    }

    @Override
    public List<Post> findAllPostsByApproval(int approval, int limit, int offset) {
        return jdbcTemplate.query(SQL_SELECT_POSTS_BY_APPROVAL, new PostMapper(), approval, limit, offset);
    }

    @Override
    public List<Post> findAllPostsByCategory(Category category, int limit, int offset) {
        return jdbcTemplate.query(SQL_SELECT_POSTS_BY_CATEGORY, new PostMapper(), category.getCategoryId(), limit, offset);
    }

    @Override
    public List<Post> findAllPostsByHashtag(Hashtag hashtag, int limit, int offset) {
        return jdbcTemplate.query(SQL_SELECT_POSTS_BY_HASHTAG, new PostMapper(), hashtag.getHashtagId(), limit, offset);
    }

    private static final class PostMapper implements RowMapper<Post> {

        public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
            Post post = new Post();
            post.setPostId(rs.getInt("postId"));
            User user = new User();
            user.setUserId(rs.getInt("userId"));
            post.setUser(user);
            post.setStartDate(rs.getTimestamp("startDate").toLocalDateTime());
            if (rs.getTimestamp("endDate") != null) {
                post.setEndDate(rs.getTimestamp("endDate").toLocalDateTime());
            }
            post.setCreateDate(rs.getTimestamp("createDate").toLocalDateTime());
            if (rs.getTimestamp("approvalDate") != null) {
                post.setApprovalDate(rs.getTimestamp("approvalDate").toLocalDateTime());
            }
            post.setApproval(rs.getBoolean("approval"));
            post.setPostTitle(rs.getString("postTitle"));
            post.setPostContent(rs.getString("postContent"));
            Category category = new Category();
            category.setCategoryId(rs.getInt("categoryId"));
            post.setCategory(category);
            return post;
        }
    }

}
