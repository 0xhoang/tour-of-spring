package com.xhoang.tourofspring.dao.jpa;

import com.xhoang.tourofspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserDao extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
}