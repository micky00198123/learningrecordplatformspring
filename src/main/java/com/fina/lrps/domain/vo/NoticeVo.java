package com.fina.lrps.domain.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class NoticeVo {

    // 发件人学号
    String userId;
    // 收件人学号
    String[] addressesId;
    // 正文
    String content;

}
