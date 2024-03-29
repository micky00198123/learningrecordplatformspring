package com.fina.lrps.service.impl;

import com.fina.lrps.dao.UserMapper;
import com.fina.lrps.domain.User;
import com.fina.lrps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    @Transactional
    public User login(String studentId, String password) {
        User user = null;
        user = userMapper.getLogin(studentId,password);
        return user;
    }
}
