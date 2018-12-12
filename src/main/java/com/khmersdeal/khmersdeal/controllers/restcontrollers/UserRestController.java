package com.khmersdeal.khmersdeal.controllers.restcontrollers;

import com.khmersdeal.khmersdeal.models.User;
import com.khmersdeal.khmersdeal.services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody User user){
        int status = this.userServices.update(user);
        if(status > 0){
            return ResponseEntity.ok("Update User Successfully!!");
        }return new ResponseEntity<>("Update User Failed!!", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable ("id") Integer id){
        int status = this.userServices.delete(id);
        if(status > 0){
            return ResponseEntity.ok("Delete User Successfully!!");
        }return new ResponseEntity<>("Delete User Failed!!", HttpStatus.NOT_FOUND);
    }
}
