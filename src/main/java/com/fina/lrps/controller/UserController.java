package com.fina.lrps.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fina.lrps.domain.User;
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
    public JSONObject login(@Param("studentId") String studentId, @Param("password") String password,HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isLogin",false);
        User user = userService.login(studentId,password);
        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("studentId",studentId);
            session.setAttribute("password",password);
            session.setAttribute("isLogin",true);
            jsonObject.put("isLogin",true);
        }
        return jsonObject;
    }
    @RequestMapping("/PersonCentral")
    @ResponseBody
    public JSONObject personCentral(HttpServletRequest request){
        HttpSession session = request.getSession();
        String studentId = (String) session.getAttribute("studentId");
        String password = (String)session.getAttribute("password");
        System.out.println("StudentId:" + studentId);
        System.out.println("Password:" + password);
        JSONObject jsonObject = new JSONObject();
        userService.personCentralAdd(jsonObject,studentId,password);
        return jsonObject;
    }
}
