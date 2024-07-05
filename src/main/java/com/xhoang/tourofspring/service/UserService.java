package com.xhoang.tourofspring.service;

import com.xhoang.tourofspring.dao.UserDao;
import com.xhoang.tourofspring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void saveUser(User user) {
        userDao.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userDao.findById(id);
    }

    // Other service methods...
}
