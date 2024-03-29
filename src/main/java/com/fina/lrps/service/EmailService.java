package com.fina.lrps.service;

import com.fina.lrps.domain.vo.NoticeVo;

import java.util.Map;

public interface EmailService {

    /**
     * 发通知
     * @param noticeVo 通知
     * @return 状态码, 错误信息
     */
    Map<String, Object> sendEmail(NoticeVo noticeVo);

}
