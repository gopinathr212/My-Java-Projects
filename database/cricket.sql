create schema training;
use training;
create table teams (id int primary key, team varchar(20) );
-- drop table teams;
insert into teams values (1, "india"), (2,"australia"), (3,"west_indies"), (4,"bangladesh"), (5,"srilanka"),(6,"pakistan"),(7,"england"),(8,"newzeland");
select * from teams;
drop table yr;
create table yr (id int , month varchar(20),year int, win int,loss int );
insert into yr(id,month,year,win,loss) values (1,"jan",2017,1,3),(2,"feb",2017,5,3),(3,"march",2017,4,3),(4,"apirl",2017,8,1),(5,"may",2017,6,5),
(6,"june",2017,4,6),(7,"july",2017,7,2),(8,"aug",2017,8,6),(9,"sept",2017,2,5),(10,"nov",2017,1,7), (11,"jan",2017,4,2),(12,"feb",2017,2,3),(13,"march",2017,7,1),
(14,"apirl",2017,8,5),(15,"may",2017,4,5),(16,"june",2017,4,3),(17,"july",2017,8,2),(18,"aug",2017,1,4),(19,"sept",2017,5,8),(20,"nov",2017,2,6),
(1,"jan",2018,2,4),(2,"feb",2018,3,2),(3,"march",2018,7,1),(4,"apirl",2018,8,5),(5,"may",2018,4,5),
(6,"june",2018,3,4),(7,"july",2018,8,2),(8,"aug",2018,1,4),(9,"sept",2018,5,8),(10,"nov",2018,2,6),(11,"jan",2018,3,1),(12,"feb",2018,5,3),
(13,"march",2018,4,3),(14,"apirl",2018,8,1),(15,"may",2018,6,5),
(16,"june",2018,4,6),(17,"july",2018,2,7),(18,"aug",2018,8,6),(19,"sept",2018,2,5),(20,"nov",2018,7,1);
select * from yr;
alter table yr add foreign key(win) references teams(id);
alter table yr add foreign key(loss) references teams(id);
-- select   count(*),win   from yr_2017 group by win;
-- select   count(*),loss   from yr_2017 group by loss;

-- select * from yr_2017 as yy inner join teams as tt on yy.win=tt.id;
-- select * from yr_2017 as yy inner join teams as tt on yy.loss=tt.id;
-- select count(*),win from yr_2017 as yy inner join teams as tt on  yy.win=tt.id;
-- select * from yr_2017 as yy inner join teams as tt on yy.loss=tt.id;

-- drop table yr_2018;
-- create table yr_2018 (id int , month varchar(20), year int,wins int,losses int );
-- insert into yr_2018 (id,month,year,wins,losses) values (1,"jan",2018,2,4),(2,"feb",2018,3,2),(3,"march",2018,7,1),(4,"apirl",2018,8,5),(5,"may",2018,4,5),
-- (6,"june",2018,3,4),(7,"july",2018,8,2),(8,"aug",2018,1,4),(9,"sept",2018,5,8),(10,"nov",2018,2,6),(11,"jan",2018,1,3),(12,"feb",2018,5,3),
-- (13,"march",2018,4,3),(14,"apirl",2018,8,1),(15,"may",2018,6,5),
-- (16,"june",2018,4,6),(17,"july",2018,7,2),(18,"aug",2018,8,6),(19,"sept",2018,2,5),(20,"nov",2018,1,7);
-- select * from yr_2018;
-- alter table yr_2018 add foreign key(wins) references teams(id);
-- alter table yr_2018 add foreign key(losses) references teams(id);
-- select   count(*),wins   from yr_2018 group by wins;
-- select   count(*),losses   from yr_2018 group by losses;


-- select * from yr_2017 as yy inner join teams as tt on yy.win=tt.id  inner join  yr_2018 as rr on rr.wins=tt.id ;
-- select * from yr_2017 as yy inner join teams as tt on yy.loss=tt.id  inner join   yr_2018 as rr on rr.losses=tt.id;

select * from teams;
select * from yr;
-- select * from yr_2018;

-- select t1.team, win, loss from (select team, count(*) as win from yr_2017 as yy inner join teams as tt on yy.win=tt.id group by tt.team) as t1 left outer join 
-- (select team, count(*) as loss from yr_2017 as yy inner join teams as tt on yy.loss=tt.id group by tt.team) as t2 on t1.team = t2.team
-- union 
-- select t2.team, win, loss from (select team, count(*) as win from yr_2017 as yy inner join teams as tt on yy.win=tt.id group by tt.team) as t1 right outer join 
-- (select team, count(*) as loss from yr_2017 as yy inner join teams as tt on yy.loss=tt.id group by tt.team) as t2 on t1.team = t2.team;

