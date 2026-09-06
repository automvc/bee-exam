/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.moretable3;

import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.exam.comm.TestPrepare;

/**
 * @author Kingstar
 * @since  2.1
 */
public class StartMoreTable3 {
	
	private static boolean isStart=false;
	
	public static void reMark(){
		if(!StartMoreTable3.isStart) {
			isStart=true;
			TestPrepare.init("MoreTable3("+DatabaseConst.MYSQL+")");
		}
	}

}
