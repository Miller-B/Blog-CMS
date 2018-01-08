/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao;

import Blog.Dto.StaticPage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author EJB Laptop
 */
public class StaticPageDaoImplementation implements StaticPageDaoInterface {
    
    private static String SQL_INSERT_STATICPAGE = "INSERT INTO StaticPages (staticPageTitle, staticPageContent) VALUES (?, ?)";
    private static String SQL_SELECT_STATICPAGE = "SELECT * FROM StaticPages WHERE staticPageId = ?";
    private static String SQL_UPDATE_STATICPAGE = "UPDATE StaticPages SET staticPageTitle = ?, staticPageContent = ? WHERE staticPageId = ?";
    private static String SQL_DELETE_STATICPAGE = "DELETE FROM StaticPages WHERE staticPageId = ?";
    private static String SQL_FIND_ALL_STATICPAGES = "SELECT * FROM StaticPages limit ? offset ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //crud methods:
    
    @Override
    public StaticPage createStaticPage(StaticPage staticPage) {
        jdbcTemplate.update(SQL_INSERT_STATICPAGE,
            staticPage.getStaticPageTitle(), 
            staticPage.getStaticPageContent()); 
        int staticPageId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        staticPage.setStaticPageId(staticPageId);
        return staticPage;
    }

    @Override
    public StaticPage getStaticPageById(Integer staticPageId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_STATICPAGE, new StaticPageMapper(), staticPageId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<StaticPage> findAllStaticPages(int limit, int offset) {
        return jdbcTemplate.query(SQL_FIND_ALL_STATICPAGES, new StaticPageMapper(), limit, offset);
        }

    @Override
    public StaticPage updateStaticPage(StaticPage staticPage) {
        jdbcTemplate.update(SQL_UPDATE_STATICPAGE,
            staticPage.getStaticPageTitle(),
            staticPage.getStaticPageContent(),
            staticPage.getStaticPageId());
        return staticPage;
    }

    @Override
    public void deleteStaticPage(Integer staticPageId) {
        jdbcTemplate.update(SQL_DELETE_STATICPAGE, staticPageId);
    }

    private static final class StaticPageMapper implements RowMapper<StaticPage> {
        public StaticPage mapRow(ResultSet rs, int rowNum) throws SQLException {
            StaticPage staticPage = new StaticPage();
            staticPage.setStaticPageId(rs.getInt("staticPageId"));
            staticPage.setStaticPageTitle(rs.getString("staticPageTitle"));
            staticPage.setStaticPageContent(rs.getString("staticPageContent"));
            return staticPage;
        }
    }
    
}
