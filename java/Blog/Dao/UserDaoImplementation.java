/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao;

import Blog.Dto.Role;
import Blog.Dto.User;
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
public class UserDaoImplementation implements UserDaoInterface {

    // User CRUD prepared statements
    private final String SQL_INSERT_USER = "INSERT INTO Users (userName, userPassword, userEmail, roleId) VALUES (?,?,?,?)";
    private final String SQL_SELECT_USER = "SELECT * FROM Users where userId = ?";
    private final String SQL_SELECT_USERS = "SELECT * FROM Users LIMIT ? OFFSET ?";
    private final String SQL_UPDATE_USER = "UPDATE Users SET userName = ?, userPassword = ?, userEmail = ?, roleId = ? WHERE userId = ?";
    private final String SQL_DELETE_USER = "DELETE FROM Users WHERE userID = ?";
    // Relational queries
    private final String SQL_SELECT_USERS_BY_ROLE = "SELECT * FROM Users WHERE roleId = ? LIMIT ? OFFSET ?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    // CRUD methods
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User createUser(User user) {
        jdbcTemplate.update(SQL_INSERT_USER,
                user.getUserName(),
                user.getUserPassword(),
                user.getUserEmail(),
                user.getRole().getRoleId());
            int userId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
            user.setUserId(userId);
            return user;
    }
       

    @Override
    public User getUserById(Integer userId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_USER, 
                    new UserMapper(), userId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<User> findAllUsers(int limit, int offset) {
        return jdbcTemplate.query(SQL_SELECT_USERS, new UserMapper(), limit, offset);
    }

    @Override
    public User updateUser(User user) {
        jdbcTemplate.update(SQL_UPDATE_USER,
                user.getUserName(),
                user.getUserPassword(),
                user.getUserEmail(),
                user.getRole().getRoleId(),
                user.getUserId());
            return user;
    }

    @Override
    public void deleteUser(Integer userId) {
        jdbcTemplate.update(SQL_DELETE_USER, userId);
    }
    
    // relational methods:

    @Override
    public List<User> findAllUsersByRole(Role role, int limit, int offset) {
        return jdbcTemplate.query(SQL_SELECT_USERS_BY_ROLE, new UserMapper(), role.getRoleId(), limit, offset);
    }
    
    private static final class UserMapper implements RowMapper<User> {
        
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("userId"));
            user.setUserName(rs.getString("userName"));
            user.setUserPassword(rs.getString("userPassword"));
            user.setUserEmail(rs.getString("userEmail"));
            Role role = new Role();
            role.setRoleId(rs.getInt("roleId"));
            user.setRole(role);
            return user;
        }
    }
    
}
