<--Database queries-->

<--Create mobiles table query-->
CREATE TABLE mobiles (mobileid NUMBER PRIMARY KEY, name VARCHAR2 (20), price NUMBER(10,2),quantity VARCHAR2(20));

<--Quories for insert data into mobiles table-->
INSERT INTO mobiles VALUES(1001,’Nokia Lumia 520’,8000,20);
INSERT INTO mobiles VALUES(1002,’Samsung Galaxy IV’,38000,40);
INSERT INTO mobiles VALUES(1003,’Sony xperia C’,15000,30);

<--Create purchasedetails table query-->
CREATE TABLE purchasedetails(purchaseid NUMBER, cname vARCHAR2(20), mailid VARCHAR2(30),phoneno VARCHAR2(20), purchasedate DATE, mobileid references mobiles(mobileid));


<--Create sequence query-->

CREATE SEQUENCE mobileid_sequence START WITH 1000 INCREMENT BY 1 NOCYCLE;
CREATE SEQUENCE purchaseid_sequence START WITH 1000 INCREMENT BY 1 NOCYCLE;