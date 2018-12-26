package com.khmersdeal.khmersdeal.controllers;

import com.khmersdeal.khmersdeal.models.User;
import com.khmersdeal.khmersdeal.services.UserServices;
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

    @GetMapping("/all")
    public String showAllusers(@RequestParam(required = false) String username, Model model){
        List<User> userList = this.userServices.getAllUsers(username);
        model.addAttribute("userList", userList);
        return "/admin/users/all-users";
    }
}
