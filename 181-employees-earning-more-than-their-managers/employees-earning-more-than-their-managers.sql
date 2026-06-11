# Write your MySQL query statement below

-- select e1.name as Employee
-- from employee e1 join employee e2
-- on e1.managerid=e2.id and e1.salary>e2.salary;


with temp as (
    select * from Employee
)
select  temp.name as "Employee" from temp
inner join  Employee e on temp.managerId = e.id
where temp.salary > e.salary; 