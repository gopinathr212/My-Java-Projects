create schema inform;
create table inform.details(id int, name varchar(30), age varchar(50));
insert inform.details value(10,'gopinath','twenty_two'),(23,'karthick','twenty'),(21,'hariharan','twenty_one'),
(19,'jeeva','twenty');
select*from inform.details;
alter table inform.details change name fname varchar(20);
drop table inform.details;
alter table inform.details add lname varchar(20);
update inform.details set lname='rajasekar' where id=10;
update inform.details set lname='naharaji' where id=23;
update inform.details set lname='venkatesh' where id=21;
update inform.details set lname='kumar' where id=19;
alter table inform.details change age age int;
update inform.details set age=replace(age,'twenty_two',22);
update inform.details set age=replace(age,'twenty',20) where id=23;
update inform.details set age=replace(age,'twenty_one',21);
update inform.details set age=replace(age,'twenty',20) ;