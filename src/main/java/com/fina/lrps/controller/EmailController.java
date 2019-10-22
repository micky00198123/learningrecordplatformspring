package com.fina.lrps.controller;

import com.alibaba.fastjson.JSON;
import com.fina.lrps.service.EmailService;
import com.fina.lrps.domain.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {

    private EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping(value = "/email/sendEmail")
    @ResponseBody
    public String sendNotice(Notice notice) {
        return JSON.toJSONString(emailService.sendEmail(notice));
    }



}
