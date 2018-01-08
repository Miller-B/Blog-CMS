/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service;

import Blog.CommandModel.UserCommandModel;
import Blog.Dto.Role;
import Blog.Dto.User;
import Blog.ViewModel.SingleUserViewModel;
import Blog.ViewModel.UserViewModel;
import java.util.List;

/**
 *
 * @author jeffc
 */
public interface UserServiceInterface {
    
    // User CRUD methods
    
    public User createUser(User user);
    
    public User getUserById(Integer userId);
    
    public User updateUser(User user);
    
    public void deleteUser(Integer userId);
    
    public List<User> findAllUsers(int limit, int offset);
    
    // Query methods
    
    public List<User> findAllUsersByRole(Role role, int limit, int offset);
    
    public List<User> findAllUsersByRole(Integer roleId, int limit, int offset);
    
    // View methods
    
    public UserViewModel buildUserViewModelFromUser(User user, int userLimit, int userOffset);
    
    public User buildUserFromUserCommandModel(UserCommandModel ucm);
    
    public User createFirstUserAutomatically();
    
    public SingleUserViewModel buildSingleUserViewModelFromUserId(Integer userId);
    
}
