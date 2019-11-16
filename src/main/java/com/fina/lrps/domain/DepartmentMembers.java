package com.fina.lrps.domain;

import java.util.List;

public class DepartmentMembers {
    private String departmentId;
    private String departmentName;
    private List<User> members;

    @Override
    public String toString() {
        return "DepartmentMember{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", members=" + members +
                '}';
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }
}
