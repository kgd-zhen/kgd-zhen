/**
*DatabaseHelper中数据表的数据结构
*@author kgd.zhen@gmail.com
**/

//用户表
create table food_user(
name VARCHAR(100),	//用户名称
eName VARCHAR(32), //英文名称
pwd VARCHAR(32),	//登录密码
phone VARCHAR(32),	//手机号
email VARCHAR(32),	//email
address VARCHAR(32),	//住址
company VARCHAR(32),	//公司名称
qq VARCHAR(32),	//qq
note VARCHAR(32),//备注
reserve VARCHAR(32)//保留
);