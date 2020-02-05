package com.service;

import com.pojo.Room;

import java.util.List;

public interface RoomService {
    List<Room> getRoomList(Room room);

    /**
     * 根据Id获取供应商
     *
     * @param rId
     * @return
     */
   /* Room getRoomById(Integer rId);

    *//**
     * 增加
     *
     * @param room
     *//*
    boolean addRoom(Room room);

    *//**
     * 删除供应商
     *//*
    boolean deleteRoom(Integer rId);

    *//**
     * 编辑供应商
     *
     * @param room
     *//*
    boolean updateRoom(Room room);
    //多对多查询
    List<Room> selectRoomById(Integer rId);*/
}
