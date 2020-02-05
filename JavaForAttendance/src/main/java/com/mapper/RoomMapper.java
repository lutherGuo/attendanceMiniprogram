package com.mapper;

import com.pojo.Room;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoomMapper {
    /**
     * 获取教室列表
     * @param room
     */
    List<Room> getRoomList(Room room);
    /**
     * 根据Id获取供应商
     * @param rId
     */
   /* Room getRoomById(Integer rId);
    *//**增加*//*
    boolean addRoom(Room room);
    *//**删除供应商*//*
    boolean deleteRoom(Integer rId);
    *//**编辑*//*
    boolean updateRoom(Room room);
    //一对多查询
    List<Room> selectRoomById(Integer rId);//在房间表中根据rId联立查询*/
}
