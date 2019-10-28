package com.fina.lrps.controller;

import com.fina.lrps.domain.User;
import com.fina.lrps.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public User login(@Param("userId") String userId,@Param("password") String password){
        User user = null;
        return userService.login(userId,password);
    }
}
