Run class:
org.teasoft.exam.bee.test.TestCache.java
org.teasoft.exam.bee.test.TestNormal.java

First Reference Version Result:
bee-exam(v1.7.2)-cache-2020-03-04 10.53.46.681.txt
bee-exam(v1.7.2)-normal-2020-03-04 10.52.58.70.txt

test SuidRich add two new methods:
public <T> int updateBy(T entity,String whereFieldList,Condition condition);
public <T> int update(T entity,String updateFieldList,Condition condition);
bee-exam(v1.7.2)-normal-2020-04-22 16.10.41.797.txt
bee-exam(v1.7.2)-cache-2020-04-22 16.16.31.829.txt

test use nocache:
bee-exam(v1.7.2)-cache-2020-04-22 16.33.07.919.txt

test use setAdd,setMultiply in Condition:
bee-exam(v1.7.2)-normal-2020-04-22 22.00.11.844.txt

PearFlowerIdTest,SerialUniqueIdTest
test for global unique id number in distributed environment.

add test case: UpdateSetExam:setAdd,setMuliple
bee-exam(v1.7.2)-normal-2020-06-13 13.14.34.106-to-v1.8-bench.txt

Support show type of data in sql and show ExecutableSql
bee-exam(v1.7.2)-normal-2020-07-05 23.56.30.843.txt

Gen Serial Unique Id for all Table's Long Id field as primary key.
bee-exam(v1.7.3)-normal-2020-07-25 22.14.04.712.txt

Condition selectField,set method;insert null value process
bee-exam(v1.7.3)-normal-2020-07-25 23.05.05.465.txt

use 'for update' lock some select record(s). 
bee-exam(v1.7.3)-normal-2020-07-26 22.53.23.807.txt

The same database sub table support, dynamic table name mapping support.  
Entity and any table name mapping support.
field is not null
bee-exam(v1.7.3)-normal-2020-08-02 16.43.40.905.txt

multi-DS:only more database
bee-exam(v1.8)-cache-2020-08-22 22.14.10.158.txt
bee-exam(v1.8)-normal-2020-08-22 22.14.00.204.txt

add H2,SQLite Support:
bee-exam(v1.8.15)-normal(H2)-2020-09-20 21.37.23.126.txt
bee-exam(v1.8.15)-normal(MySQL)-2020-09-20 18.28.31.764.txt
bee-exam(v1.8.15)-normal(SQLite)-2020-09-20 19.43.53.751.txt

Support lower and upper case option for SQL KeyWord:
bee-exam(v1.8.99)-normal(MySQL)-2020-10-17 21.41.40.37.txt
bee-exam(v1.8.99)-normal(MySQL)-2020-10-17 21.42.02.730-UPPER.txt

bee-exam(v1.8.99)-normal(MySQL)-2020-10-24 21.40.20.605.txt

V1.9
bee-exam(v1.9)-normal(MySQL)-2020-12-29 14.59.21.09.txt
bee-exam(v1.9)-normal(MySQL)-2021-01-17 23.52.19.330.txt
bee-exam(v1.9)-normal(MySQL)-2021-02-07 11.56.33.739.txt
bee-exam(v1.9)-normal(MySQL)-2021-02-14 10.11.34.561.txt
bee-exam(v1.9)-normal(MySQL)-2021-03-11 08.47.40.114.txt
bee-exam(v1.9)-cache-2021-03-11 08.52.07.423.txt

add coverage info.2021-03-18 (yyyy-MM-dd)

bee-exam(v1.9)-normal(Oracle)-2021-03-20 20.01.44.213.txt
bee-exam(v1.9)-cache(Oracle)-2021-03-20 20.02.02.758.txt
bee-exam(v1.9)-normal(MySQL)-2021-03-20 23.10.06.324.txt
bee-exam(v1.9)-cache(MySQL)-2021-03-20 23.10.16.346.txt
bee-exam(v1.9)-normal(SQLite)-2021-03-24 22.10.08.975.txt

