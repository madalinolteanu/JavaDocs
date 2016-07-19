CREATE USER madalinolteanu IDENTIFIED BY madalinolteanu; -- you should replace my user name with yours. â€œIDENTIFIED BYâ€? means the password.
GRANT CREATE SESSION TO madalinolteanu; -- necessary for connecting to the database with your new user.
GRANT CREATE ANY INDEX TO madalinolteanu; -- we use indexes for faster queries.
GRANT ALTER ANY INDEX TO madalinolteanu;
GRANT DROP ANY INDEX TO madalinolteanu;
GRANT CREATE ANY PROCEDURE TO madalinolteanu; -- we will use them in following workshops.
GRANT ALTER ANY PROCEDURE TO madalinolteanu;
GRANT DROP ANY PROCEDURE TO madalinolteanu;
GRANT EXECUTE ANY PROCEDURE TO madalinolteanu;
GRANT CREATE ANY SEQUENCE TO madalinolteanu; -- we need sequences for inserting data.
GRANT ALTER ANY SEQUENCE TO madalinolteanu;
GRANT DROP ANY SEQUENCE TO madalinolteanu;
GRANT SELECT ANY SEQUENCE TO madalinolteanu;
GRANT CREATE ANY TABLE TO madalinolteanu;
GRANT ALTER ANY TABLE TO madalinolteanu;
GRANT DELETE ANY TABLE TO madalinolteanu;
GRANT DROP ANY TABLE TO madalinolteanu;
GRANT INSERT ANY TABLE TO madalinolteanu;
GRANT LOCK ANY TABLE TO madalinolteanu;
GRANT SELECT ANY TABLE TO madalinolteanu;
GRANT UPDATE ANY TABLE TO madalinolteanu;
GRANT CREATE TABLESPACE TO madalinolteanu;
GRANT ALTER TABLESPACE TO madalinolteanu;
GRANT DROP TABLESPACE TO madalinolteanu;
GRANT CREATE ANY VIEW TO madalinolteanu;
GRANT DROP ANY VIEW TO madalinolteanu;
GRANT UNDER ANY VIEW TO madalinolteanu;
alter user madalinolteanu quota 50m on system;
