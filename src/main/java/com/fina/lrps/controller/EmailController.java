package com.fina.lrps.controller;

import com.alibaba.fastjson.JSON;
import com.fina.lrps.domain.vo.NoticeVo;
import com.fina.lrps.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
* @author MLPFIM
* @date 2019/11/21
*/
@Controller
public class EmailController {

    private EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping(value = "/email/sendEmail")
    @ResponseBody
    public String sendNotice(@RequestBody @Valid NoticeVo noticeVo) {
        return JSON.toJSONString(emailService.sendEmail(noticeVo));
    }



}
