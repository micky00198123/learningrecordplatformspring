package com.fina.lrps.dao;

import com.fina.lrps.domain.Department;
import com.fina.lrps.domain.Technology;
import com.fina.lrps.domain.User;
import com.fina.lrps.domain.UserDepartment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component("UserMapper")
public interface UserMapper {
    /**
     * 传入学生学号 密码
     * @param studentId
     * @param password
     * @return
     * 返回学生 对象 若密码或学号错误 返回User为null
     */
    public User getLogin(String studentId, String password);
    /**
     * 传入部门Id 返回该部门所有学生的List
     * @param departmentId
     * @return
     */
    List<Department> queryDepartments(String studentId);
    List<Technology> queryTechnology(String studentId);
}
