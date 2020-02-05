package com.service.impl;

import com.mapper.TimeMapper;
import com.mapper.WxUserMapper;
import com.pojo.Time;
import com.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: TimeServiceImpl
 * @Description: TODO
 * @author: 陈龙
 * @date: 2020/1/8  22:29
 * “欢迎您，我的无上至尊”
 */
@Service
public class TimeServiceImpl implements TimeService {
    @Autowired
    private TimeMapper timeMapper;


    @Override
    public boolean updateOrAddTime(Integer uId, Integer rId, int time,Integer exist) {
        return timeMapper.updateOrAddTime(uId,rId,time,exist);
    }

    @Override
    public Time checkExist(Integer uId, Integer rId) {
        return timeMapper.checkExist(uId,rId);
    }

    @Override
    public List<Map<String,Object>> getAllUserTime(){
        return timeMapper.getAllUserTime();
    }
}