-- select t1.team, win, loss,(case when loss is null then (win) else (win+loss) end) as total from (select team, count(*) as win from yr_2017 as yy inner join teams as tt on yy.win=tt.id group by tt.team) as t1 left outer join 
-- (select team, count(*) as loss from yr_2017 as yy inner join teams as tt on yy.loss=tt.id group by tt.team) as t2 on t1.team = t2.team
-- union 
-- select t2.team, win, loss,(case when win is null then (loss) else (win+loss) end) as total from (select team, count(*) as win from yr_2017 as yy inner join teams as tt on yy.win=tt.id group by tt.team) as t1 right outer join 
-- (select team, count(*) as loss from yr_2017 as yy inner join teams as tt on yy.loss=tt.id group by tt.team) as t2 on t1.team = t2.team;

-- select t1.team, win, loss,(case when loss is null then (win) else (win+loss) end) as total,((win/(win+loss))*100) as win_percentage from 
-- (select team, count(*) as win from yr_2017 as yy inner join teams as tt on yy.win=tt.id group by tt.team) as t1 left outer join 
-- (select team, count(*) as loss from yr_2017 as yy inner join teams as tt on yy.loss=tt.id group by tt.team) as t2 on t1.team = t2.team
-- union 
-- select t2.team, win, loss,(case when win is null then (loss) else (win+loss) end) as total,((win/(win+loss))*100) as win_percentage from 
-- (select team, count(*) as win from yr_2017 as yy inner join teams as tt on yy.win=tt.id group by tt.team) as t1 right outer join 
-- (select team, count(*) as loss from yr_2017 as yy inner join teams as tt on yy.loss=tt.id group by tt.team) as t2 on t1.team = t2.team;

-- select t1.team, win, loss,(case when loss is null then (win) else (win+loss) end) as total from 
-- (select team, count(*) as win from yr_2018 as yy inner join teams as tt on yy.wins=tt.id group by tt.team) as t1 left outer join 
-- (select team, count(*) as loss from yr_2018 as yy inner join teams as tt on yy.losses=tt.id group by tt.team) as t2 on t1.team = t2.team
-- union 
-- select t2.team, win, loss,(case when win is null then (loss) else (win+loss) end) as total from
-- (select team, count(*) as win from yr_2018 as yy inner join teams as tt on yy.wins=tt.id group by tt.team) as t1 right outer join 
-- (select team, count(*) as loss from yr_2018 as yy inner join teams as tt on yy.losses=tt.id group by tt.team) as t2 on t1.team = t2.team;

-- select t1.team, win, loss,(case when loss is null then (win) else (win+loss) end) as total,((win/(win+loss))*100) as win_percentage from 
-- (select team, count(*) as win from yr_2018 as yy inner join teams as tt on yy.wins=tt.id group by tt.team) as t1 left outer join 
-- (select team, count(*) as loss from yr_2018 as yy inner join teams as tt on yy.losses=tt.id group by tt.team) as t2 on t1.team = t2.team
-- union 
-- select t2.team, win, loss,(case when win is null then (loss) else (win+loss) end) as total,((win/(win+loss))*100) as win_percentage from 
-- (select team, count(*) as win from yr_2018 as yy inner join teams as tt on yy.wins=tt.id group by tt.team) as t1 right outer join 
-- (select team, count(*) as loss from yr_2018 as yy inner join teams as tt on yy.losses=tt.id group by tt.team) as t2 on t1.team = t2.team;

-- select y1.team,year,win_percentage from
-- (select team , year,max((win/(win+loss))*100) as win_percentage from yr_2017 as y17 inner join teams as t on y17.win=t.id) as y1
-- union
-- select y2.team,year,win_percentage from
-- (select team , year,max((wins/(wins+losses))*100) as win_percentage from yr_2018 as y18 inner join teams as t on y18.wins=t.id) as y2;

select y1.team,year,win_percentage from
(select team , year,max((win/(win+loss))*100) as win_percentage from yr as yrs inner join teams as t on yrs.win = t.id group by t.team) as y1 order by win_percentage ;

select t1.team,win,loss from
(select team, count(*) as win from yr as yy inner join teams as tt on yy.win=tt.id group by tt.team) as t1 left outer join
(select team, count(*) as loss from yr as yy inner join teams as tt on yy.loss=tt.id group by tt.team) as t2  on t1.team=t2.team
union
select t1.team,win,loss from
(select team, count(*) as win from yr as yy inner join teams as tt on yy.win=tt.id group by tt.team) as t1 right outer join
(select team, count(*) as loss from yr as yy inner join teams as tt on yy.loss=tt.id group by tt.team) as t2  on t1.team=t2.team;