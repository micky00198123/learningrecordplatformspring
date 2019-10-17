package com.qklt.lrps.service.impl;

import com.qklt.lrps.service.NoticeService;
import com.qklt.lrps.domain.Notice;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Override
    public String[] sendNoticeOnPlatform(Notice notice) {
        return new String[0];
    }

    @Override
    public String[] sendNoticeByEmail(Notice notice) {
        return new String[0];
    }
}
