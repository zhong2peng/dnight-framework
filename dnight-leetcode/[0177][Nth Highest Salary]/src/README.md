# Q:
Write a SQL query to get the nth highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the nth highest salary where n = 2 is 200. If there is no nth highest salary, then the query should return null.

+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+

# A:
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT MAX(Salary) FROM Employee WHERE Salary <= (SELECT Salary FROM Employee ORDER BY Salary DESC LIMIT N,1)
  );
END

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      select Salary from Employee group by Salary order by Salary desc limit N,1
  );
END


例1，假设数据库表student存在13条数据。
 

代码示例:
语句1：select * from student limit 9,4
语句2：slect * from student limit 4 offset 9
// 语句1和2均返回表student的第10、11、12、13行  
//语句2中的4表示返回4行，9表示从表的第十行开始
例2，通过limit和offset 或只通过limit可以实现分页功能。
假设 numberperpage 表示每页要显示的条数，pagenumber表示页码，那么 返回第pagenumber页，每页条数为numberperpage的sql语句：
 

代码示例:
语句3：select * from studnet limit (pagenumber-1)*numberperpage,numberperpage
语句4：select * from student limit numberperpage offset (pagenumber-1)*numberperpage