package com.fina.lrps.domain;

import java.io.Serializable;

public class DepartmentUser implements Serializable {
    private User user;
    private String departmentId;
    private String ifDelete;
    private String ifMain;

    public DepartmentUser(){
        this.ifDelete = "否";
        this.ifMain = "否";
    }

    @Override
    public String toString() {
        return "DepartmentUser{" +
                "user=" + user +
                ", departmentId='" + departmentId + '\'' +
                ", ifDelete='" + ifDelete + '\'' +
                ", ifMain='" + ifMain + '\'' +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getIfDelete() {
        return ifDelete;
    }

    public void setIfDelete(String ifDelete) {
        this.ifDelete = ifDelete;
    }

    public String getIfMain() {
        return ifMain;
    }

    public void setIfMain(String ifMain) {
        this.ifMain = ifMain;
    }
}
