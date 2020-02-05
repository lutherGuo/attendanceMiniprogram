package com.service;

import com.pojo.Time;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: TimeService
 * @Description: TODO
 * @author: 陈龙
 * @date: 2020/1/8  22:29
 * “欢迎您，我的无上至尊”
 */
public interface TimeService {

    boolean updateOrAddTime(Integer uId,Integer rId,int time,Integer exist);
    Time checkExist(Integer uId,Integer rId);
    List<Map<String,Object>> getAllUserTime();
}
