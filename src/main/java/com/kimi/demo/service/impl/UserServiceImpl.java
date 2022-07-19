package com.kimi.demo.service.impl;

import com.kimi.demo.entities.User;
import com.kimi.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public int login(String userName, String password) {
        if("kimi" == userName )
        return 1;
        else throw new RuntimeException();
    }

    @Override
    public User selectByPrimaryKey(int id) {
        return 0 == id ? null : new User(1,"kimi","kimi","kimi",1);
    }
}
