package com.fina.lrps.service;

import com.alibaba.fastjson.JSONObject;
import com.fina.lrps.domain.User;

import javax.servlet.http.HttpServletResponse;

public interface UserService {
    /**
     * 登录
     * @param studentId
     * @param password
     * @return
     */
    JSONObject login(String studentId, String password, HttpServletResponse response);
    JSONObject personCentral(String studentId);
}
