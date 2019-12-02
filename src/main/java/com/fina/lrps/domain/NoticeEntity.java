package com.fina.lrps.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @author huangRui
 * @date 2019/11/17 1:23.
 */
public class  NoticeEntity {
    private String sendname;
    private String label;
    private String position;
    private String content;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sendtime;
    private List<String> getNoticeName;

    public String getSendname() {
        return sendname;
    }

    public void setSendname(String sendname) {
        this.sendname = sendname;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public List<String> getGetNoticeName() {
        return getNoticeName;
    }

    public void setGetNoticeName(List<String> getNoticeName) {
        this.getNoticeName = getNoticeName;
    }
}
