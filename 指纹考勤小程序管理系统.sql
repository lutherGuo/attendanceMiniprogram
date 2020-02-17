drop database if exists attendance;
create database attendance character set utf8;
use attendance;

/*用户微信表*/
create table wxUser(
uId int auto_increment primary key ,
openId varchar(30) not null,
nickName varchar(20) ,
avatarUrl text,
rId int default null,
sSuper int DEFAULT 1
);

/*-- 实名表*/
create table realName(
uId int,
sId varchar(20) primary key,
password varchar(30) not null,
pNumber varchar(20) unique not null,
email varchar(30) unique not null
);

/*-- 时长记录*/
create table time(
uId int,
rId int,
/*-- 单位为分*/
time int DEFAULT 0
);

/*-- 教室表*/
create table room(
	rId int AUTO_INCREMENT primary key,
	rName varchar(20) not null,
	address varchar(50) not null,
	del int DEFAULT 1
);

/*-- 教室管理员表*/
create table roomAdmin(
	rId int,
	uId int,
	aDate datetime,
	del int default 1
);


/*-- 教室管理员公告表*/
create table roomNotice(
	rId int,
	uId int,
	notice text,
	cDate datetime
);

/*-- 日志表*/
create table log(
	lId int AUTO_INCREMENT primary key,
	uId int not null,
	rId int not null,
	state int not null,
	-- state,1为进，0为出
	lDate datetime not null
);


alter table roomAdmin add constraint fk1 foreign key(rId) REFERENCES room(rId);
alter table roomAdmin add constraint fk2 foreign key(uId) REFERENCES wxuser(uId);
alter table log add constraint fk3 foreign key(uId) REFERENCES wxuser(uId);


/*--插入一个用户*/
INSERT into wxUser(openId,nickName,avatarUrl,sSuper)
VALUE ("od6Es5NOTRaVHRvEZNnow2WLqN7Q","Morty",
"https://wx.qlogo.cn/mmopen/vi_32/gzMS93L5HxDu7YgEUXqmrrXw6xBq8DnGKibtddgIBibpCHh6a9DGqtl40CswSNUnd3EGKwpnNictibRkKfh9pVH3yA/132","0");

INSERT into wxUser(openId,nickName,avatarUrl)
VALUE ("od6Es5L1Q6HvorEiUsa5N6eHlo5o","+T",
"https://wx.qlogo.cn/mmopen/vi_32/U74glmWRaf6DibbSrPjy7OGr9MibkjvqX8YvRzcEPbMQRaJxjvuCqCoZqtwaMc5TAc91axBhtTLmCdtMdraRwZTg/132");

INSERT into wxUser(openId,nickName,avatarUrl)
VALUE ("od6Es5EUAdEdruJQpv_me1LLTIzo","Cyril",
"https://wx.qlogo.cn/mmopen/vi_32/1pRmiaGichW0lxB5yicAKiaFIgkGd5OsPkgKJz0t2D2zlDiayDY3LAjZxias69XLpuswVKTgu4I4OkLjicxdW2pOpiaic6g/132");

INSERT into wxuser(openId,nickName,avatarUrl)
VALUE ("od6Es5CTgCB-RRNYaADTQzrNg1AI","Maxwell",
"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTITONnfhTqYPWl4WkICbzB8wQ6MhF4msLeC9PxvJI1Jxa90pt50t3lDX6iby97523FQ289y1JyiaBBQ/132");

INSERT into wxuser(openId,nickName,avatarUrl)
VALUE ("od6Es5BiGS7d9PAo-5IHEHikfleo","随变",
"https://wx.qlogo.cn/mmopen/vi_32/G8T3U4de9iaMjALnXCHNB06hsZNN15tEd4RHubBiaoPuQINoZF3ib2NpCxFQ6AqiciakWxYoChMg7DArlDjVc0YIcicw/132");

