package com.service;

import com.pojo.Log;
import com.pojo.Time;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface LogService {

    Map<String,Object> getEntryTime(Integer uId, Integer rId);
    boolean addLog(Integer uId, Integer rId, Integer state, String lDate);
    List<Map<String,Object>> getLog(Integer uId, Integer rId, Integer room);
    //    根据教室rid获取教室进出
    List<Log> getLogByRid(Integer rid);
    //    获取我去过的教室根据uid
    List<Integer> getMyRoomByUid(Integer uid);
    //    根据uid和rid获取我在某个教室的日志
    List<Log> getMyRoomLog(Integer uid, Integer rid);
}
