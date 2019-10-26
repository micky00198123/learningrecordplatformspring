package com.fina.lrps.domain.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class NoticePo {

    // 通知编号
    private String noticeId;
    // 发件人学号
    private String userId;
    // 正文
    private String content;
    // 发送时间
    private Date sendingTime;
    // 标签
    private String label;


}
