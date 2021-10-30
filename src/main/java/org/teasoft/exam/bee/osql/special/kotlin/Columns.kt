package org.teasoft.exam.bee.osql.special.kotlin

import java.io.Serializable;

data class Columns(
	var tableId: Int? = null,
	var columnId: Int? = null,
	var columnName: String? = null
) : Serializable

