/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.mongodb;

import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.exam.comm.TestPrepare;

/**
 * @author Kingstar
 * @since  2.1
 */
public class Start {
	
	private static boolean isStart=false;
	
	public static void reMark(){
		if(!Start.isStart) {
			isStart=true;
			TestPrepare.init("normal("+DatabaseConst.MongoDB+")");
		}
	}

}
