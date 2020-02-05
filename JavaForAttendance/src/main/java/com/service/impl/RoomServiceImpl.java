/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: RoomImpl
 * Author:   19399
 * Date:     2020/1/7 8:37
 * Description: 教室
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.service.impl;

import com.mapper.RoomMapper;
import com.pojo.Room;

import com.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈教室〉
 *
 * @author 19399
 * @create 2020/1/7
 * @since 1.0.0
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomMapper roomMapper;

    @Override
    public List<Room> getRoomList(Room room) {
        return roomMapper.getRoomList(room);
    }



/*
    @Override
    public Room getRoomById(Integer rId) {
        return null;
    }

    @Override
    public boolean addRoom(Room room) {
        return false;
    }

    @Override
    public boolean deleteRoom(Integer rId) {
        return false;
    }

    @Override
    public boolean updateRoom(Room room) {
        return false;
    }

    @Override
    public List<Room> selectRoomById(Integer rId) {
        return null;
    }
*/



}

