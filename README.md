# BookStoreManagement
- ## BookStoreManagement Database

> Adding some data of book connect to the project (Using **MySQL**)

```
CREATE DATABASE sysmgr;

 create table book(
   bookid int(11) not null auto_increment COMMENT '图书标识',
   bookname varchar(30) not null  COMMENT '图书名称',
   bookprice varchar(30) not null  COMMENT '图书价格',
   bookpress VARCHAR(30) not null COMMENT '图书出版社',
   bookauthor varchar(30) not null  COMMENT '图书作者',
   bookdate date not null COMMENT '出版日期',
   PRIMARY KEY (bookid)
);

insert into book values (null,'天龙八部','58.0','人民出版社','金庸','2016-01-01'),
                        (null,'为什么活着','6666.0','王者出版社','燎','1999-01-01'),
                        (null,'天上人间','45.0','欢乐出版社','楚留香','2016-01-02'),
                        (null,'风起时','88.0','大众出版社','琅铘榜','2016-01-02'),
                        (null,'安徒生童话','10.0','环球出版社','安徒生','2016-01-31');

select* from book;

```
