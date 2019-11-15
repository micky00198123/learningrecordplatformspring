package com.fina.lrps.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fina.lrps.dao.UserMapper;
import com.fina.lrps.domain.User;
import com.fina.lrps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component("UserService")
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

    @Override
    public void personCentralAdd(JSONObject jsonObject,String studentId,String password) {
        System.out.println("Service:" + studentId + "-" + password);
        jsonObject.put("UserMsg",userMapper.getLogin(studentId,password));
        System.out.println(jsonObject.get("UserMsg"));
        jsonObject.put("Technologies",userMapper.queryTechnology(studentId));
        System.out.println(jsonObject.get("Technologies"));
        jsonObject.put("Departments",userMapper.queryDepartments(studentId));
        System.out.println(jsonObject.get("Departments"));
    }
}
