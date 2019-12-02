package com.fina.lrps.service.impl;

import com.fina.lrps.dao.ManagerNotice;
import com.fina.lrps.domain.NoticeEntity;
import com.fina.lrps.service.ManagerNoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huangRui
 * @date 2019/11/17 18:26.
 */
@Service
public class MangerNoticesServiceImpl implements ManagerNoticesService {

    @Autowired
    ManagerNotice managerNotice;
    @Override
    public List<NoticeEntity> getNoticesList(String studentId, String scope, String timeLimit) {
        return managerNotice.getNotices(studentId, scope, timeLimit);
    }

    @Override
    public List<NoticeEntity> getDepartmentNoticesList(String departmentId) {
        return managerNotice.getDepartmentNotices(departmentId);
    }
}
