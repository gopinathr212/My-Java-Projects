create schema CRICKET_STATS;
use CRICKET_STATS;
CREATE TABLE teams (
    ID INT,
    TEAMS VARCHAR(20),
    COUNTRY VARCHAR(20)
);
insert into teams values
    (1, 'IND_Team', 'IND'),
    (2, 'PAK_Team', 'PAK'),
    (3, 'AUS_Team', 'AUS'),
    (4, 'SA_Team', 'SA'),
    (5, 'ENG_Team', 'ENG');
SELECT 
    *
FROM
    teams;

CREATE TABLE stats (
    SID INT,
    YEAR INT,
    MONTH VARCHAR(10),
    WINNING_TEAM INT,
    LOSSING_TEAM INT
);
insert into stats values
    (1, 2017, 'JAN', 1, 2),
    (2, 2017, 'JUN', 3, 4),
    (3, 2017, 'DEC', 1, 5),
    (4, 2017, 'MAR', 3, 4),
    (5, 2018, 'JUN', 5, 2),
    (6, 2018, 'DEC', 4, 2),
    (7, 2018, 'FEB', 1, 4),
    (8, 2018, 'MAR', 3, 2),
    (9, 2019, 'NOV', 1, 5),
    (10, 2019, 'MAR', 1, 2),
    (11, 2019, 'NOV', 1, 3),
    (12, 2020, 'JUN', 4, 5),
    (13, 2020, 'DEC', 5, 2),
    (14, 2020, 'JAN', 3, 4),
    (15, 2020, 'OCT', 1, 3);
SELECT 
    *
FROM
    stats;

SELECT 
    YEAR, COUNTRY, MAX(WINNING_PERCENTAGE) AS PERFORMER_OF_THE_YEAR
FROM
    (SELECT 
        t1.YEAR,
            t1.COUNTRY,
            (CASE
                WHEN (LOSSING_TEAM) IS NULL THEN (WINNING_TEAM)
                ELSE (WINNING_TEAM + LOSSING_TEAM)
            END) AS MATCHES_PLAYED,
            (CASE
                WHEN (LOSSING_TEAM) IS NULL THEN 100
                WHEN (WINNING_TEAM) IS NULL THEN 0
                ELSE ((WINNING_TEAM / (WINNING_TEAM + LOSSING_TEAM)) * 100) 
            END) AS WINNING_PERCENTAGE,
            WINNING_TEAM,
            LOSSING_TEAM
    FROM
        (SELECT 
        YEAR, COUNTRY, COUNT(*) AS WINNING_TEAM
    FROM
        stats AS yy
    INNER JOIN teams AS tt ON yy.WINNING_TEAM = tt.ID
    GROUP BY tt.COUNTRY, yy.YEAR ) AS t1
    LEFT OUTER JOIN (SELECT 
        YEAR, COUNTRY, COUNT(*) AS LOSSING_TEAM
    FROM
        stats AS yy
    INNER JOIN teams AS tt ON yy.LOSSING_TEAM = tt.ID
    GROUP BY tt.COUNTRY, yy.YEAR ) AS t2 ON t1.COUNTRY = t2.COUNTRY UNION SELECT 
        t2.YEAR,
            t2.COUNTRY,
            (CASE
                WHEN (WINNING_TEAM) IS NULL THEN (LOSSING_TEAM)
                ELSE (WINNING_TEAM + LOSSING_TEAM)
            END) AS MATCHES_PLAYED,
            (CASE
                WHEN (LOSSING_TEAM) IS NULL THEN 100
                WHEN (WINNING_TEAM) IS NULL THEN 0
                ELSE ((WINNING_TEAM / (WINNING_TEAM + LOSSING_TEAM)) * 100) 
            END) AS WINNING_PERCENTAGE,
            WINNING_TEAM,
            LOSSING_TEAM
    FROM
        (SELECT 
        YEAR, COUNTRY, COUNT(*) AS WINNING_TEAM
    FROM
        stats AS yy
    INNER JOIN teams AS tt ON yy.WINNING_TEAM = tt.ID
    GROUP BY tt.COUNTRY, yy.YEAR ) AS t1
    RIGHT OUTER JOIN (SELECT 
        YEAR, COUNTRY, COUNT(*) AS LOSSING_TEAM
    FROM
        stats AS yy
    INNER JOIN teams AS tt ON yy.LOSSING_TEAM = tt.ID
    GROUP BY tt.COUNTRY, yy.YEAR ) AS t2 ON t1.COUNTRY = t2.COUNTRY) AS x1
GROUP BY YEAR;