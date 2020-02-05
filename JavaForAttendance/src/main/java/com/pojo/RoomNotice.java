package com.pojo;

import java.util.Date;

/**
 * @ClassName: RoomNotice
 * @Description: TODO
 * @author: 陈龙
 * @date: 2020/1/7  23:39
 * “欢迎您，我的无上至尊”
 */
public class RoomNotice {
    /*-- 教室管理员表
    create table roomAdmin(
            rId int,
            uId int,
            notice text
    );*/

    private Integer rId;
    private Integer uId;
    private String notice;
    private Date cDate;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public RoomNotice(Integer rId, Integer uId, String notice, Date cDate) {
        this.rId = rId;
        this.uId = uId;
        this.notice = notice;
        this.cDate = cDate;
    }

    @Override
    public String toString() {
        return "RoomAdmin{" +
                "rId=" + rId +
                ", uId=" + uId +
                ", notice='" + notice + '\'' +
                ", cDate=" + cDate +
                '}';
    }
}
