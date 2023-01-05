create schema employeems;

use employeems;

create table employee_details  (id int primary key, name varchar(40) , age int, email varchar(40));

insert employee_details values(1,"Tiger",20,"t@gmail.com"),
							(2,"Lion",25,"l@gmail.com"),
							(3,"Cat",32,"c@gmail.com"),
							(4,"Elephant",40,"e@gmail.com"),
							(5,"Zebra",30,"z@gmail.com");

select * from employee_details;