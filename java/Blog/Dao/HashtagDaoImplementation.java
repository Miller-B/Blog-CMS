/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao;

import Blog.Dto.Hashtag;
import Blog.Dto.Post;
import Blog.Service.BlogServiceException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author
 */
public class HashtagDaoImplementation implements HashtagDaoInterface {
    
    private static final String SQL_INSERT_HASHTAG = "INSERT INTO hashtags "
                                                    + "(tagName) "
                                                    + "VALUES(?)";
            
    private static final String SQL_SELECT_HASHTAG = "SELECT * FROM hashtags WHERE hashtagId = ? ";
            
    private static final String SQL_UPDATE_HASHTAG = "UPDATE hashtags SET "
                                                    + "tagName = ? WHERE hashtagId = ? ";
            
    private static final String SQL_DELETE_HASHTAG = "DELETE FROM hashtags WHERE hashtagId = ? ";
   
    private static final String SQL_FIND_ALL_HASHTAGS = "SELECT * FROM hashtags LIMIT ? OFFSET ? ";
    
    private static final String SQL_FIND_ALL_HASHTAGS_BY_POST = "SELECT h.* FROM hashtags h "
                                                                + "INNER JOIN postshashtags ph ON h.hashtagId = ph.hashtagId "
                                                                + "WHERE ph.postId = ? LIMIT ? OFFSET ? ";
 
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
     this.jdbcTemplate = jdbcTemplate;
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Hashtag createHashtag(Hashtag hashtag) {
       jdbcTemplate.update(SQL_INSERT_HASHTAG, 
               hashtag.getTagName());
       int hashtagId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
       hashtag.setHashtagId(hashtagId);
       return hashtag;



    }

    @Override
    public Hashtag getHashtagById(Integer hashtagId) {
        try {
      return jdbcTemplate.queryForObject(SQL_SELECT_HASHTAG,
      new HashtagMapper(), hashtagId);
       } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Hashtag> findAllHashtags(int limit, int offset) {
        return jdbcTemplate.query(SQL_FIND_ALL_HASHTAGS, new HashtagMapper(), limit, offset);
    }

    @Override
    public Hashtag updateHashtag(Hashtag hashtag) {
        jdbcTemplate.update(SQL_UPDATE_HASHTAG,
            hashtag.getTagName(),
            hashtag.getHashtagId());

        return hashtag;
    }


     @Override
    public void deleteHashtag(Integer hashtagId) throws BlogServiceException  {
        try { jdbcTemplate.update(SQL_DELETE_HASHTAG, hashtagId); 
        }  catch (DataIntegrityViolationException de) {
            throw new BlogServiceException("Can not delete this hashtag");
        }
    }

    @Override
    public List<Hashtag> findAllHashtagsByPost(Post post, int limit, int offset) {
        return jdbcTemplate.query(SQL_FIND_ALL_HASHTAGS_BY_POST, new HashtagMapper(), post.getPostId(), limit, offset);
    }

    

    private static final class HashtagMapper implements RowMapper<Hashtag> {

        public Hashtag mapRow(ResultSet rs, int rowNum) throws SQLException {
            Hashtag hashtag = new Hashtag();
            hashtag.setHashtagId(rs.getInt("hashtagId"));
            hashtag.setTagName(rs.getString("tagName"));
            return hashtag;
        }
    }
    
}
