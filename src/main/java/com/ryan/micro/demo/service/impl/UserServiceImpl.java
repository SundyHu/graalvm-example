package com.ryan.micro.demo.service.impl;

import com.ryan.micro.demo.model.User;
import com.ryan.micro.demo.repository.UserRepository;
import com.ryan.micro.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<User> findList() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(e -> users.add(e));
        return users;
    }
}
