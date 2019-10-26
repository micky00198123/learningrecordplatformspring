package com.fina.lrps.dao;

import com.fina.lrps.domain.po.NoticePo;
import com.fina.lrps.domain.NoticeUsers;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EmailMapper {

    /**
     * 获取主要部门
     * @param studentId studentId
     * @return the main department of student
     */
    String getMainDepartment(@NonNull String studentId);

    /**
     * 获取职位
     * @param studentId studentId
     * @return the position of student
     */
    String getPosition(@NonNull String studentId);

    /**
     * 统计学习中成员数量
     * @return int
     */
    int countLearningMember();

    /**
     * 插入notice记录
     * @param noticePo noticePo
     * @return 受影响行数
     */
    int insertNotice(NoticePo noticePo);

    /**
     * 插入notice与user中间表记录
     * @param noticeUsers noticeUsers
     * @return 受影响行数
     */
    int insertNoticeAndUser(NoticeUsers noticeUsers);

}
