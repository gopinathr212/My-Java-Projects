create schema teachermsdb;

use teachermsdb;

create table teacher_details(id int, name varchar(40), age int, salary long, height int, email varchar(60));

insert teacher_details values(1,"Gopal",55,155000,165,"gopal@gmail.com"),
(2,"Gookol",50,150000,170,"gookol@gmail.com"),
(3,"Karun",58,108000,169,"karun@gmail.com"),
(4,"Kowtham",45,105000,170,"kowtham@gmail.com"),
(5,"soobash",25,81000,168,"soobash@gmail.com");

drop table teacher_details;
select * from teacher_details;