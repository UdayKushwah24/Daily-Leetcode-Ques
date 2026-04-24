# Write your MySQL query statement below
-- select score, Dense_rank () Over() as "rank" from 
-- Scores order by score asc; 

-- SELECT score,
--        DENSE_RANK() OVER (ORDER BY score ) AS `rank`
-- FROM Scores;


SELECT 
    score,
    DENSE_RANK() OVER (ORDER BY score DESC) AS `rank`
FROM Scores;