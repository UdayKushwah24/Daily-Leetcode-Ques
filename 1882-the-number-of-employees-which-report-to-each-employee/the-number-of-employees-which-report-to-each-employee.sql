# Write your MySQL query statement below

-- with temp as (select * from Employees where reports_to is not null)
-- select e.reports_to as employee_id , e.name, count(t.reports_to) as "reports_count"
-- , avg(t.age) as average_age from Employees as e
-- inner join temp t  on t.reports_id = e.employee_id
-- group by t.ereports_to
-- order by employee_id;


WITH temp AS (
    SELECT * 
    FROM Employees 
    WHERE reports_to IS NOT NULL
)
SELECT 
    -- e.employee_id, 
    t.reports_to as employee_id,
    e.name, 
    COUNT(t.employee_id) AS reports_count, 
    ROUND(AVG(t.age)) AS average_age
FROM Employees AS e
INNER JOIN temp AS t 
    ON e.employee_id = t.reports_to
GROUP BY t.reports_to
ORDER BY employee_id;
