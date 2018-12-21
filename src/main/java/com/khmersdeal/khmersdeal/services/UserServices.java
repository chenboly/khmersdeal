package com.khmersdeal.khmersdeal.services;

import com.khmersdeal.khmersdeal.models.User;

import java.util.List;

public interface UserServices {
    List<User> getAllUsers(String username, String phone);
    User getOneUser (Integer id);
    boolean save (User user);
    boolean update (User user);
    int delete(Integer id);
}
