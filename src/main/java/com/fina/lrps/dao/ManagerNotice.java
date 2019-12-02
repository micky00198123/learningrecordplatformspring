package com.fina.lrps.dao;

import com.fina.lrps.domain.NoticeEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ManagerNotice {
    /**
     * 返回用户在限制条件下发送的通知集合
     * @param studentId 学号
     * @param scope 标签(部门号
     * @param timeLimit 时间限制
     * @return
     */
    List<NoticeEntity> getNotices(String studentId, String scope, String timeLimit);
    List<NoticeEntity> getDepartmentNotices(String departmentId);
}