INSERT into wxuser(openId,nickName,avatarUrl)
VALUE ("od6Es5C8rPTN7yZ-vUM37","阿迪",
"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJFTnu8pI224YR4fVZvgibDWQfTvMtMYGa4ibslNfTmH8PPJXET5ibfoRt8bIv3r1FDYia4kVGTnuA5ibQ/132");


/*插入一条实名记录*/
INSERT into realName VALUE (null,"2017764317","123456","15322533185","1138312802@qq.com");
INSERT into realName VALUE (null,"2017764315","123456","15322533188","1501090251@qq.com");
INSERT into realName VALUE (null,"2017764339","123456","15322533180","1939945226@qq.com");

/*--某人在某间教室时长*/
INSERT into time VALUE ("1","1","220");
INSERT into time VALUE ("1","3","360");
INSERT into time VALUE ("1","2","60");
INSERT into time VALUE ("2","3","160");
INSERT into time VALUE ("2","2","100");
INSERT into time VALUE ("3","3","300");
INSERT into time VALUE ("3","2","60");
INSERT into time VALUE ("4","1","100");
INSERT into time VALUE ("4","4","150");
INSERT into time VALUE ("5","5","200");



/*--插入一个房间*/
INSERT into room(rName,address,del) VALUE ("综B911","综合楼B911","1");
INSERT into room(rName,address,del) VALUE ("综B913","综合楼B913","1");
INSERT into room(rName,address,del) VALUE ("综B901","综合楼B901","1");
INSERT into room(rName,address,del) VALUE ("教三104","教三104","1");
INSERT into room(rName,address,del) VALUE ("教三105","教三105","1");
INSERT into room(rName,address,del) VALUE ("教三106","教三106","1");
INSERT into room(rName,address,del) VALUE ("教三107","教三107","1");
INSERT into room(rName,address,del) VALUE ("教三108","教三108","0");
INSERT into room(rName,address,del) VALUE ("教三109","教三109","0");
INSERT into room(rName,address,del) VALUE ("教三110","教三110","0");

/*--房间管理员*/
INSERT into roomAdmin VALUE ("3","1","2020-01-05 08:00:00","1");
INSERT into roomAdmin VALUE ("3","3","2020-01-05 08:00:00","1");
INSERT into roomAdmin VALUE ("3","2","2020-01-05 08:00:00","1");
INSERT into roomAdmin VALUE ("2","2","2020-01-05 08:00:00","1");
INSERT into roomAdmin VALUE ("2","1","2020-01-05 08:00:00","1");
INSERT into roomAdmin VALUE ("2","3","2020-01-05 08:00:00","1");
INSERT into roomAdmin VALUE ("1","4","2020-01-05 08:00:00","1");
INSERT into roomAdmin VALUE ("1","1","2020-01-05 08:00:00","1");
INSERT into roomAdmin VALUE ("4","4","2020-01-05 08:00:00","1");
INSERT into roomAdmin VALUE ("5","5","2020-01-05 08:00:00","1");
INSERT into roomAdmin VALUE ("6","6","2020-01-05 08:00:00","0");




/*--插入公告*/
INSERT into roomNotice VALUE ("3","1","课室公告1","2020-01-05 08:00:00");
INSERT into roomNotice VALUE ("3","2","课室公告2","2020-01-06 07:50:00");
INSERT into roomNotice VALUE ("2","3","课室公告3","2020-01-06 08:00:00");
INSERT into roomNotice VALUE ("2","1","课室公告4","2020-01-06 09:00:00");
INSERT into roomNotice VALUE ("2","2","课室公告5","2020-01-07 09:30:00");
INSERT into roomNotice VALUE ("3","3","课室公告6","2020-01-07 10:00:00");
INSERT into roomNotice VALUE ("4","4","课室公告7","2020-01-08 09:00:00");
INSERT into roomNotice VALUE ("3","4","课室公告8","2020-01-09 09:00:00");
INSERT into roomNotice VALUE ("5","5","课室公告9","2020-01-10 10:00:00");



