/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: RealNameImpl
 * Author:   19399
 * Date:     2020/1/7 8:36
 * Description: 实名
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.service.impl;

import com.mapper.RealNameMapper;
import com.pojo.RealName;
import com.service.RealNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈实名〉
 *
 * @author 19399
 * @create 2020/1/7
 * @since 1.0.0
 */
@Service
public class RealNameServiceImpl implements RealNameService {
    @Autowired
    private RealNameMapper realNameMapper;

    @Override
    public RealName getBySidAndPwd(RealName realName){
        return  realNameMapper.getBySidAndPwd(realName);
    }

    @Override
    public boolean tieUid(String uId,String sId){
        return  realNameMapper.tieUid(uId,sId);
    }

    @Override
    public RealName getByUid(String uId){
        return realNameMapper.getByUid(uId);
    }

}

