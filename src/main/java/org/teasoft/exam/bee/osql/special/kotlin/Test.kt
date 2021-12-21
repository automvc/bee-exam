/*

package org.teasoft.exam.bee.osql.special.kotlin

import org.teasoft.exam.bee.osql.special.kotlin.Columns
import org.teasoft.honey.osql.core.BeeFactory
import org.teasoft.exam.bee.osql.special.kotlin.Tables

fun main(){
	
val suid = BeeFactory.getHoneyFactory().suidRich
	println(" ------ query tables-------")
println(suid.select(Tables(tableId=1)))
	println("------query columns -------")
println(suid.select(Columns(tableId = 1)))
val moreTable = BeeFactory.getHoneyFactory().moreTable
println(moreTable.select(Tables(tableId = 1)))
}


*/

// log:
//------ query tables-------
//[Bee] LoggerFactory Use the Logger is : org.teasoft.honey.logging.SystemLogger
//[INFO] [Bee] ========= get the dbName from the Connection is :MySQL
//[INFO] [Bee] select SQL: select table_id,table_name from tables where table_id=?   [values]: 1
//[INFO] [Bee] select SQL:  ( ExecutableSql )
//select table_id,table_name from tables where table_id=1
//[INFO] [Bee]  | <--  select rows: 1
//[Tables(tableId=1, tableName=t1, columns=null)]
//------query columns -------
//[INFO] [Bee] select SQL: select table_id,column_id,column_name from columns where table_id=?   [values]: 1
//[INFO] [Bee] select SQL:  ( ExecutableSql )
//select table_id,column_id,column_name from columns where table_id=1
//[INFO] [Bee]  | <--  select rows: 2
//[Columns(tableId=1, columnId=1, columnName=c1), Columns(tableId=1, columnId=2, columnName=C2)]
//[INFO] [Bee] select SQL: select tables.table_id,tables.table_name,columns.table_id,columns.column_id,columns.column_name from tables,columns where tables.table_id=columns.table_id and tables.table_id=?   [values]: 1
//[INFO] [Bee] select SQL:  ( ExecutableSql )
//select tables.table_id,tables.table_name,columns.table_id,columns.column_id,columns.column_name from tables,columns where tables.table_id=columns.table_id and tables.table_id=1
//[INFO] [Bee]  | <--  select rows: 2
//[Tables(tableId=1, tableName=t1, columns=Columns(tableId=1, columnId=1, columnName=c1)), Tables(tableId=1, tableName=t1, columns=Columns(tableId=1, columnId=2, columnName=C2))]
