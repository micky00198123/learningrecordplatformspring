package com.fina.lrps.service.impl;

import com.fina.lrps.domain.Notice;
import com.fina.lrps.dao.EmailMapper;
import com.fina.lrps.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@PropertySource("classpath:application.properties")
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String officialMailbox;

    private JavaMailSender mailSender;
    private EmailMapper emailMapper;

    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender, EmailMapper emailMapper) {
        this.mailSender = mailSender;
        this.emailMapper = emailMapper;
    }

    @Override
    public Map<String, Object> sendEmail(Notice notice) {
        Assert.notNull(notice, "Notice param must not be null");

        Map<String, Object> result = new HashMap<>();
        List<String> errorMessage = new ArrayList<>();
        boolean error = false;
        String[] platformFailures;
        String[] emailFailures;

        platformFailures = sendEmailOnPlatform(notice);
        //emailFailures = sendEmailOnMailbox(notice);

        if(platformFailures == null || platformFailures.length > 0) {
            error = true;
            errorMessage.add("system");
        }
//        if(emailFailures == null || emailFailures.length > 0) {
//            error = true;
//            errorMessage.add("mailbox");
//        }

        if(error) {
            result.put("status", "0");
            result.put("errorMessage", errorMessage.toArray(new String[0]));
            // failureId实际上只有内部系统的failures
            result.put("failureId",
                    platformFailures == null ? new String[0] : platformFailures);
        } else {
            result.put("status", "1");
        }

        return result;
    }

    @Override
    public String[] sendEmailOnPlatform(Notice notice) {

        String mainDepartment = emailMapper.getMainDepartment("111");

        System.out.println(mainDepartment);

        return new String[0];
    }

    @Override
    public String[] sendEmailOnMailbox(Notice notice) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(officialMailbox);
        message.setTo(notice.getAddressesId());
        message.setSubject(notice.getUserId() + "的一封邮件");
        message.setText(notice.getContent());

        try {
            mailSender.send(message);
        } catch(Exception e) {
            e.printStackTrace();
            // 失败返回空
            return null;
        }
        // 成功返回空串
        return new String[0];

    }

}