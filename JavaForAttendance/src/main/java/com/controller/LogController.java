package com.controller;

import com.pojo.Log;
import com.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: LogController
 * @Description: TODO
 * @author: 陈龙
 * @date: 2020/1/8  0:52
 * “欢迎您，我的无上至尊”
 */
@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @GetMapping(value= "/getLog")
    public Map<String,Object> getLog(Integer uId,Integer rId){
        /*
        * 1.根据uId和rid差某个人在某个教室日志
        * 2.根据uId差某个人所有日志
        * 3.根据sId查某间教室日志
        * 4.根据uId差某个人去过的教室（groupby）
        * 返回的是多表查询*/
        System.out.println("rid="+rId);
        System.out.println("uId="+uId);
        Map<String,Object> logMap = new HashMap<>();
        logMap.put("logList",logService.getLog(uId,rId,null));
        if(uId!=null&&rId==null) {
            logMap.put("roomList", logService.getLog(uId, rId, 1));
        }

        return logMap;
    }
}
