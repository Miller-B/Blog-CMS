/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.ViewModel;

import Blog.Dto.Role;
import Blog.Dto.User;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class SingleUserViewModel {
    
    private User user;
    
    private List<Role> roles;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    
}
