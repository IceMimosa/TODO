-- 197. 上升的温度
-- 编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 id 。

-- Create table If Not Exists Weather (id int, recordDate date, temperature int)
-- Truncate table Weather
-- insert into Weather (id, recordDate, temperature) values ('1', '2015-01-01', '10')
-- insert into Weather (id, recordDate, temperature) values ('2', '2015-01-02', '25')
-- insert into Weather (id, recordDate, temperature) values ('3', '2015-01-03', '20')
-- insert into Weather (id, recordDate, temperature) values ('4', '2015-01-04', '30')

select
  t0.id
from (
  select
    id, recordDate, Temperature
  from Weather
) t0
left join (
  select
    id, addDate(recordDate, 1) diff_date, Temperature
  from Weather
) t1
  on t0.recordDate = t1.diff_date
where t0.Temperature > t1.Temperature

;
