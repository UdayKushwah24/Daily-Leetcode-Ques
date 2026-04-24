# Write your MySQL query statement below
select Email from 
(select count(id) as cnt, email as Email from Person group by email
) as temp
where cnt >= 2;
-- select count(id), email as Email from Person
-- group by email;