test V1.9 with well-known and major database 
bee-exam(v1.9)2021-03-25 13.10.37.514-normal(Microsoft SQL Server).txt
bee-exam(v1.9)2021-03-25 13.14.57.616-normal(SQLite).txt
bee-exam(v1.9)2021-03-25 13.17.51.312-normal(MySQL).txt
bee-exam(v1.9)2021-03-25 13.20.15.761-normal(Oracle).txt
bee-exam(v1.9)2021-03-25 13.23.08.180-normal(H2).txt
bee-exam(v1.9)2021-03-25 13.25.51.23-normal(PostgreSQL).txt

bee-exam(v1.9)2021-04-01 21.32.08.537-normal(MySQL).txt
bee-exam(v1.9)2021-04-01 21.32.24.79-normal(Oracle).txt
bee-exam(v1.9)2021-04-01 21.32.47.917-normal(SQLite).txt
bee-exam(v1.9)2021-04-01 21.33.04.663-normal(H2).txt
bee-exam(v1.9)2021-04-01 21.33.08.408-normal(PostgreSQL).txt
bee-exam(v1.9)2021-04-01 21.33.20.953-normal(Microsoft SQL Server).txt

bee-exam(v1.9)2021-04-03 21.55.13.02-normal(MySQL).txt
bee-exam(v1.9)2021-04-03 21.55.27.357-normal(Oracle).txt
bee-exam(v1.9)2021-04-03 21.55.51.369-normal(SQLite).txt
bee-exam(v1.9)2021-04-03 21.56.05.780-normal(H2).txt
bee-exam(v1.9)2021-04-03 21.56.10.191-normal(PostgreSQL).txt
bee-exam(v1.9)2021-04-03 21.56.22.701-normal(Microsoft SQL Server).txt
bee-exam(v1.9)2021-04-03 21.56.30.119-cache(MySQL).txt

bee-exam(v1.9)2021-05-02 02.53.30.778-normal(MySQL).txt
bee-exam(v1.9)2021-05-02 02.53.47.666-normal(Oracle).txt
bee-exam(v1.9)2021-05-02 02.54.08.829-normal(SQLite).txt
bee-exam(v1.9)2021-05-02 02.54.26.717-normal(H2).txt
bee-exam(v1.9)2021-05-02 02.54.34.977-normal(PostgreSQL).txt
bee-exam(v1.9)2021-05-02 02.54.55.328-normal(Microsoft SQL Server).txt
bee-exam(v1.9)2021-05-02 02.55.16.45-cache(MySQL).txt

test V1.9.8 with well-known and major database  
bee-exam(v1.9.8)2021-10-22 13.28.59.122-normal(MySQL).txt
bee-exam(v1.9.8)2021-10-22 13.29.18.02-normal(Oracle).txt
bee-exam(v1.9.8)2021-10-22 13.29.41.620-normal(SQLite).txt
bee-exam(v1.9.8)2021-10-22 13.30.00.709-normal(H2).txt
bee-exam(v1.9.8)2021-10-22 13.30.07.72-normal(PostgreSQL).txt
bee-exam(v1.9.8)2021-10-22 13.30.26.941-normal(Microsoft SQL Server).txt
bee-exam(v1.9.8)2021-10-22 13.30.36.536-normal(MySQL).txt
bee-exam(v1.9.8)2021-10-22 13.30.58.799-cache(MySQL).txt

//V2.1  Sharding, MongoDB ORM
bee-exam(v2.1)2023-06-13 23.57.30.177-cache(MySQL).txt
bee-exam(v2.1)2023-06-13 23.56.56.71-normal(MySQL).txt
bee-exam(v2.1)2023-06-13 23.56.31.297-normal(MySQL).txt
bee-exam(v2.1)2023-06-13 23.56.00.371-normal(PostgreSQL).txt
bee-exam(v2.1)2023-06-13 23.55.50.59-normal(H2).txt
bee-exam(v2.1)2023-06-13 23.55.02.288-normal(Oracle).txt
bee-exam(v2.1)2023-06-13 23.54.51.219-normal(Microsoft SQL Server).txt
bee-exam(v2.1)2023-06-13 23.54.19.39-normal(SQLite).txt
bee-exam(v2.1)2023-06-13 23.53.26.232-normal(MongoDB).txt
bee-exam(v2.1)2023-06-13 23.53.23.176-Sharding(MySQL).txt