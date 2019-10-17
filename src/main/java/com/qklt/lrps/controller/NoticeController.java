package com.qklt.lrps.controller;

import com.qklt.lrps.service.NoticeService;
import com.qklt.lrps.domain.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NoticeController {

    private NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @PostMapping(value = "/notice/sendNotice")
    @ResponseBody
    public String sendNotice(Notice notice) {

        noticeService.sendNoticeOnPlatform(notice);

        return null;
    }



}
