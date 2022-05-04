-- 196. 删除重复的电子邮箱
-- 编写一个 SQL 删除语句来 删除 所有重复的电子邮件，只保留一个id最小的唯一电子邮件。

-- Create table If Not Exists Person (Id int, Email varchar(255))

-- Truncate table Person
-- insert into Person (id, email) values ('1', 'john@example.com')
-- insert into Person (id, email) values ('2', 'bob@example.com')
-- insert into Person (id, email) values ('3', 'john@example.com')

delete from Person where id in (
select
  id
from (
  select
    id,
    email,
    row_number() over(partition by email order by id) rn
  from Person
) t
where t.rn > 1
)
;