-- 181. 超过经理收入的员工
-- 编写一个SQL查询来查找收入比经理高的员工。

-- Create table If Not Exists Employee (id int, name varchar(255), salary int, managerId int)

-- Truncate table Employee
-- insert into Employee (id, name, salary, managerId) values ('1', 'Joe', '70000', '3')
-- insert into Employee (id, name, salary, managerId) values ('2', 'Henry', '80000', '4')
-- insert into Employee (id, name, salary, managerId) values ('3', 'Sam', '60000', 'None')
-- insert into Employee (id, name, salary, managerId) values ('4', 'Max', '90000', 'None')

select
   t0.name as Employee
 from (
   select
     id, name, salary, managerId
   from Employee
 ) t0
 join (
   select
     id, name, salary
   from Employee
 ) t1
   on t0.managerId = t1.id
 where t0.salary > t1.salary
 ;
