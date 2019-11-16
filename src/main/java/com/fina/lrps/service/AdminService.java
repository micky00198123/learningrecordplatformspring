package com.fina.lrps.service;

import com.alibaba.fastjson.JSONObject;

public interface AdminService {
    JSONObject changeAuthority(String studentId, String position);
    JSONObject changeState(String studentId,String state);
    JSONObject countMembers();
    JSONObject deleteUser(String studentId);
    JSONObject getPersonalData(String name,String state,String departmentName);
    JSONObject login(String studentId,String password);
}
