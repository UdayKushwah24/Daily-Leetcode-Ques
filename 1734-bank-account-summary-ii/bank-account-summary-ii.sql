# Write your MySQL query statement below

-- select u.name,sum(t.amount) as balance
-- from Users u
-- join Transactions t on u.account = t.account
-- group by t.account;
-- where balance > 10000


select u.name,sum(t.amount) as balance
from Users u
join Transactions t on u.account = t.account
group by t.account
having balance > 10000;



-- with temp as (
--     select u.name,sum(t.amount) as balance
--     from Users u
--     join Transactions t on u.account = t.account
--     group by t.account
-- ) 
-- select * from temp
-- where balance > 10000;