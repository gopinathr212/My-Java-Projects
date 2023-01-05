create schema student_college;
use student_college;

create table student_details (sid int primary key,name varchar(40),c_id int,dept_name varchar(40),sec varchar(5),stud_address varchar(40));

insert student_details values(1,"Gopi",101,"EEE","A","Uthangarai"),
(2,"Hari",102,"EEE","B","Uthangarai"),
(3,"Gokul",103,"CSE","A","Singarapettai"),
(4,"Arun",101,"CSE","B","Uthangarai"),
(5,"Karthick",102,"EEE","C","Uthangarai"),
(6,"Subash",103,"CSE","C","Singarapettai");

select * from student_details;

drop table student_details; 

create table college_details (id int primary key,clg_name varchar(40),clg_address varchar(40));

insert college_details values(101,"RMD","Kavaraipettai"),(102,"VelTech","Ambattur"),(103,"PSG","Coimbatore");
select * from college_details;
-- drop table college_details;

select * from student_details s inner join college_details c where s.c_id=c.id;