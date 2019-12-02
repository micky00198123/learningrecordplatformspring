package com.fina.lrps.domain;

import lombok.Getter;
import lombok.Setter;

/**
* @author MLPFIM
* @date 2019/11/21
*/
@Setter
@Getter
// 一通知对多学号
public class NoticeUsers {

    // 通知编号
    private String noticeId;
    // 收件人学号
    private String[] addressesId;
}
