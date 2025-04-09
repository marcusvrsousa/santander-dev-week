package me.dio.santander_dev_week.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.santander_dev_week.model.User;
import me.dio.santander_dev_week.repository.UserRepository;
import me.dio.santander_dev_week.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
      return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        if(userRepository.existsByAccountNumber(user.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account Number already exists");
        }

        return userRepository.save(user);
    }

}
