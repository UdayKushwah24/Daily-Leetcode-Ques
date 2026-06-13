# Write your MySQL query statement below
-- select r.contest_id, round(count(r.user_id)/count(u.user_id), 2)
-- select r.contest_id, round(count(r.user_id)*100 / (select count(*) from Users) , 2) as percentage
-- from Register r
-- join Users u on r.user_id = u.user_id
-- group by contest_id
-- order by percentage desc, contest_id asc;


select contest_id, round(count(user_id)*100 / (select count(*) from Users) , 2) as percentage
from Register 
group by contest_id
order by percentage desc, contest_id asc;