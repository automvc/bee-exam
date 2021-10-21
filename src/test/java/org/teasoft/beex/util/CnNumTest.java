/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.beex.util;

import static org.teasoft.beex.util.CnNum.*;

import org.junit.Test;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class CnNumTest {
	
	@Test
	public void test() {
		System.out.println(tran(1100));
		System.out.println(tran(1001));
		System.out.println(tran(20030));
		System.out.println(tran(500005));
		System.out.println(tran(500305));
		
		
		System.out.println(tranToUpper(1100));
		System.out.println(tranToUpper(1001));
		System.out.println(tranToUpper(20030));
		System.out.println(tranToUpper(500005));
		System.out.println(tranToUpper(500305));
		
		System.out.println("======================");
		
		System.out.println(tranToUpper(500305D));
		System.out.println(tranToUpper(500305.23D));
		System.out.println(tranToUpper(500305.123D));
		
		System.out.println(tran(500305.23D));
		System.out.println(tran(5003050.234D));
		
		System.out.println("======================");
		System.out.println(tran(1004));
		System.out.println(tran(2046));
		System.out.println(tran(2932));
		System.out.println(tran(9040));
		System.out.println(tran(1001));
		System.out.println(tran(327));
		System.out.println(tran(8052));
		System.out.println(tran(1503));
		System.out.println(tran(1100));
		System.out.println(tran(2500));
		System.out.println(tran(970));
		System.out.println(tran(1900));
	}

}
