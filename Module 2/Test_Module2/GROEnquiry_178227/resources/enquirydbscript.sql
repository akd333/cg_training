/*************************** Global Recruitments Organization *****************************/

/*Create inquiry table script */
CREATE TABLE enquiry(enqryId Number Primary Key , firstName Varchar2(20), lastName varchar2(20),
contactNo Number(10), domain Varchar2(20), city Varchar2(20));

/* Sequence Script */
CREATE SEQUENCE enquiries 
MINVALUE 1001
MAXVALUE 9999
START WITH 1001
INCREMENT BY 1
NOCACHE;