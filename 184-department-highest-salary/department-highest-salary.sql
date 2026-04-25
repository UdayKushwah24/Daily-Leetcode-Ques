# Write your MySQL query statement below
-- select d.name as "Department", e.name as "Employee", over(parition by d.name max(e.salary)) as "Salary" from
-- Employee e join Department d on e.id = d.id;

-- select d.name as "Department", e.name as "Employee", max(e.salary) over( partition by d.name) as "Salary" from
-- Employee e join Department d on e.id = d.id;

SELECT 
    d.name AS "Department",
    e.name AS "Employee",
    e.salary AS "Salary"
FROM (
    SELECT *,
           RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) AS rnk
    FROM Employee
) e
JOIN Department d 
ON e.departmentId = d.id
WHERE e.rnk = 1;


 