create schema workers;
create table workers.details(id int,name varchar(40),salary int,occupation varchar(40));
insert workers.details values(01,'amit',16000,'salesman'),
(02,'joel',20000,'marketing'),(03,'raja',22000,'marketing'),(04,'puneeth',16000,'salesman');
select*from workers.details; 
select occupation,sum(salary)from workers.details where occupation='salesman';
select occupation,avg(salary) from workers.details where occupation='marketing';
select*,max(salary) from workers.details;
select*,count(*) from workers.details group by salary;
select occupation,count(*) from workers.details group by salary;
select* from workers.details order by salary;
select*from workers.details where salary is not null;