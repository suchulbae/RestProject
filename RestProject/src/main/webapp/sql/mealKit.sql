--------------------------------------------------------------------------------------------
/*
 * Admin
 * Chief
 * Family
 */

drop table MEMBER;

select * from MEMBER;

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

select * from member

update member set mgrade = 'Admin' where mID = 'SoulRestCEO';
update member set mgrade = 'Chief' where mID = 'SoulRestChief';

/*admin*/
id SoulRestCEO
pw SoulRestCEO00

/*chief*/
id SoulRestChief
pw SoulRestCEO00
--------------------------------------------------------------------------------------------

/******************************************************/
밀키트 부분입니다.
/******************************************************/
select * from meal_table;
--------------------------------------------------------------------------------------------
/*밀키트 테이블*/
drop table meal_table;

create table meal_table(
meal_id Nvarchar(20) primary key,/*밀키트 id*/
meal_category Nvarchar(50) not null,/*종류=구분*/
meal_name Nvarchar(45) not null,/*밀키트 명*/
meal_price int not null,/*밀키트 가격*/
meal_detail Nvarchar(200),/*밀키트 설명*/
meal_status varchar(1) not null,/* y:판매할 수 있는 상태, n:판매불가상태 */
meal_date date,/*관리자가 메뉴 올린날짜*/
meal_image Nvarchar(100) not null
);
--------------------------------------------------------------------------------------------
/*밀키트 주문 테이블*/
drop table meal_order_table;

create table meal_order_table(
meal_order_num int auto_increment primary key,/*밀키트주문 번호*/
mID varchar(45) not null, /*주문한 사용자의 mID*/
mEMAIL varchar(45)not null,/*주문한 사용자의 mEMAIL*/
meal_order_date timestamp not null,/*주문한 날짜(하루매출조회)*/
meal_order_status varchar(25)not null,/*사용자 모드-상태:order(구매하기-주문한 상태) / 관리자모드 - 상태 : meal_get(주문승인), meal_cancel(주문취소) */
meal_totalMoney int not null/*주문한 밀키트 총 금액*/
);



select * from meal_table;
select * from  meal_Order_table;
--------------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------
/* 밀키트 주문번호 클릭하면 코스상세보기 정보 */
drop table meal_orderdetail_table;

create table meal_orderdetail_table(
meal_datail_index int auto_increment primary key,
meal_id Nvarchar(20), /*밀키트 id*/
meal_order_num int not null,/*밀키트 번호*/
meal_quantity int not null,/*밀키트 수량*/
meal_name Nvarchar(45) not null,/*밀키트 명*/
meal_price int not null /*밀키트 가격*/
);
--------------------------------------------------------------------------------------------


