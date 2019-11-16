package com.fina.lrps.domain;

public class DepartmentMembersView {
    private String departmentName;
    private String departmentId;
    private int memberCount;

    @Override
    public String toString() {
        return "DepartmentMembersView{" +
                "departmentName='" + departmentName + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", memberCount=" + memberCount +
                '}';
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }
}
