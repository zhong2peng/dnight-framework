# Q:
Write a SQL query to delete all duplicate email entries in a table named Person,
keeping only unique emails based on its smallest Id.

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
Id is the primary key column for this table.
For example, after running your query, the above Person table should have the following rows:

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+
Note:

Your output is the whole Person table after executing your sql. Use delete statement.

# A:
DELETE 
FROM
	Person 
WHERE
	Id NOT IN ( SELECT Id FROM ( SELECT min( Id ) AS Id FROM Person GROUP BY Email ) p );
	

why u select ID twice ?
To prevent You can't specify target table 'Person' for update in FROM clause error.
In MySQL, you can't modify the same table which you use in the SELECT part.
https://stackoverflow.com/questions/45494/mysql-error-1093-cant-specify-target-table-for-update-in-from-clause