/*--插入一条日志记录*/
INSERT into log(uId,rId,state,lDate) VALUE ("1","1","1","2020-01-01 08:00:00");
INSERT into log(uId,rId,state,lDate) VALUE ("1","1","0","2020-01-01 09:50:00");
INSERT into log(uId,rId,state,lDate) VALUE ("1","2","1","2020-01-02 10:00:00");
INSERT into log(uId,rId,state,lDate) VALUE ("1","2","0","2020-01-02 13:00:00");
INSERT into log(uId,rId,state,lDate) VALUE ("2","1","1","2020-01-02 19:20:00");
INSERT into log(uId,rId,state,lDate) VALUE ("2","1","0","2020-01-02 22:00:00");
INSERT into log(uId,rId,state,lDate) VALUE ("2","2","1","2020-01-03 08:20:00");
INSERT into log(uId,rId,state,lDate) VALUE ("2","2","0","2020-01-03 09:20:00");
INSERT into log(uId,rId,state,lDate) VALUE ("3","3","1","2020-01-05 12:00:00");
INSERT into log(uId,rId,state,lDate) VALUE ("3","3","0","2020-01-05 17:00:00");
INSERT into log(uId,rId,state,lDate) VALUE ("1","3","1","2020-01-06 08:00:00");
INSERT into log(uId,rId,state,lDate) VALUE ("1","3","0","2020-01-06 05:00:00");
INSERT into log(uId,rId,state,lDate) VALUE ("2","3","1","2020-01-07 09:00:00");
INSERT into log(uId,rId,state,lDate) VALUE ("2","3","0","2020-01-08 10:00:00");
INSERT into log(uId,rId,state,lDate) VALUE ("1","3","1","2020-01-10 08:00:00");
INSERT into log(uId,rId,state,lDate) VALUE ("1","3","0","2020-01-10 11:00:00");
INSERT into log(uId,rId,state,lDate) VALUE ("2","3","1","2020-01-11 09:00:00");
INSERT into log(uId,rId,state,lDate) VALUE ("2","3","0","2020-01-11 10:00:00");
INSERT into log(uId,rId,state,lDate) VALUE ("1","1","1","2020-01-02 08:00:00");
INSERT into log(uId,rId,state,lDate) VALUE ("1","1","0","2020-01-02 09:50:00");
INSERT into log(uId,rId,state,lDate) VALUE ("1","2","1","2020-01-12 10:00:00");
INSERT into log(uId,rId,state,lDate) VALUE ("1","2","0","2020-01-12 13:00:00");

/*-- avatarUrl: "https://wx.qlogo.cn/mmopen/vi_32/gzMS93L5HxDu7YgEUXqmrrXw6xBq8DnGKibtddgIBibpCHh6a9DGqtl40CswSNUnd3EGKwpnNictibRkKfh9pVH3yA/132"
-- city: "Huizhou"
-- country: "China"
-- gender: 1
-- language: "zh_CN"
-- nickName: "Morty"
-- user openid:  od6Es5NOTRaVHRvEZNnow2WLqN7Q

-- avatarUrl: "https://wx.qlogo.cn/mmopen/vi_32/U74glmWRaf6DibbSrPjy7OGr9MibkjvqX8YvRzcEPbMQRaJxjvuCqCoZqtwaMc5TAc91axBhtTLmCdtMdraRwZTg/132"
-- city: "Zhanjiang"
-- country: "China"
-- gender: 1
-- language: "zh_CN"
-- nickName: "+T"
-- province: "Guangdong"
-- user openid:  od6Es5L1Q6HvorEiUsa5N6eHlo5o

-- avatarUrl: "https://wx.qlogo.cn/mmopen/vi_32/1pRmiaGichW0lxB5yicAKiaFIgkGd5OsPkgKJz0t2D2zlDiayDY3LAjZxias69XLpuswVKTgu4I4OkLjicxdW2pOpiaic6g/132"
-- city: ""
-- country: "Finland"
-- gender: 1
-- language: "zh_CN"
-- nickName: "Cyril"
-- province: ""
-- user openid:  od6Es5EUAdEdruJQpv_me1LLTIzo
*/



