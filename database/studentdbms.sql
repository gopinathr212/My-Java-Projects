create schema studentms;

use studentms;

create table student_details  (id int primary key, name varchar(40) , age int,class varchar(10), gender varchar(10),school_name varchar(50),
student_address varchar(50));

insert student_details values(1,"Tiger",10,"Fifth","m","vvms","uthangarai"),
							(2,"Lion",11,"Fifth","f","vvms","perambalur"),
							(3,"Cat",9,"Fifth","m","vvms","uthangarai"),
							(4,"Elephant",12,"Sixth","m","vvms","uthangarai"),
							(5,"Zebra",12,"Sixth","m","vvms","ooty");

select * from student_details;