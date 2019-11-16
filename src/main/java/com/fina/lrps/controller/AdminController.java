package com.fina.lrps.controller;

import com.alibaba.fastjson.JSONObject;
import com.fina.lrps.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/changeAuthority")
    @ResponseBody
    public JSONObject changeAuthority(@Param("studentId") String studentId,@Param("position") String position){
        return adminService.changeAuthority(studentId,position);
    }

    @RequestMapping("/changeState")
    @ResponseBody
    public JSONObject changeState(@Param("studentId") String studentId,@Param("state") String state){
        return adminService.changeState(studentId,state);
    }

    @RequestMapping("/countMembers")
    @ResponseBody
    public JSONObject countMembers(){
        return adminService.countMembers();
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public JSONObject deleteUser(@Param("studentId")String studentId){
        return adminService.deleteUser(studentId);
    }

    @RequestMapping("/getPersonalData")
    @ResponseBody
    public JSONObject getPersonalData(@Param("name")String name,@Param("state")String state,@Param("departmentName")String departmentName){
        return adminService.getPersonalData(name,state,departmentName);
    }



    @RequestMapping("/login")
    @ResponseBody
    public JSONObject login(@Param("studentId")String studentId,@Param("password") String password){
        return adminService.login(studentId,password);
    }
}
