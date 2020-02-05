package com.pojo;

/**
 * @ClassName: RealName
 * @Description: TODO
 * @author: 陈龙
 * @date: 2020/1/5  20:10
 * “欢迎您，我的无上至尊”
 */
public class RealName {
/*    -- 实名表
    create table realName(
            uId int,
            sId varchar(20) primary key,
    password varchar(30) not null,
    pNumber varchar(20) unique not null,
    email varchar(30) unique not null

            );*/

    private Integer uId;
    private String sId;
    private String password;
    private String pNumber;
    private String email;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RealName(Integer uId, String sId, String password, String pNumber, String email) {
        this.uId = uId;
        this.sId = sId;
        this.password = password;
        this.pNumber = pNumber;
        this.email = email;
    }

    public RealName( String sId, String password, String email) {
        this.sId = sId;
        this.password = password;
        this.email = email;
    }

    public RealName() {
    }

    @Override
    public String toString() {
        return "RealName{" +
                "uId=" + uId +
                ", sId='" + sId + '\'' +
                ", password='" + password + '\'' +
                ", pNumber='" + pNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
