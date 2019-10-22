package com.fina.lrps.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String studentId;
    private String password;
    private String name;
    private String sex;
    private String grade;
    private String single;
    private String email;
    private String state;
    private Date registrationDate;
    private String portrait;
    private int punchClock;
    private String position;
    private String ifDelete;

    public User(){
        this.studentId = "0";
        this.password = "0";
        this.name = "匿名";
        this.sex = "男";
        this.grade = "2018";
        this.single = "是";
        this.email = "无";
        this.state = "实习";
        this.registrationDate = new Date(0000-00-00);
        this.portrait = null;
        this.punchClock  = 0;
        this.position = "成员";
        this.ifDelete = "否";
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public int getPunchClock() {
        return punchClock;
    }

    public void setPunchClock(int punchClock) {
        this.punchClock = punchClock;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIfDelete() {
        return ifDelete;
    }

    public void setIfDelete(String ifDelete) {
        this.ifDelete = ifDelete;
    }

    @Override
    public String toString() {
        return "User{" +
                "studentId='" + studentId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", grade='" + grade + '\'' +
                ", single='" + single + '\'' +
                ", email='" + email + '\'' +
                ", state='" + state + '\'' +
                ", registrationDate=" + registrationDate +
                ", portrait='" + portrait + '\'' +
                ", punchClock=" + punchClock +
                ", position='" + position + '\'' +
                ", ifDelete='" + ifDelete + '\'' +
                '}';
    }
}
