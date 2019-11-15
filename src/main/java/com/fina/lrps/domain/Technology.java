package com.fina.lrps.domain;

public class Technology {
    private String technologyId;
    private String name;
    private String ifDelete;
    private String id;

    @Override
    public String toString() {
        return "Technology{" +
                "technologyId='" + technologyId + '\'' +
                ", name='" + name + '\'' +
                ", ifDelete='" + ifDelete + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId;
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
