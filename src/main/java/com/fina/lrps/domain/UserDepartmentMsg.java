package com.fina.lrps.domain;



public class UserDepartmentMsg {
    private UserDepartment userDepartment;
    private Department department;

    @Override
    public String toString() {
        return "UserDepartmentMsg{" +
                "userDepartment=" + userDepartment +
                ", department=" + department +
                '}';
    }

    public UserDepartment getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(UserDepartment userDepartment) {
        this.userDepartment = userDepartment;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
