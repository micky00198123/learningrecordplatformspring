package com.fina.lrps.service;

import com.fina.lrps.domain.DepartmentMember;
import com.fina.lrps.domain.NoticeForm;

import java.util.List;

/**
 * @author huangRui
 * @date 2019/10/18 11:27.
 */
public interface NoticeService {
    /**
     *
     * @param i 部门编号
     * @return 该部门所有在职成员的学号与名字
     */
    List<DepartmentMember> getDepartmentMemberList(String i);

    /**
     * 根据学号返回通知列表
     * @param studentId 学号
     * @return
     */
    List<NoticeForm> getNoticeList(String studentId);


}
