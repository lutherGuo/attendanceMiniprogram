package com.pojo;

import java.util.List;

/**
 * @ClassName: Room
 * @Description: TODO
 * @author: 陈龙
 * @date: 2020/1/5  20:12
 * “欢迎您，我的无上至尊”
 */
public class Room {

/*    -- 教室表
    create table room(
            rId int primary key,
            rName varchar(20) not null,
    address varchar(50) not null
            );*/

    private Integer rId;
    private String rName;
    private String address;
    private Integer del;

    public Room() {

    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

   /* public List<WxUser> getWxUsers() {
        return wxUser;
    }

    public void setWxUsers(List<WxUser> wxUsers) {
        this.wxUser = wxUser;
    }*/

    public Room(Integer rId, String rName, String address, Integer del) {
        this.rId = rId;
        this.rName = rName;
        this.address = address;
        this.del = del;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rId=" + rId +
                ", rName='" + rName + '\'' +
                ", address='" + address + '\'' +
                ", del=" + del +
                ", ";
    }
}
