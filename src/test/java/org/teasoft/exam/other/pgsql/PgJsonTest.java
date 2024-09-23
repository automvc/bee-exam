/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.other.pgsql;

import org.junit.Test;
import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.exam.MySqlOneConfig;
import org.teasoft.exam.bee.osql.special.pgsql.PgSuidExam;
import org.teasoft.exam.bee.osql.special.pgsql.PgSuidExam2;
import org.teasoft.honey.osql.core.HoneyConfig;

/**
 * just test for PostgreSQL
 * @author Kingstar
 * @since  2.4.0
 */
public class PgJsonTest {
	@Test
	public void test() {
		
		String DbName=HoneyConfig.getHoneyConfig().getDbName();
		if (! DatabaseConst.PostgreSQL.equalsIgnoreCase(DbName)) return ;
		
		try {
			PgSuidExam.test();
			PgSuidExam2.test();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MySqlOneConfig.reset(); //预防测试无序,跳到其它类
		}
		
	}
}
