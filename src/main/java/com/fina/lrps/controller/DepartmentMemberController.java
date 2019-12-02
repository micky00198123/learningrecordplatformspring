package com.fina.lrps.controller;


import com.alibaba.fastjson.JSONObject;
import com.fina.lrps.domain.DepartmentMember;
import com.fina.lrps.domain.NoticeForm;
import com.fina.lrps.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author huangRui
 * @date 2019/10/18 21:46.
 */
@RestController
public class DepartmentMemberController {
    @Autowired
    NoticeService noticeService;

    @RequestMapping(value = "/notice/getDepartmentMember")
    public String getDepartmentMemberlist(@RequestParam(value = "departmentId", required = true) String id){
        List<DepartmentMember> list = noticeService.getDepartmentMemberList(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("DepMemList",list);
        return jsonObject.toJSONString();
    }
    @RequestMapping(value = "/notice/getMyNotice")
    public String getNoticeList(@RequestParam(value = "studentId", required = true) String id){
        List<NoticeForm> list = noticeService.getNoticeList(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("NoticeList",list);
        return jsonObject.toJSONString();
    }
}
