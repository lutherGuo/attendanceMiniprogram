package com.service;

import com.pojo.RoomAdmin;

public interface RoomNoticeService {
    RoomAdmin getNotice(int rid);

    RoomAdmin updateinfo(RoomAdmin roomAdmin);
}
