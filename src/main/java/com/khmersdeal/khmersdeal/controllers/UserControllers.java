package com.khmersdeal.khmersdeal.controllers;

import com.khmersdeal.khmersdeal.models.User;
import com.khmersdeal.khmersdeal.services.UserServices;
import com.khmersdeal.khmersdeal.utilities.Paginate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class UserControllers {

    private UserServices userServices;
    public UserControllers(UserServices userServices) {
        this.userServices = userServices;
    }

//    list all user without pagination
    @GetMapping("/all")
    public String showAllusers(@RequestParam(required = false) String fullname, Model model){
        List<User> users = this.userServices.getAllUsers(fullname);
        model.addAttribute("userList", users);
        return "/admin/users/all-users";
    }

    //list all users with pagination
    @GetMapping("/all/paginate")
    public String showAllusersPaginate(@RequestParam(required = false) String username, Model model, Paginate paginate){
        if (username == null)
            username="";
        int totalRecord = this.userServices.count(username);
        paginate.setTotalCount(totalRecord);
        List<User> users = this.userServices.getAllUsersPaginate(username, paginate);
        model.addAttribute("userList", users);
        model.addAttribute("pagination", paginate);
        model.addAttribute("usernameFilter", username);
        return "/admin/users/all-users";
    }

    @GetMapping("/add")
    public String showSaveUserForm (Model model){
        model.addAttribute("user", new User());
        return "/admin/users/add-user";
    }





}
