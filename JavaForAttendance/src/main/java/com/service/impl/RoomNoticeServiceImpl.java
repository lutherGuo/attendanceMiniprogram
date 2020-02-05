/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: RoomAdminImpl
 * Author:   19399
 * Date:     2020/1/7 8:37
 * Description: 房间管理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.service.impl;

import com.pojo.RoomAdmin;
import com.service.RoomNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈房间管理〉
 *
 * @author 19399
 * @create 2020/1/7
 * @since 1.0.0
 */
@Service
public class RoomNoticeServiceImpl implements RoomNoticeService {

    @Autowired
    RoomNoticeService roomNoticeService;
    @Override
    public RoomAdmin getNotice(int rid) {
        return roomNoticeService.getNotice(rid);
    }

    @Override
    public RoomAdmin updateinfo(RoomAdmin roomAdmin) {
        return roomNoticeService.updateinfo(roomAdmin);
    }
}

