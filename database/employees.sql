create schema employee;
create table employee.details( id int, name varchar(30), mobile_number bigint, 
age int, gender varchar(10), email varchar(50));
insert employee.details values(01,'gopi',1234567890,22,'male','gopi@gmail.com'),
(02,'hari',9874563210,22,'male','hari@gmail.com'),
(03,'gokul',9586743210,22,'male','gokul@gmail.com'),
(04,'naveen',9638527410,23,'male','naveen@gmail.com'),
(05,'karthick',951753620,22,'male','karthick@gmail.com');
select*from employee.details;
alter table employee.details add eid int;
update employee.details  set eid=001 where id=01;
update employee.details  set eid=002 where id=02; 
update employee.details  set eid=003 where id=03;
update employee.details  set eid=004 where id=04;
update employee.details  set eid=005 where id=05;
set SQL_SAFE_UPDATES=0;
select*from employee.details order by name;
select min(age), max(age) from employee.details;
alter table employee.details add salary int;
update employee.details set salary=20000 where id=01;
update employee.details  set salary=10000 where id=02; 
update employee.details  set salary=45000 where id=03;
update employee.details  set salary=16000 where id=04;
update employee.details  set salary=20000 where id=05;
select avg(salary) from employee.details;
select*,count(*) from employee.details group by salary;
select salary,count(*) from employee.details group by salary;
select count(*) from employee.details group by salary;
delete from employee.details where id=02;
drop table employee.details;
create table employee.company(id int, company_name varchar(30), company_location varchar(20));
insert employee.company values(001,'act','doddabellapur'),
(002,'wipro','chennai'),
(003,'tcs','mumbai'),(004,'infosys','chennai'),(005,'cts','mumbai');
select*from employee.company;
select*from employee.details s inner join employee.company r on s.id=r.id;
select * from employee.details s cross join employee.company r where name='gopi';
select length('gopi') from dual;
alter table employee.details change mobile_number phone_number bigint;
update employee.details set name = replace(name,'hari','hariharan');
select*from employee.details where not salary=20000 ;
select*from employee.company where company_location ='mumbai';
select*from employee.details where not salary=20000 and not salary=16000;
-- delete from employee.details where id=2; 