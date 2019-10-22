package com.fina.lrps.dao;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

// mybatis代理的接口要加@Repository
// 否则spring扫描代码@Autowired报红,但依然能注入成功
@Repository
public interface EmailMapper {

    /**
     * 获取主要部门
     * @param studentId studentId
     * @return the main department of student
     */
    String getMainDepartment(@NonNull String studentId);

}
