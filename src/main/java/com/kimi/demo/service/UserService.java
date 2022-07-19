package com.kimi.demo.service;

import com.kimi.demo.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    int login(String userName , String password);

    User selectByPrimaryKey(int id);
}
