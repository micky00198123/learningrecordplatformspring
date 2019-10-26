package com.fina.lrps.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
// 一学号对多通知
public class UserNotices {

    // 收件人学号
    private String studentId;
    // 通知编号
    private String[] noticeId;

}
