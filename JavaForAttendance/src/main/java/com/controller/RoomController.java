package com.controller;

import com.pojo.Room;
import com.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: RoomController
 * @Description: TODO
 * @author: 陈龙
 * @date: 2020/1/12  23:33
 * “欢迎您，我的无上至尊”
 */
@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @RequestMapping("/room")
    public Map<String,Object> getRoomList(){
        Map<String,Object> msg = new HashMap<>();
        Room room = new Room();
        msg.put("roomList",roomService.getRoomList(room));
        return msg;
    }
}
