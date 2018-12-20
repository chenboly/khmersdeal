package com.khmersdeal.khmersdeal.services;

import com.khmersdeal.khmersdeal.models.User;

import java.util.List;

public interface UserServices {
    List<User> getAllUsers(String username, String phone);
    int save (User user);
    int update (User user);
    int delete(Integer id);
}
