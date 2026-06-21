# Write your MySQL query statement below
select user_id, count(user_id) as prompt_count, round(avg(tokens), 2) as avg_tokens
from prompts
group by user_id
having prompt_count >= 3  AND MAX(tokens) > AVG(tokens)
order by avg_tokens desc, user_id asc;