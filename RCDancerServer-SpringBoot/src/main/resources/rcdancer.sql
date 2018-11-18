create database rcdancer;
use rcdancer;

create table user_login(
  username varchar(24) primary key,
  password varchar(24) not null
);

create table user_detail(
 username varchar(24),
 name varchar(50),
 sex varchar(10),
 join_date datetime,
 aventor varchar(1000),
 email varchar(50),
 foreign key(username) references user_login(username)
);
