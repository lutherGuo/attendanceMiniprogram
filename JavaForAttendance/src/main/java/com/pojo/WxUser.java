package com.pojo;

/**
 * @ClassName: User
 * @Description: TODO
 * @author: 陈龙
 * @date: 2020/1/5  19:48
 * “欢迎您，我的无上至尊”
 */
public class WxUser {
/*    *//*用户微信表*//*
    create table wxUser(
            uId int AUTO_INCREMENT primary key,
            openId varchar(50) not null,
    nickName varchar(20) ,
    avatarUrl text,
    activity int DEFAULT 0,
    sSuper int DEFAULT 1
            );*/


    private Integer uId;
    private String openId;
    private String nickName;
    private String avatarUrl;
    private String rId;
    private Integer sSuper;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public Integer getsSuper() {
        return sSuper;
    }

    public void setsSuper(Integer sSuper) {
        this.sSuper = sSuper;
    }

    public WxUser(String openId, String nickName, String avatarUrl) {
        this.openId = openId;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "WxUser{" +
                "uId=" + uId +
                ", openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", rId='" + rId + '\'' +
                ", sSuper=" + sSuper +
                '}';
    }
}
