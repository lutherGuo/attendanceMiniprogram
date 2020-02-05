package com.mapper;

import com.pojo.Time;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: TimeMapper
 * @Description: TODO
 * @author: 陈龙28
 * @date: 2020/1/8  22:
 * “欢迎您，我的无上至尊”
 */
@Mapper
@Repository
public interface TimeMapper {
    boolean updateOrAddTime(@Param("uId") Integer uId, @Param("rId") Integer rId,
                            @Param("time") int time,@Param("exist") Integer exist);
    Time checkExist(@Param("uId")Integer uId, @Param("rId")Integer rId);
    List<Map<String,Object>>  getAllUserTime();
}
