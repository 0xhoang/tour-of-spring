package com.xhoang.tourofspring.dao.interfaces;

import com.xhoang.tourofspring.model.User;

import java.util.Optional;

public interface UserDaoInterface {

    Optional<User> save(User user);

    Optional<User> findById(Long id);
}
