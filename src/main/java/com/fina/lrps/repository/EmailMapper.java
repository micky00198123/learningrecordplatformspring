package com.fina.lrps.repository;

import org.springframework.lang.NonNull;

public interface EmailMapper {

    /**
     * 获取主要部门
     * @param studentId studentId
     * @return the main department of student
     */
    String getMainDepartment(@NonNull String studentId);

}
