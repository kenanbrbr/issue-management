package com.kberber.issuemanagement.service.impl;

import com.kberber.issuemanagement.entity.User;
import com.kberber.issuemanagement.repository.UserRepository;
import com.kberber.issuemanagement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User save(User user) {
        if(user.getEmail()==null){
            throw new IllegalArgumentException("User email cannot be null!");
        }
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User getById(long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}
