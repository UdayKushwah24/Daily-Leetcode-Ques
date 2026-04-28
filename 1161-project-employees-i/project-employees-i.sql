# Write your MySQL query statement below

 
-- with temp as (select project_id, sum(employee_id) as ts from Project
--     group by project_id)  
-- select t.project_id, round(t.ts/e.experience_years, 2) as average_years  from temp t
-- join Employee e on t.project_id = e.employee_id;

SELECT p.project_id, 
       ROUND(AVG(e.experience_years), 2) AS average_years
FROM Project p
JOIN Employee e 
ON p.employee_id = e.employee_id
GROUP BY p.project_id;