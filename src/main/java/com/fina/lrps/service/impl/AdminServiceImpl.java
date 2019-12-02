package com.fina.lrps.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fina.lrps.dao.AdminMapper;
import com.fina.lrps.dao.UserMapper;
import com.fina.lrps.domain.*;
import com.fina.lrps.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public JSONObject changeAuthority(String studentId, String position) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",false);
        if((position.equals("成员") || position.equals("部长") || position.equals("总裁")) && userMapper.queryPersonalData(studentId) != null){
            adminMapper.updateUserPosition(studentId, position);
            jsonObject.put("status",true);
        }
        return jsonObject;
    }

    @Override
    public JSONObject changeState(String studentId, String state) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",false);
        if((state.equals("实习") || state.equals("学习") || state.equals("结业") || state.equals("离开")) && userMapper.queryPersonalData(studentId) != null ){
            adminMapper.updateUserState(studentId, state);
            jsonObject.put("status",true);
        }
        return jsonObject;
    }

    @Override
    public JSONObject countMembers() {
        JSONObject jsonObject = new JSONObject();
        List<Department> ds = adminMapper.queryAllDepartment();
        List<DepartmentMembersView> departments = new ArrayList<>(ds.size());
        for(int i = 0;i < ds.size();i++){
            DepartmentMembersView departmentMembersView = new DepartmentMembersView();
            DepartmentMembers departmentMembers = adminMapper.queryAllMembers(ds.get(i).getDepartmentId());
            departmentMembersView.setDepartmentId(departmentMembers.getDepartmentId());
            departmentMembersView.setDepartmentName(departmentMembers.getDepartmentName());
            departmentMembersView.setMemberCount(departmentMembers.getMembers().size());
            departments.add(departmentMembersView);
        }
        jsonObject.put("departments",departments);
        jsonObject.put("all",adminMapper.queryAllGraduatedMembers().size() + adminMapper.queryAllIncumbencyMembers().size());
        jsonObject.put("Internship",adminMapper.queryAllInternshipMembers().size());
        jsonObject.put("Incumbency",adminMapper.queryAllIncumbencyMembers().size());
        return jsonObject;
    }

    @Override
    public JSONObject deleteUser(String studentId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",false);
        adminMapper.deleteUser(studentId);
        System.out.println(studentId);
        List<Technology> technologies = userMapper.queryTechnology(studentId);
        int preRows = 0;
        for (Technology te :technologies){
            preRows += userMapper.deleteUserTechnology(te.getTechnologyId());
        }
        if( preRows == technologies.size())
            jsonObject.put("status",true);
        return jsonObject;
    }

    @Override
    public JSONObject getPersonalData(String name, String state, String departmentName) {
        JSONObject jsonObject = new JSONObject();
        List<User> users = adminMapper.queryAllMember(name);
        List<SearchMember> searchMembers = new ArrayList<>();
        for (User user:users) {
            if(user.getState().equals(state) || state == null){
                List<Department> departments = userMapper.queryDepartments(user.getStudentId());
                if (departmentName == null){
                    SearchMember searchMember = new SearchMember();
                    searchMember.setMember(user);
                    searchMember.setDepartments(departments);
                    searchMembers.add(searchMember);
                }else{
                    for (Department d:departments) {
                        if (d.getName().equals(departmentName)){
                            SearchMember searchMember = new SearchMember();
                            searchMember.setMember(user);
                            searchMember.setDepartments(departments);
                            searchMembers.add(searchMember);
                            break;
                        }
                    }
                }
            }
        }
        jsonObject.put("searchMembers",searchMembers);
        return jsonObject;
    }

    @Override
    public JSONObject login(String studentId, String password) {
        User login = userMapper.getLogin(studentId, password);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",true);
        if (login.getPosition().equals("成员"))
            jsonObject.put("status",false);
        return jsonObject;
    }

}
