/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao;

import Blog.Dto.Role;
import Blog.Dto.User;
import Blog.Service.BlogServiceException;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface RoleDaoInterface {

    public Role createRole(Role role);
    
    public Role getRoleById(Integer roleId);
    
    public List<Role> findAllRoles(int limit, int offset);
    
    public Role updateRole(Role role);
    
    public void deleteRole(Integer roleId) throws BlogServiceException;
    
    public List<Role> findAllRolesByUser(User user, int limit, int offset);
    
}
