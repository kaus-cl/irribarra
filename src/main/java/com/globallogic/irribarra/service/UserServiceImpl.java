package com.globallogic.irribarra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.irribarra.model.PhoneRepository;
import com.globallogic.irribarra.model.UserRepository;

import com.globallogic.irribarra.model.User;

/**
 * Group all the user services
 * 
 * @author M. Irribarra
 * @version 1.0
 * @since May 23, 2023
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private UserRepository userRepository;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public User create(User user){
        return userRepository.save(user);
    }
    
}
