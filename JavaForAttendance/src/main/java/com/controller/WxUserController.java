package com.controller;

import com.pojo.WxUser;
import com.service.LogService;
import com.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: WxUserController
 * @Description: TODO
 * @author: 陈龙
 * @date: 2020/1/5  21:42
 * “欢迎您，我的无上至尊”
 */
@RestController
@RequestMapping("/wxUser")
public class WxUserController {
   @Autowired
   private WxUserService wxUserService;

    @Autowired
    private LogService logService;







    @RequestMapping("/login")
    public Map<String,Object> login(String avatarUrl,String openId,String nickName) {
        /*
         * 1.验证数据库有没此用户，就添加，并返回是新用户(用于前端提示实名注册)
         * 2.如果是老用户，就更新，返回老用户（提示欢迎回来）
         *
         * */

        Map<String,Object> wxUserMap = new HashMap<>();
        WxUser wxUser = new WxUser(openId,nickName,avatarUrl);
        System.out.println(wxUser);
        wxUser.toString();


        if(wxUserService.getUserByUidOrOpenid(wxUser)==null){
            wxUserMap.put("success",wxUserService.insertWxUser(wxUser));
        }else{
            wxUserMap.put("success",null);
        }
        wxUserMap.put("wxUserInfo",wxUserService.getUserByUidOrOpenid(wxUser));

        return wxUserMap;

    }















    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getOnlineUser(Integer rId, Model model) {

        int count;
        count = wxUserService.getOnlineUser(rId);
        model.addAttribute("count", count);
        return "index";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String getAllWxUser(Model model) {

        List<WxUser> list = wxUserService.getAllWxUser();
        model.addAttribute("list", list);
        return "AllWxUser";//前端页面

    }

    @RequestMapping(value ="/edit",method = RequestMethod.POST)
    public void updateWxUser(Integer rid, Integer uId, Model model) {
        boolean result = wxUserService.updateWxUser(rid, uId);
        if (result == true) {
            model.addAttribute("item");
        } else {
            model.addAttribute("msg", "更新失败");
        }
    }

    @RequestMapping(value ="/test")
    public String test(){
        return "fuck";
    }


}
