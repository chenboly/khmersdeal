package com.khmersdeal.khmersdeal.services.impl;

import com.khmersdeal.khmersdeal.models.User;
import com.khmersdeal.khmersdeal.repositories.UserRepository;
import com.khmersdeal.khmersdeal.services.UserServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServicesImpl implements UserServices {
    private UserRepository userRepository;

    public UserServicesImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers(String username) {
        return this.userRepository.getAllUsers(username);
    }

    @Override
    public User getOneUser(Integer id) {
        return this.userRepository.getOneUser(id);
    }

    @Override
    public boolean save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public boolean update(User user) {
        return this.userRepository.update(user);
    }

    @Override
    public int delete(Integer id) {
        return this.userRepository.delete(id);
    }
}
