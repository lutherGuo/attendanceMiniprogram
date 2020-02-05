package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: testController
 * @Description: TODO
 * @author: 陈龙
 * @date: 2020/1/30  19:52
 * “欢迎您，我的无上至尊”
 */
@RestController
@RequestMapping("/test")
public class testController {

    @RequestMapping("/t1")
    public void getRoomList(){

    }
}
