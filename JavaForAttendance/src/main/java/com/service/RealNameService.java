package com.service;

import com.pojo.RealName;


public interface RealNameService {
    RealName getBySidAndPwd(RealName realName);
    boolean tieUid(String uId, String sId);
    RealName getByUid(String uId);
}
