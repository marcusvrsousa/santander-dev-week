package me.dio.santander_dev_week.service;

import java.util.List;

import me.dio.santander_dev_week.model.User;

public interface UserService {

    List<User> findAll();
    User findById(Long id);
    User create(User user);
}
