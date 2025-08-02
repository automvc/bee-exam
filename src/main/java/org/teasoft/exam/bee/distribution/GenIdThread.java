/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
*/

package org.teasoft.exam.bee.distribution;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import org.teasoft.bee.distribution.GenId;
import org.teasoft.honey.logging.Logger;

/**
 * @author Kingstar
 * @since  1.8
 */
public class GenIdThread extends Thread{
	
//	static Set<Long> idSet=new HashSet<>();
	static Set<Long> idSet=new CopyOnWriteArraySet<>();
	private final static int SIZE=12000;
//	private final static int SIZE=21000;  //if(i==0){
	static long num[]=new long[SIZE];
	static List<Long> idDupList=new CopyOnWriteArrayList<>();
	
	private GenId genId;
	private String type;
	
	@Override
	public void run(){
		for (int i = 0; i < 3; i++) {
//			if("one".equals(type)){
			if(i!=0){
//			if(i==0){
				long id=genId.get();
				idSet.add(id);
				setNum(id);
				Logger.info(Thread.currentThread().getName()+"  : "+id);
			}else{
				long a[]=genId.getRangeId(10);
				setNum(a);
				Logger.info(Thread.currentThread().getName()+"  : "+a[0]+" , "+a[1]);
			}
		}
	}
	
	public GenIdThread(GenId genId,String threadName,String type){
		this.genId=genId;
		this.setName(threadName);
		this.type=type;
	}
	
	public void setNum(long n){
		int index=(int)(n-1);
		if(num[index]==1) {
			Logger.info(n+"  ---------------------------已经存在了.");
			idDupList.add(n);
		}else{
			num[index]=1;
		}
	}
	
	public void setNum(long array[]){
		for (long i =array[0]; i <=array[1]; i++) {
			setNum(i);
		}
	}
}
