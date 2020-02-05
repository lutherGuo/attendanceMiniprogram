package com.controller;

import com.pojo.RealName;
import com.service.RealNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: RealNameController
 * @Description: TODO
 * @author: 陈龙
 * @date: 2020/1/10  19:37
 * “欢迎您，我的无上至尊”
 */

@RestController
@RequestMapping("/realName")
public class RealNameController {
    @Autowired
    private RealNameService realNameService;


    @RequestMapping("/tieRealName")
    public Map<String,Object> login(String uId, String sId, String password, String email) {
        /*
            实名绑定，todo邮箱认证
         *
         * */

        Map<String,Object> msg = new HashMap<>();
        RealName realName = new RealName(sId,password,email);
        RealName getRealName = realNameService.getBySidAndPwd(realName);
        System.out.println(getRealName);
        if(getRealName==null){
            System.out.println("不存在或密码错误");
//            不存在或账号密码错误
            msg.put("success","noExist");
        }else if(getRealName.getuId()!=null){
//            已绑定
            msg.put("success","tied");
        }else if(getRealName!=null&&getRealName.getuId()==null){
//            未绑定且账密正确
            msg.put("success",realNameService.tieUid(uId,sId));
        }


        return msg;

    }

    @RequestMapping("/getRealName")
    public Map<String,Object> getByUid(String uId){
        System.out.println(uId);
        Map<String,Object> msg = new HashMap<>();
        msg.put("realNameInfo",realNameService.getByUid(uId));
        return msg;
    }
}
