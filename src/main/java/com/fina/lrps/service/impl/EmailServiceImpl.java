package com.fina.lrps.service.impl;

import com.fina.lrps.domain.Notice;
import com.fina.lrps.dao.EmailMapper;
import com.fina.lrps.domain.po.NoticePo;
import com.fina.lrps.domain.NoticeUsers;
import com.fina.lrps.domain.vo.NoticeVo;
import com.fina.lrps.service.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;

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
    public Map<String, Object> sendEmail(NoticeVo noticeVo) {
        Assert.notNull(noticeVo, "Notice param must not be null");

        // 结果集
        Map<String, Object> result = new HashMap<>();
        // 错误信息
        List<String> errorMessage = new ArrayList<>();
        boolean error = false;

        Notice notice = noticeVoToNotice(noticeVo);

        if(!sendEmailOnPlatform(notice)) {
            error = true;
            errorMessage.add("system");
        }
        if(!sendEmailOnMailbox(notice)) {
            error = true;
            errorMessage.add("mailbox");
        }

        if(error) {
            result.put("status", "0");
            result.put("errorMessage", errorMessage.toArray(new String[0]));
        } else {
            result.put("status", "1");
        }

        return result;
    }

    private Notice noticeVoToNotice(NoticeVo noticeVo) {
        Notice notice = new Notice();
        BeanUtils.copyProperties(noticeVo, notice);
        notice.setSendingTime(new Date());

        notice.setPosition(emailMapper.getPosition(notice.getUserId()));
        String label;
        int length = notice.getAddressesId().length;
        if(length == emailMapper.countLearningMember()-1) {
            label = "全体";
        } else if(length < 10) {
            label = "私信";
        } else {
            label = emailMapper.getMainDepartment(notice.getUserId());
        }
        notice.setLabel(label);

        return notice;
    }

    private NoticePo noticeToNoticePo(Notice notice) {
        NoticePo noticePo = new NoticePo();
        BeanUtils.copyProperties(notice, noticePo);
        String noticeId = String.valueOf(new Date().getTime());
        noticePo.setNoticeId(noticeId);
        return noticePo;
    }

    private boolean sendEmailOnPlatform(Notice notice) {
        NoticePo noticePo = noticeToNoticePo(notice);
        NoticeUsers noticeUsers = new NoticeUsers();
        noticeUsers.setNoticeId(noticePo.getNoticeId());
        noticeUsers.setAddressesId(notice.getAddressesId());

        try {
            emailMapper.insertNotice(noticePo);
            emailMapper.insertNoticeAndUser(noticeUsers);
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private boolean sendEmailOnMailbox(Notice notice) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(officialMailbox);
        message.setTo(notice.getAddressesId());
        message.setSubject(notice.getUserId() + "的一封邮件");
        message.setText(notice.getContent());

        try {
            mailSender.send(message);
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        // 成功返回空串
        return false;

    }

}
