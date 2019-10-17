package com.qklt.lrps.service;

import com.qklt.lrps.domain.Notice;

public interface NoticeService {

    /**
     * 内部发通知
     * @param notice 通知
     * @return 失败人id, 若无则为0
     */
    String[] sendNoticeOnPlatform(Notice notice);

    // 外部发通知

    /**
     * 内部发通知
     * @param notice 通知
     * @return 失败人id, 若无则为0
     */
    String[] sendNoticeByEmail(Notice notice);

}
