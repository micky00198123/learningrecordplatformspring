package com.fina.lrps.dao;

import com.fina.lrps.domain.User;
import com.fina.lrps.domain.DepartmentUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component("UserMapper")
@Repository
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
    public List<DepartmentUser> queryAllByDepartmentId(String departmentId);

    /**
     * 删除学生
     * 传入学生Id
     * @param studentId
     */
    public void deleteUser(String studentId);

    /**
     * 设置学生为主要成员
     * @param studentId
     */
    public void updateUserMain(String studentId);

    /**
     * 取消学生的主要成员身份
     * @param studentId
     */
    public void updateUserNotMain(String studentId);

    /**
     * 插入一个新的学生 其中User的Date不为空
     * @param departmentUser
     */
    public void insertUser(DepartmentUser departmentUser);
}
