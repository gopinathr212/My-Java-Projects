create schema students;
create table students.details(id int, name varchar(40),age int);
insert students.details values(11,'gopinath',17),(12,'karthick',18),(13,'hariharan',17),(14,'harikiran',17),(15,'gokul',17),(16,'naveen',18),
(17,'nandha',18),(18,'gopal',17),(19,'ashwin',18),(20,'rohit',18);
select*from students.details;
-- truncate table students.details;
select count(name) from students.details;
select max(age) from students.details;
select min(age) from students.details;
select age,count(*) from students.details group by age;
alter table students.details add ( englsig int,tamil int, maths int, chemistry int, physics int,class int,section varchar(10),physics_passed varchar(20));
drop table students.details;
select*from students.details;
update students.details set englsig = 78, tamil = 82 , maths = 79, chemistry = 81, physics = 88,class=12, section='a',physics_passed='pass'where id=11;
set SQL_SAFE_UPDATES=0;
update students.details set englsig = 87, tamil = 84 , maths = 72, chemistry = 83, physics = 84,class=12,section='c',physics_passed='pass'where id=12; 
update students.details set englsig = 72, tamil = 82 , maths = 82, chemistry = 85, physics = 88,class=12,section='a',physics_passed='pass'where id=13;
update students.details set englsig = 83, tamil = 89 , maths = 88, chemistry = 77, physics = 78,class=12,section='b',physics_passed='pass'where id=14;
update students.details set englsig = 92, tamil = 86 , maths = 70, chemistry = 82, physics = 64,class=12,section='d',physics_passed='pass'where id=15;
update students.details set englsig = 96, tamil = 86 , maths = 80, chemistry = 85, physics = 91,class=12,section='a',physics_passed='pass'where id=16;
update students.details set englsig = 70, tamil = 81 , maths = 86, chemistry = 76, physics = 90,class=12,section='d',physics_passed='pass'where id=17;
update students.details set englsig = 78, tamil = 72 , maths = 85, chemistry = 88, physics = 82,class=12,section='c',physics_passed='pass'where id=18;
update students.details set englsig = 89, tamil = 89 , maths = 89, chemistry = 72, physics = 84,class=12,section='b',physics_passed='pass'where id=19;
update students.details set englsig = 81, tamil = 80 , maths = 92, chemistry = 92, physics = 73,class=12,section='b',physics_passed='pass'where id=20;
select max(englsig), max(tamil) , max(maths), max(chemistry) , max(physics) from students.details;
select (englsig+tamil+maths+chemistry+physics) from students.details where id=11;
select (englsig+tamil+maths+chemistry+physics)/5 from students.details where id=13;
select sum(englsig) from students.details;
select avg(englsig) from students.details;
select*from students.details where name like "g%";
select*from students.details where name like "_o%";
select*from students.details where name like "%op%";
select*from students.details where tamil between 80 and 85;
select*from students.details where tamil not between 80 and 85;
select*from students.details where tamil between 70 and 88 
and id not in (11,14,15);
select name as n , maths as m , physics as p ,physics_passed as pp from students.details;
select name ,id,physics_passed as pp, englsig+tamil+maths+chemistry+physics as total from students.details;
select name ,id,physics_passed as pp, (englsig+tamil+maths+chemistry+physics)/5 as avg from students.details;
update students.details set tamil=90 where name ='gopinath';
alter table students.details change englsig  english int;