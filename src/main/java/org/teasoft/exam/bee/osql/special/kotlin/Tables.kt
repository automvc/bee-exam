package org.teasoft.exam.bee.osql.special.kotlin

import org.teasoft.bee.osql.annotation.JoinTable;
import org.teasoft.bee.osql.annotation.JoinType;
import java.io.Serializable;

data class Tables(
var tableId: Int ?= null,
var tableName : String ?= null,
@JoinTable (mainField = "table_id",
subField = "table_id",
joinType = JoinType.JOIN
,subClass = "Columns"
)
//var columns:List<Columns> ?= null,
var columns:Columns ?= null,
): Serializable

