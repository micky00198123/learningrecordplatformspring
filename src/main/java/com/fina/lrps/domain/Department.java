package com.fina.lrps.domain;

public class Department {
    private String departmentId;
    private String name;
    private String ifDelete;


    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", name='" + name + '\'' +
                ", ifDelete='" + ifDelete + '\'' +
                '}';
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIfDelete() {
        return ifDelete;
    }

    public void setIfDelete(String ifDelete) {
        this.ifDelete = ifDelete;
    }
}
