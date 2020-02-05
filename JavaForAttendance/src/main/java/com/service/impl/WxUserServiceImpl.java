package com.service.impl;

import com.mapper.WxUserMapper;
import com.pojo.WxUser;
import com.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: WxUserServiceImpl
 * @Description: TODO
 * @author: 陈龙
 * @date: 2020/1/5  21:40
 * “欢迎您，我的无上至尊”
 */
@Service
public class WxUserServiceImpl implements WxUserService {

    @Autowired
    private WxUserMapper wxUserMapper;


    @Override
    public Integer getOnlineRoom(Integer uId) {
        return wxUserMapper.getOnlineRoom(uId);
    }

    @Override
    public List<Map<String, Object>> isInRoom(Integer uId) {
        return wxUserMapper.isInRoom(uId);
    }

    @Override
    public boolean updateRoom(Integer uId, Integer rId) {
        return wxUserMapper.updateRoom(uId,rId);
    }

    @Override
    public List<WxUser> getAllWxUser() {
        return wxUserMapper.getAllWxUser();
    }


    @Override
    public WxUser getUserByUidOrOpenid(WxUser wxUser){
        return wxUserMapper.getUserByUidOrOpenid(wxUser);
    }

    @Override
    public boolean insertWxUser(WxUser wxUser) {
        return wxUserMapper.insertWxUser(wxUser);
    }


    @Override
    public List<WxUser> getWxUserList() {
        return wxUserMapper.getWxUserList();
    }

    @Override
    public int getOnlineUser(int rid) {
        return wxUserMapper.getOnlineUser(rid);
    }

    @Override
    public boolean updateWxUser(Integer rid, Integer uId) {
        return wxUserMapper.updateWxUser(rid,uId);
    }
}
