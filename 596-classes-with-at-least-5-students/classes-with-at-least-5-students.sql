# Write your MySQL query statement below
select class from (
    select count(student) as cnt, class from Courses
    group by class
) t where cnt >= 5;