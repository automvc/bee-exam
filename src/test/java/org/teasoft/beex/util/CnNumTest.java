/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.beex.util;

import static org.teasoft.beex.util.CnNum.tran;
import static org.teasoft.beex.util.CnNum.tranToUpper;

import org.junit.Test;
import org.teasoft.honey.logging.Logger;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class CnNumTest {
	
	@Test
	public void test() {
		Logger.info(tran(1100));
		Logger.info(tran(1001));
		Logger.info(tran(20030));
		Logger.info(tran(500005));
		Logger.info(tran(500305));
		
		
		Logger.info(tranToUpper(1100));
		Logger.info(tranToUpper(1001));
		Logger.info(tranToUpper(20030));
		Logger.info(tranToUpper(500005));
		Logger.info(tranToUpper(500305));
		
		Logger.info("======================");
		
		Logger.info(tranToUpper(500305D));
		Logger.info(tranToUpper(500305.23D));
		Logger.info(tranToUpper(500305.123D));
		
		Logger.info(tran(500305.23D));
		Logger.info(tran(5003050.234D));
		
		Logger.info("======================");
		Logger.info(tran(1004));
		Logger.info(tran(2046));
		Logger.info(tran(2932));
		Logger.info(tran(9040));
		Logger.info(tran(1001));
		Logger.info(tran(327));
		Logger.info(tran(8052));
		Logger.info(tran(1503));
		Logger.info(tran(1100));
		Logger.info(tran(2500));
		Logger.info(tran(970));
		Logger.info(tran(1900));
	}

}
