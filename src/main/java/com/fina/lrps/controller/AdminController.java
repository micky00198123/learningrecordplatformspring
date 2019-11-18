package com.fina.lrps.controller;

import com.fina.lrps.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/changeAuthority")
    @ResponseBody
    public String changeAuthority(@Param("studentId") String studentId,@Param("position") String position){
        return adminService.changeAuthority(studentId,position).toJSONString();
    }

    @RequestMapping("/changeState")
    @ResponseBody
    public String changeState(@Param("studentId") String studentId,@Param("state") String state){
        return adminService.changeState(studentId,state).toJSONString();
    }

    @RequestMapping("/countMembers")
    @ResponseBody
    public String countMembers(){
        return adminService.countMembers().toJSONString();
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(@Param("studentId")String studentId){
        return adminService.deleteUser(studentId).toJSONString();
    }

    @RequestMapping("/getPersonalData")
    @ResponseBody
    public String getPersonalData(@Param("name")String name,@Param("state")String state,@Param("departmentName")String departmentName){
        return adminService.getPersonalData(name,state,departmentName).toJSONString();
    }



    @RequestMapping("/login")
    @ResponseBody
    public String login(@Param("studentId")String studentId,@Param("password") String password){
        return adminService.login(studentId,password).toJSONString();
    }
}
