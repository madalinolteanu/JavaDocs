CREATE TABLE JOBS(
  JOB_ID NUMBER PRIMARY KEY,
  JOB_TITLE VARCHAR2(35)  NOT NULL,
  MIN_SALARY  NUMBER(6),
  MAX_SALARY  NUMBER(6)
  );

CREATE TABLE EMPLOYEES(
  EMPLOYEE_ID NUMBER PRIMARY KEY,
  FIRST_NAME VARCHAR2(20),
  LAST_NAME VARCHAR2(25)  NOT NULL,
  EMAIL VARCHAR2(25)  NOT NULL,
  PHONE_NUMBER VARCHAR2(20),
  HIRE_DATE DATE   NOT NULL,
  JOB_ID  VARCHAR2(10)  NOT NULL,
  SALARY NUMBER(8,2),
  COMMISSION_PCT NUMBER(2,2),
  MANAGER_ID  NUMBER,
  DEPARTMENT_ID NUMBER
  );
  
  CREATE SEQUENCE TAB_DEPARTMENTS_SEQ
  START WITH 1
  INCREMENT BY 1;
  CREATE SEQUENCE TAB_EMPLOYEES_SEQ
  START WITH 1
  INCREMENT BY 1;
  CREATE SEQUENCE ZTH_SEQ
  START WITH 406
  INCREMENT BY 1;
  
  ALTER TABLE EMPLOYEES ADD FOREIGN KEY (DEPARTMENT_ID)
  REFERENCES DEPARTMENTS(DEPARTMENT_ID);
  ALTER TABLE EMPLOYEES ADD FOREIGN KEY (JOB_ID)
  REFERENCES JOBS(JOB_ID);
  ALTER TABLE EMPLOYEES ADD FOREIGN KEY (MANAGER_ID)
  REFERENCES EMPLOYEES(EMPLOYEE_ID);
 
 insert into departments values 
  (TAB_DEPARTMENTS_SEQ.nextval,
   'Administration',
   1700
);

  ALTER TABLE Employees modify (
  JOB_ID  varchar2(30)
);
  ALTER TABLE JOBS modify (
  JOB_ID  varchar2(30)
);
insert into JOBS values
('AD_PRES1','President',20000,40000
);


insert into employees values(
  TAB_EMPLOYEES_SEQ.nextval,
  'Steven','King','SKING','515.123.4567',sysdate,'AD_PRES',24000,NULL,NULL,90
  );
  
DELETE FROM departments;
DELETE FROM locations;
DELETE FROM jobs;
DELETE FROM employees;

SELECT * FROM employees;
select * from departments;
select * from jobs;
select * from locations;

select * from employees where Department_id = 50;

UPDATE employees
 Set salary = salary + salary * 30/100
 where department_id = 50;
 
 delete from employees
 where employee_id = 101;
 
-- alter table employees drop constraint SYS_C007003;

select * from employees where job_id = 'IT_PROG' order by first_name ASC ;

select count(employee_id) from employees emp where emp.JOB_ID = 'IT_PROG';

select * from EMPLOYEES e join DEPARTMENTS d on e.DEPARTMENT_ID = d.department_id where d.department_id = 50;

select * from employees
join departments on employees.DEPARTMENT_ID = departments.department_id
where departments.location_id = 1700; 