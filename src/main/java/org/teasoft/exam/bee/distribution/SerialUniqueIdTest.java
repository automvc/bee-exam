/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.distribution;

import org.teasoft.bee.distribution.GenId;
import org.teasoft.honey.distribution.SerialUniqueId;

/**
 * @author Kingstar
 * @since  1.7.3
 */
public class SerialUniqueIdTest {
	
	public static void main(String[] args) {
		final int SIZE=1000;
		GenId genId=new SerialUniqueId();
		GenIdThread thread[]=new GenIdThread[SIZE];
		for (int i = 0; i < SIZE; i++) {
			thread[i]=new GenIdThread(genId,i+"","one");
			thread[i].start();
		}
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("-------------------------");
		System.out.println(GenIdThread.idSet.size());
		
		System.out.println(GenIdThread.idSetDup.size());
		System.out.println(GenIdThread.idSetDup);
	}

}
