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
