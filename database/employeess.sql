create schema employees;
create table employees.details(eid int, ename varchar(20),age int, gender varchar(15),
 date_of_joining date, department varchar(50), city varchar(20), salary int);
 insert employees.details values(110,'amit',32,'male','2020-5-25','quality','bangalore',18000),
								(112,'gopinath',28,'male','2021-10-1','quality','bangalore',14000),
                                (105,'venky',35,'male','2015-5-15','maintenance','bangalore',35000),
                                (113,'pooja',25,'female','2022-1-16','production','bangalore',12000),
								(095,'Venkatesh_bhatt',48,'male','2009-6-6','fgi','bangalore',50000),
                                (087,'Bala',39,'male','2009-4-8','maintenance','bangalore',42000),
                                (088,'aiyanar',32,'male','2009-5-15','design_and_development','bangalore',50000),
                                (051,'soribabu',52,'male','2006-8-13','design_and_development','bangalore',140000),
								(108,'amirtha',29,'female','2020-5-10','design_and_development','bangalore',22000),
							    (092,'harshitt',33,'male','2010-8-13','production','bangalore',25000),
                                (111,'kowshik',31,'male','2020-9-30','production','bangalore',16000),
								(069,'akhilesh_kr-singh',50,'male','2007-11-10','production','bangalore',80000),
                                (065,'siju',49,'male','2007-12-10','quality','bangalore',78000), 
                                (087,'jayant',39,'male','2009-4-08','quality','bangalore',45000),
                                (089,'suresh',38,'male','2009-5-13','quality','bangalore',40000),
                                (090,'raja',36,'male','2009-5-10','quality','bangalore',40000),
                                (096,'eshwari',46,'female','2009-12-4','fgi','bangalore','50000'),
                                (133,'goutam',33,'male','2015-06-08','fgi','bangalore',25000),
                                (119,'bhavani',36,'female','2014-08-08','production','bangalore',32000),
                                (120,'surrender',42,'male','2016-06-21','production','bangalore',38000),
                                (121,'vinay',31,'male','2018-06-20','quality','bangalore',28000),
                                (152,'sanjiv',38,'male','2014-09-22','fgi','bangalore',30000),
                                (067,'kukanur',58,'male','2012-08-25','maintenance','bangalore',82000),
                                (122,'vikas_reddy',44,'male','2014-05-09','maintenance','bangalore',45000),
                                (126,'surya',32,'male','2018-05-08','production','bangalore',30000),
                                (115,'manikandan',42,'male','2019-06-30','fgi','bangalore',42000),
                                (052,'vs_raman',68,'male','2006-09-12','design_and_development','bangalore',180000),
                                (123,'ajay',45,'male','2012-05-03','maintenance','bangalore',32000),
                                (180,'binod',42,'male','2013-12-2','maintenance','bangalore',30000),
                                (119,'subrath',44,'male','2015-05-8','fgi','bangalore',28000);
-- drop table employees.details;
select*from employees.details;					
select department,min(salary) from employees.details group by department;
select department,max(salary) from employees.details group by department;
select max(salary) from employees.details;
select * from employees.details where age > 30;
select department, count(*) from employees.details group by department;
select department, avg(salary) from employees.details  group by department ;
select avg(salary) from employees.details ;
select distinct(department),length(department) from employees.details;
select ename from employees.details where gender='female';
select gender,sum(salary) from employees.details group by gender;
select ename from employees.details where ename like "a%";