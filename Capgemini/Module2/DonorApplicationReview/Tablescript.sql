CREATE TABLE Donor_Details(
Donor_Id VARCHAR2(20),
Donor_Name VARCHAR2(20),
Address VARCHAR2(20),
Phone_Number VARCHAR2(20),
Donor_Date DATE,
Donor_Amount NUMBER);

CREATE SEQUENCE donorId_sequence
START WITH 1000;