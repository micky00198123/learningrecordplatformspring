package com.fina.lrps.service;

import com.fina.lrps.domain.NoticeEntity;

import java.util.List;

public interface ManagerNoticesService {
    /**
     *
     * @param studentId
     * @param scope
     * @param timeLimit
     * @return
     */
    List<NoticeEntity> getNoticesList(String studentId, String scope, String timeLimit);
    List<NoticeEntity> getDepartmentNoticesList(String departmentId);
}
