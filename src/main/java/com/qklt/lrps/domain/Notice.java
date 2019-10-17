package com.qklt.lrps.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Notice {

    // 收件人id
    private String[] addressesId;
    // 发件人id
    private String userId;
    // 通知内容
    private String content;

}
