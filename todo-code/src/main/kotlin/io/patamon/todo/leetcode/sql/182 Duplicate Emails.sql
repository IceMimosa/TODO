-- 182. 查找重复的电子邮箱
-- 编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
-- 说明：所有电子邮箱都是小写字母。

-- Create table If Not Exists Person (id int, email varchar(255))

-- Truncate table Person
-- insert into Person (id, email) values ('1', 'a@b.com')
-- insert into Person (id, email) values ('2', 'c@d.com')
-- insert into Person (id, email) values ('3', 'a@b.com')

select
  Email
from (
  select
    Email,
    count(1) cnt
  from Person
  group by Email
) t
where t.cnt > 1

;
