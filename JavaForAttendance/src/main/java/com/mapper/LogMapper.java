package com.mapper;

import com.pojo.Log;
import com.pojo.Time;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface LogMapper {
//    在退出时返回进入时的时间
    Map<String,Object> getEntryTime(@Param("uId")Integer uId, @Param("rId")Integer rId);
//    添加日志
    boolean addLog(@Param("uId")Integer uId, @Param("rId")Integer rId,
                   @Param("state")Integer state, @Param("lDate")String lDate) ;
    //动态获取log
    List<Map<String,Object>> getLog(@Param("uId") Integer uId, @Param("rId") Integer rId, @Param("room") Integer room);
//    根据教室rid获取教室日志,如果没有rid就查找全部
    List<Log> getLogByRid(Integer rid);
//    获取我去过的教室根据uid
    List<Integer> getMyRoomByUid(Integer uid);
//    根据uid和rid获取我在某个教室的日志
    List<Log> getMyRoomLog(Integer uid, Integer rid);


}
