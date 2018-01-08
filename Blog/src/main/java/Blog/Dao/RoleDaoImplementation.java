/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao;

import Blog.Dto.Role;
import Blog.Dto.User;
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
 * @author EJB Laptop
 */
public class RoleDaoImplementation implements RoleDaoInterface {
    
      private static final String SQL_INSERT_ROLE = "INSERT INTO roles "
                                                 + "(roleName) "
                                                 + "VALUES(?)";

    private static final String SQL_SELECT_ROLE = "SELECT * FROM roles WHERE roleId = ? ";

    private static final String SQL_UPDATE_ROLE = "UPDATE roles SET "
                                                   + "roleName = ? WHERE roleId = ? ";

    private static final String SQL_DELETE_ROLE = "DELETE FROM roles WHERE roleId = ? ";

    private static final String SQL_FIND_ALL_ROLES = "SELECT * FROM roles LIMIT ? OFFSET ? ";

    private static final String SQL_FIND_ALL_ROLES_BY_USER = "SELECT r.* FROM roles r "
                                                            + "INNER JOIN users u ON r.roleId = u.roleId "
                                                            + "WHERE userId = ? LIMIT ? OFFSET ? ";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Role createRole(Role role) {
        jdbcTemplate.update(SQL_INSERT_ROLE,
                role.getRoleName());
        int roleId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        role.setRoleId(roleId);
        return role;
    }

    @Override
    public Role getRoleById(Integer roleId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ROLE,
                    new RoleDaoImplementation.RoleMapper(), roleId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Role> findAllRoles(int limit, int offset) {
        return jdbcTemplate.query(SQL_FIND_ALL_ROLES, new RoleMapper(), limit, offset);
    }

    @Override
    public Role updateRole(Role role) {
            jdbcTemplate.update(SQL_UPDATE_ROLE,
            role.getRoleName(),
            role.getRoleId());

        return role;
    }
    

    @Override
    public void deleteRole(Integer roleId) throws BlogServiceException  {
        try { jdbcTemplate.update(SQL_DELETE_ROLE, roleId); 
        }  catch (DataIntegrityViolationException de) {
            throw new BlogServiceException("Can not delete this role");
        }
        
    }

    @Override
    public List<Role> findAllRolesByUser(User user, int limit, int offset) {
        return jdbcTemplate.query(SQL_FIND_ALL_ROLES_BY_USER, new RoleMapper(), user.getUserId(), limit, offset);
    }

        private static final class RoleMapper implements RowMapper<Role> {

        public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
            Role role = new Role();
            role.setRoleId(rs.getInt("roleId"));
            role.setRoleName(rs.getString("roleName"));
            return role;
        }
    }
    
}
