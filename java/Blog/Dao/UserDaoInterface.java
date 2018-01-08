/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao;

import Blog.Dto.Role;
import Blog.Dto.User;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface UserDaoInterface {
    
    public User createUser(User user);
    
    public User getUserById(Integer userId);
    
    public List<User> findAllUsers(int limit, int offset);
    
    public User updateUser(User user);
    
    public void deleteUser(Integer userId);
    
    public List<User> findAllUsersByRole(Role role, int limit, int offset);
    
}
