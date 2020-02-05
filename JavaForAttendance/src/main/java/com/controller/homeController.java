package com.controller;

import com.service.LogService;
import com.service.TimeService;
import com.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: homeController
 * @Description: 用于首页数据的调用
 * @author: 陈龙
 * @date: 2020/1/12  22:25
 * “欢迎您，我的无上至尊”
 */
@RestController
@RequestMapping("/home")
public class homeController {
    @Autowired
    private WxUserService wxUserService;

    @Autowired
    private LogService logService;

    @Autowired
    private TimeService timeService;

    @RequestMapping("/home")
    public Map<String,Object> inRoom(Integer uId, Integer rId, Integer state, String lDate) throws ParseException {
        /*
         * 1.获取此人在的教室，有就返回此教室日志，没有返回的也是空（uId不为空rid为空时）
         * 2.如果uid和rid不为空说明要进入教室，就更新微信用户表的uid并返回此教室日志
         * 3.quit为true时为退出，为空时处理其他
         *
         *
         * */
        System.out.println("uId="+uId);
        System.out.println("rId="+rId);
        System.out.println("state="+state);
        System.out.println("lDate="+lDate);
        Map<String,Object> inRoom = new HashMap<>();
        /*退出教室，置为空*/
        if(state!=null){
            if(state==0) {
                /*离开教室*/
                System.out.println("离开教室");

//
                wxUserService.updateRoom(uId, null);
                logService.addLog(uId, rId, state, lDate);

                /*计算在这个教室时长*/
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                Date endTime = simpleDateFormat.parse(lDate);

                System.out.println((logService.getEntryTime(uId, rId)).get("lDate"));


                Map<String,Object> maxDate = logService.getEntryTime(uId, rId);
                System.out.println(maxDate.get("lDate"));

                Date startTime = simpleDateFormat.parse(String.valueOf(maxDate.get("lDate")));
                System.out.println("startTime="+startTime);

                if (startTime != null) {
                    System.out.println("xxxx");
                    long start = startTime.getTime();
                    long end = endTime.getTime();
                    long result = (end - start)/(60*1000);
                    int time = (int)result;
                    System.out.println("time="+time);
                /*如果time表没这个记录就增加，有就更新*/
                if (timeService.checkExist(uId, rId) == null) {
                    System.out.println("不存在time，要插入");
                    timeService.updateOrAddTime(uId,rId,time,null);
                } else {
                    System.out.println("存在time，要更新");
                    timeService.updateOrAddTime(uId,rId,time,1);

                }
            }
                inRoom.put("success","退出成功");
                return inRoom;
            }else if(state==1){/*进入教室*/
                System.out.println("进入教室");

                logService.addLog(uId,rId,state,lDate);
                wxUserService.updateRoom(uId,rId);


            }
        } else if(state==null){/*页面加载获取教室返回空或教师日志等信息*/

            rId = wxUserService.getOnlineRoom(uId);
            if(rId==null){
                inRoom.put("roomLog",null);
                return inRoom;
            }
        }

        System.out.println("法身了");


        inRoom.put("roomLog",logService.getLog(null,rId,null));





        return inRoom;
    }

    @RequestMapping("/test")
    public String test() throws ParseException {
        String lDate = "2020-01-13 10:23:31" ;
        String lDate2 = "2020-01-13 10:25:31" ;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date startTime = simpleDateFormat.parse(lDate);
        Date endTime = simpleDateFormat.parse(lDate2);

        long start = startTime.getTime();
        long end = endTime.getTime();
        long result = end-start;
        System.out.println("相减为"+result);
        String fuck = "相差"+result/(60*1000)+"分钟";

        return fuck;

    }



}
