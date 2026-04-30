# Write your MySQL query statement below

-- select cnt as customer_number from (
--     select count(customer_number) as cnt from Orders
-- ) t
-- where cnt > 1;

-- select customer_number, count(order_number) as orders from Orders
-- group by customer_number
-- order by orders desc
-- limit 1;


SELECT customer_number
FROM Orders
GROUP BY customer_number
ORDER BY COUNT(order_number) DESC
LIMIT 1;