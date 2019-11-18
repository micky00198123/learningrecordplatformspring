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
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    @Transactional
    public JSONObject login(String studentId, String password) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isLogin",false);
        User user = userMapper.getLogin(studentId,password);
        if(user != null)
            jsonObject.put("isLogin",true);
        return jsonObject;
    }

    @Override
    public JSONObject personCentral(String studentId) {
        JSONObject jsonObject = new JSONObject();
        User login = userMapper.queryPersonalData(studentId);
        login.setPassword(null);
        jsonObject.put("UserMsg",login);
        jsonObject.put("Technologies",userMapper.queryTechnology(studentId));
        jsonObject.put("Departments",userMapper.queryDepartments(studentId));
        return jsonObject;
    }
}
