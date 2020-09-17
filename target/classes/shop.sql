-- 注意:先创建并使用用自己的数据库
-- use shop;
-- 用户表 
create table if not exists tab_user(
`uid` int(10) primary key AUTO_INCREMENT,
`uname` varchar(100) unique,
`password` varchar(32),
`sex` varchar(8),
`email` varchar(100) unique,
`phone` varchar(11),
`address` varchar(64),
`status` varchar(1),
`code` varchar(50) unique
);

-- 商标表
create table if not exists tab_brand(
`bid` int(10) primary key AUTO_INCREMENT,
`bname` varchar(100),
`bimg` varchar(200)
);

-- 分类标签表
create table if not exists tab_label(
`lid` int(10) primary key,
`lname` varchar(100),
`description` varchar(1000)
);

-- 商品表
create table if not exists tab_goods(
`gid` int(10) primary key AUTO_INCREMENT,
`gname` varchar(100),
`price` int(10),
`bid`  int(10),
`lid` int(10),
`description` varchar(1000),
constraint foreign key(`bid`) references `tab_brand`(`bid`),
constraint foreign key(`lid`) references `tab_label`(`lid`)
);

-- 商品图片表
create table if not exists tab_picture(
`pid` int(10) primary key,
`gid` int(10),
`bigPic` varchar(200),
`smallPic` varchar(200),
constraint foreign key(`gid`) references `tab_goods`(`gid`)
);

-- 购物车表
create table if not exists tab_cart(
`uid` int(10),
`gid` int(10),
`number` int(10),
constraint primary key(`uid`,`gid`),
constraint foreign key(`uid`) references `tab_user`(`uid`),
constraint foreign key(`gid`) references `tab_goods`(`gid`)
);

-- 消费记录表 
create table if not exists tab_record(
`uid` int(10),
`gid` int(10),
`time` datetime,
`number` int(10),
constraint primary key(`uid`,`gid`,`time`),
constraint foreign key(`uid`) references `tab_user`(`uid`),
constraint foreign key(`gid`) references `tab_goods`(`gid`)
);

-- 用户网站意见反馈表
create table if not exists tab_feedback(
`eid` int(20) primary key AUTO_INCREMENT,
`time` datetime ,
`ename` varchar(20) not null,
`email` varchar(20) not null,
`subject` varchar(100) not null,
`message` varchar(1000) not null
);