package com.fina.lrps.service;

import com.fina.lrps.domain.User;

public interface UserService {
    /**
     * 登录
     * @param studentId
     * @param password
     * @return
     */
    public User login(String studentId,String password);
}
