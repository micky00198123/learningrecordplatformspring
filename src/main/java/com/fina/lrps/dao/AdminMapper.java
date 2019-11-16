package com.fina.lrps.dao;

import com.fina.lrps.domain.Department;
import com.fina.lrps.domain.DepartmentMembers;
import com.fina.lrps.domain.SearchMember;
import com.fina.lrps.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("AdminMapper")
public interface AdminMapper {
    int updateUserPosition(String studentId,String position);
    int updateUserState(String studentId,String state);
    int deleteUser(String studentId);
    List<User> queryAllMember(String name);
    DepartmentMembers queryAllMembers(String departmentId);
    List<Department> queryAllDepartment();
    List<User> queryAllInternshipMembers();
    List<User> queryAllIncumbencyMembers();
    List<User> queryAllGraduatedMembers();
}
