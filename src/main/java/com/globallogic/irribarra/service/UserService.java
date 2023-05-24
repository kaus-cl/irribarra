package com.globallogic.irribarra.service;

import com.globallogic.irribarra.model.User;

/**
 * Abstract layer for User services
 * 
 * @author M. Irribarra
 * @version 1.0
 * @since May 23, 2023
 */
public interface UserService {

    /**
     * Creates a new user
     * 
     * @param user User
     * @return
     */
    public User create(User user);
}
