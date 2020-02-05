package com.pojo;

import java.util.Date;

/**
 * @ClassName: RoomAdmin
 * @Description: TODO
 * @author: 陈龙
 * @date: 2020/1/5  20:20
 * “欢迎您，我的无上至尊”
 */
public class RoomAdmin {
    /*-- 教室管理员表
    create table roomAdmin(
            rId int,
            uId int,
            aDate datetime,
            del int
    );*/

    private Integer rId;
    private Integer uId;
    private Date aDate;
    private Integer del;

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

    public Date getaDate() {
        return aDate;
    }

    public void setaDate(Date aDate) {
        this.aDate = aDate;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public RoomAdmin(Integer rId, Integer uId, Date aDate, Integer del) {
        this.rId = rId;
        this.uId = uId;
        this.aDate = aDate;
        this.del = del;
    }

    @Override
    public String toString() {
        return "RoomAdmin{" +
                "rId=" + rId +
                ", uId=" + uId +
                ", aDate=" + aDate +
                ", del=" + del +
                '}';
    }
}
