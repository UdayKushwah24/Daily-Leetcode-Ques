# Write your MySQL query statement below
-- select  id, rank() over(partition by email order by id desc ) as rnk from Person;

-- SELECT id, 
--        RANK() OVER (PARTITION BY email ORDER BY id DESC) AS rnk 
-- FROM Person;

-- DELETE p1 FROM Person p1
-- JOIN Person p2 
-- ON p1.email = p2.email AND p1.id > p2.id;

delete p1 from Person p1 
join Person p2 on p1.email = p2.email and p1.id > p2.id;