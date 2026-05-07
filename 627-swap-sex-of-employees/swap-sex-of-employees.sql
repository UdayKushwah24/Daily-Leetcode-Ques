# Write your MySQL query statement below


-- select id, name , 
-- case 
--     when sex = 'm' then 'f'
--     when sex = 'f' then 'm'
-- end as sex , salary from Salary;
Update Salary
set sex =  
case 
    when sex = 'm' then 'f'
    when sex = 'f' then 'm'
end ;