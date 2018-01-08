/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service;

import Blog.Dao.RoleDaoInterface;
import Blog.Dto.Role;
import Blog.Dto.User;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class RoleServiceImplementation implements RoleServiceInterface {
    
    private RoleDaoInterface roleDao;
    
    private UserServiceInterface userService;
    
    public RoleServiceImplementation (RoleDaoInterface roleDao) {
        this.roleDao = roleDao;
    }
    
    public void setUserService(UserServiceInterface userService) {
        this.userService = userService;
    }

    @Override
    public Role createRole(Role role) {
        return roleDao.createRole(role);
    }

    @Override
    public Role getRoleById(Integer roleId) {
       return roleDao.getRoleById(roleId);
    }

    @Override
    public Role updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public void deleteRole(Integer roleId) throws BlogServiceException {
        roleDao.deleteRole(roleId);
    }

    @Override
    public List<Role> findAllRolesByUser(User user, int limit, int offset) {
       return roleDao.findAllRolesByUser(user, limit, offset);
    }

    @Override
    public List<Role> findAllRolesByUser(Integer userId, int limit, int offset) {
        return roleDao.findAllRolesByUser(userService.getUserById(userId), limit, offset);
    }

    @Override
    public List<Role> findAllRoles(int limit, int offset) {
        return roleDao.findAllRoles(limit, offset);
    }
    
}
