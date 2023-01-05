create schema student_and_college;
use student_and_college;

create table student(id int,name varchar(40),age int,email varchar(40));
insert student values(1,"Gopi",26,"gopi@gmail.com"),(2,"Subash",28,"subash@gmail.com");
select*from student;

create table college(clg_id int,clg_name varchar(40));
insert college values(101,"RMD"),(102,"KCT"),(103,"PSG");
select*from college;
-- drop table college;

create table college_student(map_id int,st_id int,c_id int,course varchar(30),passing_year int);
insert college_student values(1001,1,101,"BE-EEE",2014),(1002,1,103,"ME",2016),(1003,2,102,"BE-Civil",2012),(1004,2,103,"ME",2015);
select * from college_student;
drop table college_student;

select map_id,st_id,name,c_id,clg_name,course from	
(select map_id,st_id,c_id,course,name,email from college_student cs inner join student s where cs.st_id=s.id) as csx
 inner join college c where csx.c_id=c.clg_id order by st_id;