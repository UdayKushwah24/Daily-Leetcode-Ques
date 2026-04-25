# Write your MySQL query statement below
select d.name as "Department",
        e.name as "Employee",
        e.salary as "Salary"
    from (
        
        select *, Dense_rank() over(partition by departmentId order by salary desc) as rnk from Employee
    ) e
    join Department d on d.id = e.departmentId
    where rnk <= 3;
 
-- select *, Dense_rank() over(partition by departmentId order by salary desc) as rnk from Employee