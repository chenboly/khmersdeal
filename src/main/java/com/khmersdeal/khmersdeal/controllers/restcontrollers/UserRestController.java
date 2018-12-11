package com.khmersdeal.khmersdeal.controllers.restcontrollers;

import com.khmersdeal.khmersdeal.models.User;
import com.khmersdeal.khmersdeal.services.UserServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
    private UserServices userServices;

    public UserRestController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("")
    public List<User> getAllUsers(){
        return this.userServices.getAllUsers();
    }

    @PostMapping("")
    public String save(@RequestBody User user){
        int status = this.userServices.save(user);
        if(status > 0){
            return "Save user successfully!!";
        }
        return "Save user failed!!";
    }
}
