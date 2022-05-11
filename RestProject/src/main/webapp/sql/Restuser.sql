--------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------



drop table MEMBER;
select * from MEMBER
CREATE TABLE MEMBER(
mID varchar(45) PRIMARY KEY,
mGRADE Nvarchar(10) NOT NULL, 
mPW varchar(256) NOT NULL,
mNAME Nvarchar(20) NOT NULL,
mEMAIL varchar(45) NOT NULL,
mPHONE varchar(40) NOT NULL,
mRDATE DATE NOT NULL,
mQUANTITY int NOT NULL default 0, 
mODERMONEY int default 0 
);

drop table GRADE;



drop table ADDRESS;

CREATE TABLE ADDRESS(
addr_index int auto_increment PRIMARY KEY,
mID varchar(45) NOT NULL,
postcode int NOT NULL,
address1 Nvarchar(60) NOT NULL,
address2 Nvarchar(60) NOT NULL
);
select* from grade

update MEMBER set  mGRADE = 'Admin' where mID='soulrest';
select * from member































----------------------------------------------
/*등급 테이블*/
drop table GRADE;

CREATE TABLE GRADE(
GRADE varchar(15) PRIMARY KEY,/*등급*/
salerate int NOT NULL /*세일비율*/
);
----------------------------------------------

----------------------------------------------
/*주소 테이블*/
drop table ADDRESS;

CREATE TABLE ADDRESS(
addr_index int auto_increment PRIMARY KEY,
mID varchar(45) NOT NULL,/*회원 아이디*/
postcode int NOT NULL, /* 우편번호 */
address1 Nvarchar(60) NOT NULL,/*기본 주소*/
address2 Nvarchar(60) NOT NULL/*상세 주소*/
);
