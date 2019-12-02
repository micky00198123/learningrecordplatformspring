package com.fina.lrps.domain;

import java.util.List;

public class PersonCentral {
    private User user;
    private List<Department> department;
    private List<Technology> technology;
    public List<Technology> getTechnology() {
        return technology;
    }

    public void setTechnology(List<Technology> technology) {
        this.technology = technology;
    }

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }




}
