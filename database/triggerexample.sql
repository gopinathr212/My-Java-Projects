create schema workerzzz;
create table workerzzz.details(id int,name varchar(40),salary int,occupation varchar(40));
insert workerzzz.details values(100,'amit',16000,'salesman'),
(200,'joel',20000,'marketing'),(300,'raja',22000,'marketing'),(400,'puneeth',16000,'salesman');
select * from workerzzz.details;

delete from workerzzz.details where id=200;
set SQL_SAFE_UPDATES=0;
create table workerzzz.del (id int,name varchar(40),salary int,occupation varchar(40), date_time timestamp default now());
create trigger workerzzz.delete_cont before delete on workerzzz.details for each row insert into workerzzz.del(id,name,salary,occupation) values (old.id,old.name,old.salary,old.occupation);
select * from workerzzz.del; 
create trigger workerzzz.insert_cont after insert on workerzzz.details for each row insert into workerzzz.del(id,name,salary,occupation) values (new.id,new.name,new.salary,new.occupation);
drop table workerzzz.del;

