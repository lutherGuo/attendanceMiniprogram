package com.mapper;

import com.pojo.WxUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserMapper
 * @Description: TODO
 * @author: 陈龙
 * @date: 2020/1/5  20:54
 * “欢迎您，我的无上至尊”
 */
@Mapper
@Repository
public interface WxUserMapper {


//    根据uid获取此人所在教室
    Integer getOnlineRoom(@Param("uId") Integer uId);
//    更新用户表的在线教室，rid为空就置为空，否则更新
    boolean updateRoom(@Param("uId")Integer uId,@Param("rId")Integer rId);
//    获取某个人在哪个教室，并获取这个教室的日志
    List<Map<String,Object>> isInRoom(@Param("uId") Integer uId);

    List<WxUser> getAllWxUser();

//    根据uid或openid获取用户信息,此方法1为通过uid查询，2为通过openid查询
    WxUser getUserByUidOrOpenid(WxUser wxUser);

//    插入微信用户
    boolean insertWxUser(WxUser wxUser);


    List<WxUser> getWxUserList();

    int getOnlineUser(Integer rid);

    boolean updateWxUser(Integer rid, Integer uId);
}
