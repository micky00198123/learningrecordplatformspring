package com.fina.lrps.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fina.lrps.dao.UserMapper;
import com.fina.lrps.domain.PersonCentral;
import com.fina.lrps.domain.User;
import com.fina.lrps.service.UserService;
import com.fina.lrps.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpServletResponse;

@Component("UserService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public JSONObject login(String studentId, String password, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isLogin",false);
        User user = userMapper.getLogin(studentId,password);
        if(user != null){
            jsonObject.put("isLogin",true);
            response.setHeader("accessHeader", JwtUtil.getToken(studentId));
        }
        return jsonObject;
    }

    @Override
    public JSONObject personCentral(String studentId) {
        JSONObject jsonObject = new JSONObject();
        User login = userMapper.queryPersonalData(studentId);
        login.setPassword(null);
        jsonObject.put("UserMsg",login);
        PersonCentral personCentral = new PersonCentral();
        personCentral.setDepartment(userMapper.queryDepartments(studentId));
        personCentral.setTechnology(userMapper.queryTechnology(studentId));
        jsonObject.put("PersonCentral",personCentral);
        return jsonObject;
    }
}
