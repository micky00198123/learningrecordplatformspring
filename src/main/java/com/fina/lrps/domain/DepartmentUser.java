package com.fina.lrps.domain;

import java.io.Serializable;

public class DepartmentUser implements Serializable {
    private String studentId;
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
                "studentId='" + studentId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", ifDelete='" + ifDelete + '\'' +
                ", ifMain='" + ifMain + '\'' +
                '}';
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
