package com.fina.lrps.dao;

import com.fina.lrps.domain.DepartmentMember;
import com.fina.lrps.domain.NoticeForm;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huangRui
 * @date 2019/10/18 11:04.
 */
@Component
public interface NoticeDao {
        /**
         * 得到该部门所有在职成员的学号与名字
         * @param id 部门编号
         * @return DepartmentMember 成员的学号与名字
         */
        List<DepartmentMember> getDepartmentMember(String id);

        /**
         *
         * @param id
         * @return
         */
        List<NoticeForm> getNoticeList(String id);

}
