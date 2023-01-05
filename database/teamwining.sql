create schema international_match;
use international_match;
create table teams(teamid int ,team_name varchar(40),team_country varchar(20));
-- describe teams;
insert into  teams values(1,'bcci','india'),(2,'ca','australia'),(3,'ecb','england'),(4,'pcb','pakistan'),(5,'rsa','south_africa'),(6,'slc','srilanka');
select * from teams;

create table stats(matchid int, month varchar(15),year int,winning_teamid int,losing_teamid int);
insert into stats values(1,'jan',2017,1,2),
                        (2,'jan',2017,6,3),
                        (3,'jan',2017,4,5),
                        (4,'feb',2017,3,4),
                        (5,'feb',2017,2,6),
                        (6,'march',2017,1,5),
                        (7,'march',2017,4,2),
                        (8,'april',2017,5,3);
select * from stats;
-- drop table stats;
-- select month,count(winning_teamid) from stats  where winning_teamid=1;
-- select winning_team,count(winning_teamid) from stats group by winning_team;
-- select winning_team,year from stats INNER JOIN teams where stats.winning_team = teams.team_country;
-- select losing_team,count(losing_teamid) from stats group by losing_team;
-- select winning_team ,count(winning_teamid) from stats group by winning_team union all
-- select losing_team,count(losing_teamid) from stats group by losing_team ;
-- select team_country from teams INNER JOIN stats where stats.winning_team = teams.team_country; 
alter table stats add foreign key(winning_teamid) references teams(teamid);
alter table stats add foreign key(losing_teamid) references teams(teamid);
select t1.team_country,win,loss from
(select team_country,count(*) as win  from stats as s inner join teams as t where s.winning_team = t.teamid group by team_country) as t1 
left outer join
(select team_country,count(*) as loss from stats as s inner join teams as t where s.losing_team = t.teamid group by team_country) as t2 
on t1.team_country=t2.team_country;