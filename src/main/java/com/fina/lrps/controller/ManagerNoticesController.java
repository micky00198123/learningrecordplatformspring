package com.fina.lrps.controller;

import com.fina.lrps.domain.NoticeEntity;
import com.fina.lrps.service.ManagerNoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author huangRui
 * @date 2019/11/17 18:22.
 */
@RestController
public class ManagerNoticesController {
    @Autowired
    ManagerNoticesService managerNoticesService;

    @RequestMapping("/admin/getNotices")
    public List<NoticeEntity> getNoticesList(String studentId, String scope, String timeLimit){
        return managerNoticesService.getNoticesList(studentId, scope, timeLimit);
    }

    @RequestMapping("/admin/getNoticesUnderDepartment")
    public List<NoticeEntity> getDepartmentNoticesList(String departmentId){
        return managerNoticesService.getDepartmentNoticesList(departmentId);
    }
}
