create schema laws;
create table laws.court_table(court_id int, court_location varchar(50),court_type varchar(40));
insert  laws.court_table values (31,"uthangarai","sub_court"),
(32,"uthangarai","dis_court"),
(33,"uthangarai","main_court"),
(34,"uthangarai","bran_court"),
(35,"uthangarai","unit_court"),
(36,"uthangarai","central_court"),
(37,"uthangarai","div_court");
select*from laws.court_table;
-- drop table laws.court_table;
create table laws.judge_table(court_id int,judge_id int,judge_name varchar(80),start_year int,
gender varchar(40),email_id varchar(40));
insert laws.judge_table values(31,21,"krishnan",2002,"male","krishna@gmail.com"),
 (32,22,"rani",2002,"female","rani@gmail.com"),
 (33,23,"ramu",2002,"male","ramu@gmail.com"),
 (34,24,"kayal",2002,"female","kayal@gmail.com"),
 (35,25,"ari",2002,"male","ari@gmail.com"),
 (36,26,"karan",2002,"female","karan@gmail.com"),
 (37,27,"rajesh",2002,"male","rajesh@gmail.com");
 select * from laws.judge_table;
-- drop table laws.judge_table;
create table laws.address_table(id int , area_name varchar(40),street_name varchar(30),city varchar(40),
district varchar(30),state varchar (40), pincode int, jid_no int);
insert laws.address_table values(11, "annanagar","kailas","uthangarai","krishnagiri","tamilnadu",635207,21),
(12 , "periyarnagar","sekar","uthangarai","krishnagiri","tamilnadu",635207, 27),
(13 , "perurnagar","raghul","uthangarai","krishnagiri","tamilnadu",635207, 23),
(14, "ravinagar","pretthi","uthangarai","krishnagiri","tamilnadu",635207, 22),
(15 , "gandhinagar","kirthi","uthangarai","krishnagiri","tamilnadu",635207, 24),
(16 , "balajinagar","paaru","uthangarai","krishnagiri","tamilnadu",635207 , 25),
(17 , "anbunagar","pelur","uthangarai","krishnagiri","tamilnadu",635207, 26);
select * from laws.address_table;
-- drop table laws.address_table;
create table laws.complaint_table(id int,complaint_type varchar(50),is_active boolean, cd_id int , jid int );
insert laws.complaint_table values(1,"civil",true,31,21 ),
(2,"civil",false, 32,22 ),
(3,"civil",true,33,23),
(4,"civil",true,34,24),
(5,"civil",false, 35,25),
(6,"civil",false, 36,26),
(7,"civil",false, 37,27);
select * from laws.complaint_table;
-- drop table laws.complaint_table;
select*from laws.court_table c
inner join laws.judge_table j on c.court_id = j.court_id
inner join laws.address_table a on a.jid_no=j.judge_id 
inner join laws.complaint_table co on co.cd_id=c.court_id;

