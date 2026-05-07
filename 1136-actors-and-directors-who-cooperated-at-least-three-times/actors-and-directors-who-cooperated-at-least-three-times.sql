# Write your MySQL query statement below


with temp as (
select actor_id, count(actor_id) as a, director_id , count(director_id) as d from ActorDirector

group by actor_id, director_id
)

select actor_id, director_id from temp
where a >= 3 or d >= 3;