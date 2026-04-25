CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
        select max(salary) as "getNthHighestSalary" from (
            select * , dense_rank() over(order by salary desc) as rnk from Employee
        ) tmp
        where N = rnk


    --      SELECT MAX(salary) as getNthHighestSalary
    --   FROM(
    --    SELECT *,
    --     DENSE_RANK() OVER(ORDER BY salary DESC) as r
    --    FROM Employee
    --   ) as temp
    --   WHERE r=N
  );
END