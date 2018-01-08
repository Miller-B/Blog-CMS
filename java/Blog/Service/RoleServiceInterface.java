/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service;

import Blog.Dto.Role;
import Blog.Dto.User;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface RoleServiceInterface {
    
    // Role CRUD
    
    public Role createRole(Role role);
    
    public Role getRoleById(Integer roleId);
    
    public Role updateRole(Role role);
    
    public void deleteRole(Integer roleId) throws BlogServiceException;
    
    public List<Role> findAllRoles(int limit, int offset);
    
    // Relational
    
    public List<Role> findAllRolesByUser(User user, int limit, int offset);
    
    public List<Role> findAllRolesByUser(Integer userId, int limit, int offset);
    
}
