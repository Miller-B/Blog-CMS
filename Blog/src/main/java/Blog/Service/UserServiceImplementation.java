/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service;

import Blog.CommandModel.UserCommandModel;
import Blog.Dao.UserDaoInterface;
import Blog.Dto.Role;
import Blog.Dto.User;
import Blog.ViewModel.SingleUserViewModel;
import Blog.ViewModel.UserViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class UserServiceImplementation implements UserServiceInterface {

    private UserDaoInterface userDao;
    
    private RoleServiceInterface roleService;
    private CategoryServiceInterface categoryService;
    private StaticPageServiceInterface staticPageService;
  
    public UserServiceImplementation(UserDaoInterface userDao) {
        this.userDao = userDao;
    }
    
    public void setRoleService(RoleServiceInterface roleService) {
        this.roleService = roleService;
    }
    
    public void setCategoryService(CategoryServiceInterface categoryService) {
        this.categoryService = categoryService;
    }
    
    public void setStaticPageService(StaticPageServiceInterface staticPageService) {
        this.staticPageService = staticPageService;
    }    
    
    @Override
    public User createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public List<User> findAllUsers(int limit, int offset) {
        return userDao.findAllUsers(limit, offset);
    }


    // Relational methods
    
    @Override
    public List<User> findAllUsersByRole(Role role, int limit, int offset) {
        return userDao.findAllUsersByRole(role, limit, offset);
    }

    @Override
    public List<User> findAllUsersByRole(Integer roleId, int limit, int offset) {
        return userDao.findAllUsersByRole(roleService.getRoleById(roleId), limit, offset);
    }

    // View methods
    
    @Override
    public UserViewModel buildUserViewModelFromUser(User user, int userLimit, int userOffset) {
        UserViewModel uvm = new UserViewModel();
        user.setRole(roleService.getRoleById(user.getRole().getRoleId()));
        uvm.setSelectedUser(user);
        List<User> users = this.findAllUsers(userLimit, userOffset);
        List<User> usersWithRoles = new ArrayList<>();
        for (User currentUser : users) {
            currentUser.setRole(roleService.getRoleById(currentUser.getRole().getRoleId()));
            usersWithRoles.add(currentUser);
        }
        uvm.setUsers(usersWithRoles);
        uvm.setCategories(categoryService.findAllCategories(Integer.MAX_VALUE, 0));
        uvm.setStaticPages(staticPageService.findAllStaticPages(Integer.MAX_VALUE, 0));
        return uvm;
    }

    @Override
    public User buildUserFromUserCommandModel(UserCommandModel ucm) {
        User user = new User();
        if (ucm.getUserId() != null) {
            user.setUserId(ucm.getUserId());
        }
        user.setUserName(ucm.getUserName());
        user.setUserPassword(ucm.getUserPassword());
        user.setUserEmail(ucm.getUserEmail());
        user.setRole(roleService.getRoleById(ucm.getRoleId()));
        return user;
    }
    
    @Override
    public User createFirstUserAutomatically() {
        User user = new User();
        user.setUserName("Default User");
        user.setUserPassword("Default Password");
        user.setUserEmail("default@email.com");
        Role role = new Role();
        role.setRoleId(1);
        user.setRole(role);
        return user;
    }

    @Override
    public SingleUserViewModel buildSingleUserViewModelFromUserId(Integer userId) {

        SingleUserViewModel suvm = new SingleUserViewModel();
        suvm.setUser(this.getUserById(userId));
        suvm.setRoles(roleService.findAllRoles(Integer.MAX_VALUE, 0));
        return suvm;
    }
    
}
