package com.fina.lrps.service.impl;

import com.alibaba.fastjson.JSON;
import com.fina.lrps.dao.NoticeDao;
import com.fina.lrps.domain.DepartmentMember;
import com.fina.lrps.domain.NoticeForm;
import com.fina.lrps.service.NoticeService;
import com.fina.lrps.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author huangRui
 * @date 2019/10/18 12:35.
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeDao noticeDao;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public List<DepartmentMember> getDepartmentMemberList(String i) {
        return noticeDao.getDepartmentMember(i);
    }

    @Override
    public List<NoticeForm> getNoticeList(String studentId) {
        //从缓存中获取内容 （获取内容数量还未写
        try{
            /*
            Map<Object,Object> string = redisUtil.hmget(studentId);
            //当缓存中有内容且不为空时
            if(string != null &&string.isEmpty() != true){
                System.out.println("-----------------调用查看redis缓存操作成功--------------------");
                List<NoticeForm> list = null;
                Set<Object> set=string.keySet();
                for(Object key : set){
                    String value = (String)string.get(key);
                    list.add(JSON.parseObject(value,NoticeForm.class));
                }*/
            List<NoticeForm> list = (List<NoticeForm>)(List)redisUtil.lGet(studentId,0,-1);
                return list;

        } catch (Exception e) {
            e.printStackTrace();
        }

        List<NoticeForm> list = noticeDao.getNoticeList(studentId);
        System.out.println("==================查询mysql并放入redis缓存=========================");
        try{
            for(NoticeForm item : list){
                String string = JSON.toJSONString(item);
                redisUtil.lSet(studentId,list);
                //redisDataSource.hset(studentId,item.getNoticeId(),string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
