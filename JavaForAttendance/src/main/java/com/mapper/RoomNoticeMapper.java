package com.mapper;

import com.pojo.RoomNotice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoomNoticeMapper {
    RoomNotice getNoticeByRid(int rid);

    RoomNotice updateinfo(RoomNotice roomNotice);
}
