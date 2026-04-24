# Write your MySQL query statement below

-- select c.name as Customers from Customers c
--  join Orders o on c.id = o.customerId ;

select name as Customers from Customers where id not in (
select customerId from Orders);

-- select c.name as Customers from Customers c
-- join Orders o on c.id = o.id ;