/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Controller;

import Blog.CommandModel.UserCommandModel;
import Blog.Dto.Role;
import Blog.Dto.User;
import Blog.Service.UserServiceInterface;
import Blog.ViewModel.SingleUserViewModel;
import Blog.ViewModel.UserViewModel;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jeffc
 */
@Controller
@RequestMapping({"AdminManageUsers"})
public class UserController {

    private UserServiceInterface userService;

    public UserController(UserServiceInterface userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/displayUserPage", method = RequestMethod.GET)
    public String displayUserPage(Model model) {

        UserViewModel uvm = userService.buildUserViewModelFromUser(
                userService.createFirstUserAutomatically(), 100, 0);

        model.addAttribute("uvm", uvm);
        return "/AdminManageUsers";

    }

    @RequestMapping(value = "/displayRegistrationPage", method = RequestMethod.GET)
    public String displayRegistrationPage(Model model) {

        return "/Registration";

    }

    @RequestMapping(value = "/CreateUser", method = RequestMethod.POST)
    public String createUser(@Valid @ModelAttribute("ucm") UserCommandModel ucm, BindingResult result) {

        User user = userService.buildUserFromUserCommandModel(ucm);
        Role role = new Role();
        role.setRoleId(3);
        user.setRole(role);
        user = userService.createUser(user);

        return "redirect:/";

    }

    @RequestMapping(value = "/displayUpdateUserPage", method = RequestMethod.GET)
    public String displayUpdateUserPage(@RequestParam("userId") Integer userId, Model model) {

        SingleUserViewModel suvm = userService.buildSingleUserViewModelFromUserId(userId);
        model.addAttribute("suvm", suvm);

        return "/UpdateUser";

    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String updateUser(@Valid @ModelAttribute("ucm") UserCommandModel ucm, BindingResult result, Model model) {

        User user = userService.buildUserFromUserCommandModel(ucm);
        user = userService.updateUser(user);

        UserViewModel uvm = userService.buildUserViewModelFromUser(
        userService.createFirstUserAutomatically(), 100, 0);

        model.addAttribute("uvm", uvm);
        
        return "/AdminManageUsers";

    }

    @RequestMapping(value = "/displayDeleteUserPage", method = RequestMethod.GET)
    public String displayDeleteUserPage(@RequestParam("userId") Integer userId, Model model) {

        model.addAttribute("userId", userId);

        return "/DeleteUser";

    }

    @RequestMapping(value = "/DeleteUser", method = RequestMethod.POST)
    public String deleteUser(@RequestParam("userId") Integer userId, Model model) {

        try {
            userService.deleteUser(userId);
        } catch (Exception e) {

        }

        UserViewModel uvm = userService.buildUserViewModelFromUser(
        userService.createFirstUserAutomatically(), 100, 0);

        model.addAttribute("uvm", uvm);
        return "/AdminManageUsers";

    }

}
