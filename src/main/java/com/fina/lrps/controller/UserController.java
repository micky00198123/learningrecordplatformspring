package com.fina.lrps.controller;

import com.alibaba.fastjson.JSONObject;
import com.fina.lrps.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired(required = false)
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(@Param("studentId") String studentId, @Param("password") String password,HttpServletRequest request){
        return userService.login(studentId,password).toJSONString();
    }
    @RequestMapping("/PersonCentral")
    @ResponseBody
    public String personCentral(HttpServletRequest request){
        HttpSession session = request.getSession();
        String studentId = (String) session.getAttribute("studentId");
        return userService.personCentral(studentId).toJSONString();
    }
}
