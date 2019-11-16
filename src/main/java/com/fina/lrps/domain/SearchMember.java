package com.fina.lrps.domain;

import java.util.List;

public class SearchMember {
    private User member;
    private List<Department> departments;

    @Override
    public String toString() {
        return "SearchMember{" +
                "member=" + member +
                ", departments=" + departments +
                '}';
    }

    public User getMember() {
        return member;
    }

    public void setMember(User member) {
        this.member = member;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
