package com.fina.lrps.domain;

/**
 * @author huangRui
 * @date 2019/10/18 10:45.
 */
public class DepartmentMember {
    private String studentId;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "DepartmentMember{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
