package com.fina.lrps.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Notice {

    // 发件人id
    private String userId;
    // 收件人id
    private String[] addressesId;
    // 通知内容
    private String content;
    // 发送时间
    private Date date;
    // 标签
    private String[] label;

}
