/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LogServiceImpl
 * Author:   19399
 * Date:     2020/1/7 8:35
 * Description: 1
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.service.impl;

import com.mapper.LogMapper;
import com.pojo.Log;
import com.pojo.Time;
import com.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈1〉
 *
 * @author 19399
 * @create 2020/1/7
 * @since 1.0.0
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;


    @Override
    public Map<String,Object> getEntryTime(Integer uId, Integer rId) {
        return logMapper.getEntryTime(uId,rId);
    }

    @Override
    public boolean addLog(Integer uId, Integer rId, Integer state, String lDate) {
        return logMapper.addLog(uId,rId,state,lDate);
    }

    @Override
    public List<Map<String,Object>> getLog(Integer uId, Integer rId, Integer room) {
        return logMapper.getLog(uId,rId,room);
    }

    @Override
    //    根据教室rid获取教室进出
    public List<Log> getLogByRid(Integer rid){
        return  logMapper.getLogByRid(rid);
    }
    @Override
    //    获取我去过的教室根据uid
    public List<Integer> getMyRoomByUid(Integer uid){
        return  logMapper.getMyRoomByUid(uid);
    }
    @Override
    //    根据uid和rid获取我在某个教室的日志
    public List<Log> getMyRoomLog(Integer uid, Integer rid){
        return  logMapper.getMyRoomLog(uid,rid);
    }


}

