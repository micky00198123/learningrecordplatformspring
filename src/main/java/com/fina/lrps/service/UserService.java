package com.fina.lrps.service;

import com.alibaba.fastjson.JSONObject;
import com.fina.lrps.domain.User;

public interface UserService {
    /**
     * 登录
     * @param studentId
     * @param password
     * @return
     */
    JSONObject login(String studentId, String password);
    JSONObject personCentral(String studentId);
}
