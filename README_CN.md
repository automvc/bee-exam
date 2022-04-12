Bee-exam
=========
**Bee-exam** is the test and example of ORM framework Bee.   

**Bee** see:  
https://github.com/automvc/bee  
**Honey** see:  
https://github.com/automvc/honey  

**Quick Start**	

1.Config the Database info in bee.properties.  
2.Gen the Javabean for your Database, use:  
org.teasoft.exam.bee.osql.autogen.GenBeanExam.  
3.run the test/example in TestNormal(org.teasoft.exam.bee.test).  
if need reset the tables ,use statement:  ClearAndInitTestTable.main(null);  
other:  
TestCache test Bee Cache function.  
Test Coverage: select src/test/java-->(right click)Coverage As-->JUnit Test  

MainDbTest是各主流DB同时测试(各主要DB都要启动,redis).
TestNormal通用测试,主流DB主要的测试内容.
异常覆盖测试在ExceptionTest和ExceptionTest2. 不测试覆盖率时,在ExceptionTest2注释即可.
Test Coverage: select src/test/java-->(right click)Coverage As-->JUnit Test  
在TestNormal里有ClearAndInitTestTable.main(null)用来清空和重新初始化表和数据.
BeeTest
HoneyConfigReset.test(),放在最后.



