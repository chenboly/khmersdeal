package com.khmersdeal.khmersdeal.services;

import com.khmersdeal.khmersdeal.models.User;
import com.khmersdeal.khmersdeal.utilities.Paginate;

import java.util.List;

public interface UserServices {
    List<User> getAllUsers(String fullname);
    List<User> getAllUsersPaginate(String username, Paginate paginate);
    int count(String username);
    User getOneUser (Integer id);
    boolean save (User user);
    boolean update (User user);
    int delete(Integer id);
}
