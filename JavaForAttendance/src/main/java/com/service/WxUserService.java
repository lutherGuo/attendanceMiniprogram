package com.service;

import com.pojo.WxUser;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: WxUserService
 * @Description: TODO
 * @author: 陈龙
 * @date: 2020/1/5  21:28
 * “欢迎您，我的无上至尊”
 */
public interface WxUserService {

    Integer getOnlineRoom(Integer uId);

    List<Map<String,Object>> isInRoom(Integer uId);

    boolean updateRoom(Integer uId,Integer rId);

    List<WxUser> getAllWxUser();
    //    根据id或openid获取用户信息
    WxUser getUserByUidOrOpenid(WxUser wxUser);
    boolean insertWxUser(WxUser wxUser);



    List<WxUser> getWxUserList();
    int getOnlineUser(int rid);
    boolean updateWxUser(Integer rid, Integer uId);
}
