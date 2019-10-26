package com.fina.lrps.domain.enums;

public enum LabelType {

    ENTIRE("全体"),
    DEPARTMENT("部门"),
    PRIVATE("私信"),
    CEO("总裁"),
    MINISTER("部长"),
    MEMBER("成员");


    private String value;

    LabelType(String value) {
        this.value = value;
    }

}
