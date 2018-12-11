package com.khmersdeal.khmersdeal.services;

import com.khmersdeal.khmersdeal.models.User;

import java.util.List;

public interface UserServices {
    List<User> getAllUsers();
    int save (User user);
}
