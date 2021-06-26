package com.se.dao;

import com.se.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
