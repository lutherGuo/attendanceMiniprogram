package com.pojo;

import java.util.Date;

/**
 * @ClassName: Log
 * @Description: TODO
 * @author: 陈龙
 * @date: 2020/1/5  20:43
 * “欢迎您，我的无上至尊”
 */

public class Log {

/*    -- 日志表
    create table log(
            lId int primary key,
            uId int not null,
            rId int not null,
            state int not null,
            lDate date not null
    );*/

    private Integer lId;
    private Integer uId;
    private Integer rId;
//    1为进，0为出
    private Integer state;
    private Date lDate;

    public Integer getlId() {
        return lId;
    }

    public void setlId(Integer lId) {
        this.lId = lId;
    }

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getlDate() {
        return lDate;
    }

    public void setlDate(Date lDate) {
        this.lDate = lDate;
    }

    public Log(Integer lId, Integer uId, Integer rId, Integer state, Date lDate) {
        this.lId = lId;
        this.uId = uId;
        this.rId = rId;
        this.state = state;
        this.lDate = lDate;
    }

    @Override
    public String toString() {
        return "Log{" +
                "lId=" + lId +
                ", uId=" + uId +
                ", rId=" + rId +
                ", state=" + state +
                ", lDate=" + lDate +
                '}';
    }
}
