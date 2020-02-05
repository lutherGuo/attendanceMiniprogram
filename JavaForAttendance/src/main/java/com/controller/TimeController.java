package com.controller;

import com.service.TimeService;
import com.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TimeController
 * @Description: TODO
 * @author: 陈龙
 * @date: 2020/1/11  23:52
 * “欢迎您，我的无上至尊”
 */
@RestController
@RequestMapping("/time")
public class TimeController {
    @Autowired
    private TimeService timeService;

    @RequestMapping("/getAllUserTime")
    public Map<String,Object> getAllUserTime(){
        Map<String,Object> msg = new HashMap<>();
        msg.put("allUserTime",timeService.getAllUserTime());
        return msg;
    }
}
