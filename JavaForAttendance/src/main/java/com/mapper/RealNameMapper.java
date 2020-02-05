package com.mapper;

import com.pojo.RealName;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RealNameMapper {
//    根据学号和密码返回
     RealName getBySidAndPwd(RealName realName);

//     绑定微信用户到学号
    boolean tieUid(@Param("uId") String uId, @Param("sId") String sId);

//    根据uid返回除密码外的实名信息
    RealName getByUid(String uid);
}
