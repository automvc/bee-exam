/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.teasoft.honey.spi.SpiInstanceRegister;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public class LessTest {
	
	public static void main(String[] args) {
		test();
	}
	
//	@Test
	public static void test() {
		try {
			Object instance=SpiInstanceRegister.getInstance(String.class);  //test not exist
			if(instance==null) System.out.println("----SpiInstanceRegister.getInstance is right");
			
			SpiInstanceRegister.register(Boolean.class, null);
			Object instance2=SpiInstanceRegister.getInstance(Boolean.class);
			System.out.println(instance2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
