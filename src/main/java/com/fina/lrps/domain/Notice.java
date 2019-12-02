package com.fina.lrps.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
* @author MLPFIM
* @date 2019/11/21
*/
@Setter
@Getter
@ToString
public class Notice {

    // 发件人学号
    private String studentId;
    // 收件人学号
    private String[] addressesId;
    // 正文
    private String content;
    // 发送时间
    private Date sendingTime;
    // 标签
    private String label;
    // 发件人职位
    private String position;

}
