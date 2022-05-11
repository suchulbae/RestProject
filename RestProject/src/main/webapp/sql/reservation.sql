/*
 * 예약 테이블
 */
drop table RESERVATION_MENU;
DROP TABLE GRADE;
drop table ReservationOrder_table;
drop table ResOrderDetail_table;
--수정
create table RESERVATION_MENU(
menuID varchar(45) PRIMARY KEY, 
category Nvarchar(50) not null,
menuNAME Nvarchar(45) not null,
menuDETAIL Nvarchar(200),/*메뉴자세한정보*/
m_status varchar(1) not null,/*예약가능불가*/
resvPRICE int not null,/*메뉴 가격*/
resvORDERDATE DATE not null,/*등록시간*/
image Nvarchar(100) not null

);

SELECT * FROM RESERVATION_MENU WHERE category='PREMIUMSIDES';
select * from ReservationOrder_table

SELECT sum(totalMoney) as minusTotalMoney  FROM ReservationOrder_table WHERE  DATE(resvDATE)=curdate()-1 and order_status='get';


SELECT count(order_num) FROM ReservationOrder_table WHERE curdate() and order_status='order'  ;
//일매출
SELECT *sum(totalMoney) FROM ReservationOrder_table WHERE  DATE(resvDATE)=curdate() and order_status='get' group by resvDATE;
SELECT *sum(totalMoney) FROM ReservationOrder_table WHERE  DATE(resvDATE)=curdate()and order_status='get' group by resvDATE;

select * from RESERVATION_MENU;

SELECT * FROM RESERVATION_MENU WHERE category='Course'
select * from GRADE;

CREATE TABLE GRADE(
mGRADE varchar(15) PRIMARY KEY,
salerate int NOT NULL
);

SELECT * FROM ReservationOrder_table WHERE order_status='get'and  resvDATE BETWEEN DATE_ADD(NOW(),INTERVAL -1 WEEK  ) AND NOW();



insert into GRADE values('Familly',1);
insert into GRADE values('VIP', 10);
insert into GRADE values('VVIP',15);
insert into GRADE values('admin', 0);


create table ReservationOrder_table(
order_num int auto_increment primary key,
mID varchar(45) not null, /*주문한 사용자의 ID*/
mEMAIL varchar(45)not null,
resvORDERDATE timestamp not null,
order_status varchar(25)not null,
totalMoney int not null,
resvDATE DATETIME not null/*예약요일*/
);
drop table ResOrderDetail_table;

select * from ReservationOrder_table

select * from ResOrderDetail_table

create table ResOrderDetail_table(
datail_index int auto_increment primary key,
menuID Nvarchar(20), 
order_num int not null,/*주문 번호*/
quantity int not null,/*주문 수량*/
menuNAME Nvarchar(45) not null,/*메뉴명*/
resvPRICE int not null, /*메뉴 가격*/
resvDATE DATETIME not null/*예약요일*/

);
create table rev
(
resvDATE DATETIME


);
SELECT * FROM ReservationOrder_table
insert into  rev values('2022-04-29 15:51');
select CURDATE() 
 
SELECT   sum(totalMoney)  FROM ReservationOrder_table WHERE resvDATE BETWEEN DATE_ADD(NOW(),INTERVAL -1 MONTH ) AND NOW();
select 


//월 총 매출 
select  sum(totalMoney) ,month(resvORDERDATE) ,date(resvDATE)
from ReservationOrder_table where order_status='get' and month(resvORDERDATE) 
group by resvDATE 
order by resvDATE
;





select  sum(totalMoney) ,month(resvORDERDATE)  from ReservationOrder_table where order_status='get' and month(resvORDERDATE);
select resvDATE from ReservationOrder_table
select  sum(totalMoney) ,month(resvDATE) M  from ReservationOrder_table where order_status='get' group by M  ;

 select sum(totalMoney) from ReservationOrder_table where MONTH(resvDATE) = MONTH(CURRENT_DATE()) and order_status='get';
  select resvORDERDATE,sum(totalMoney) from ReservationOrder_table where CURDATE(resvDATE) = CURDATE() and order_status='get';

DROP TABLE RESERVATION;
DROP TABLE RESERVATION_MENU;
