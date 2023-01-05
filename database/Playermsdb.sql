create schema playersms;
use playersms;
-- drop table players;
create table players(id int primary key auto_increment,name varchar(30),age int,email varchar(30),height int,weight int,team varchar(40));
insert into players values
(1,'subash',25,'subash@gmail.com',175,58,'csk'),
(2,'karthi',22,'karthi@gmail.com',180,75,'rcb'),
(3,'gopi',21,'gopi@gmail.com',170,65,'mi'),
(4,'gokul',21,'gokul@gmail.com',172,66,'delhi'),
(5,'arun',22,'arun@gmail.com',173,59,'punjab'),
(6,'gowtham',25,'gowtham@gmail.com',187,57,'csk'),
(7,'guru',25,'guru@gmail.com',182,66,'mi');
select * from players;