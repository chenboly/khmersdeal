package com.khmersdeal.khmersdeal.controllers.restcontrollers;

import com.khmersdeal.khmersdeal.models.User;
import com.khmersdeal.khmersdeal.services.UserServices;
import com.khmersdeal.khmersdeal.services.impl.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
    private UserServices userServices;

    public UserRestController(UserServices userServices) {
        this.userServices = userServices;
    }


    @GetMapping("")
    public List<User> getAllUsers(String username){
        return this.userServices.getAllUsers(username);
    }

//    @GetMapping("/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getOneUser (@PathVariable("id") Integer id){
        Map<String, Object> response = new HashMap<>();
        User user = this.userServices.getOneUser(id);
        response.put("data", user);
        response.put("message", "Get User Successfully");
        response.put("status", true);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> save(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        boolean status = this.userServices.save(user);
        if (status) {
            response.put("message", "Save user successfully!!");
            response.put("user", user);
            response.put("status", true);
            return ResponseEntity.ok(response);
        }
        response.put("message", "Save user failed!!");
        response.put("status", false);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("")
    public ResponseEntity<Map<String, Object>> update(@RequestBody User user){
        Map<String, Object> response = new HashMap<>();
        boolean status = this.userServices.update(user);
        if(status){
            response.put("message","Update User Successfully!!");
            response.put("status", true);
        }return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable ("id") Integer id){
        int status = this.userServices.delete(id);
        if(status > 0){
            return ResponseEntity.ok("Delete User Successfully!!");
        }return new ResponseEntity<>("Delete User Failed!!", HttpStatus.NOT_FOUND);
    }



}
