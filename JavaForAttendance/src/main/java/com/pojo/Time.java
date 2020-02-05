package com.pojo;

/**
 * @ClassName: Time
 * @Description: TODO
 * @author: 陈龙
 * @date: 2020/1/8  22:26
 * “欢迎您，我的无上至尊”
 */
public class Time {
    private Integer uId;
    private Integer rId;
    private Integer time;

    public Integer getUid() {
        return uId;
    }

    public void setUid(Integer uId) {
        this.uId = uId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Time(Integer uId, Integer rId, Integer time) {
        this.uId = uId;
        this.rId = rId;
        this.time = time;
    }
}
