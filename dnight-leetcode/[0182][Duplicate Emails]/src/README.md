# Q:
Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+

# A:
SELECT DISTINCT P2.Email FROM Person P2,
(SELECT COUNT(P1.EMAIL) Num,P1.EMAIL FROM Person P1 GROUP BY P1.Email HAVING Num > 1 ) TMP
WHERE P2.EMAIL = TMP.EMAIL



select Email 
from Person 
group by Email 
having count(Email) > 1;


聚合函数分类：
    sum(求和)
    max(求最大值)
    min(求最小值)
    count(统计条数)
    avg(求平均值)

当然了，配合使用的还有分组group by ,以及对聚合函数结果做筛选条件的having子句。

having  
作用：having子句的作用就是为每一个组指定条件，像where指定条件一样，也就是说，可以根据你指定的条件来选择行。
例子： select sids from  (select sid as sids from group where scgrade<60) group by sids having                                              count(sids)>=2;   查询超过两科没及格的学生id
讲解：having必须处在group by子句之后  。
补允：where和having的区别。
    where：where 子句在聚合前先筛选记录．也就是说作用在group by 子句和having子句前．
    having：having子句在聚合后对组记录进行筛选