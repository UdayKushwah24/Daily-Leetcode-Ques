# Write your MySQL query statement below


-- select s.name from SalesPerson s
-- inner join Orders o using(sales_id)
-- inner join Company c on c.com_id = s.sales_id
-- where c.name != "RED";


-- select com_id from Company where name != "RED"

# Write your MySQL query statement below

SELECT name #salespeople whose sales_id is not in that list
FROM salesperson s
where s.sales_id
NOT IN(
    SELECT o.sales_id    #this part finds all salesperson who sell to comapany Red
    FROM company c
    INNER JOIN orders o
    ON o.com_id=c.com_id
        WHERE c.name='Red'
)