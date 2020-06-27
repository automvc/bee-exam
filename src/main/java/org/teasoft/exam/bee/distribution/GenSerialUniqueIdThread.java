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
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.7.3
 */
public class GenSerialUniqueIdThread extends Thread{
	
//	static Set<Long> idSet=new HashSet<>();
	static Set<Long> idSet=new CopyOnWriteArraySet<>();
	private final static int SIZE=12000;
//	private final static int SIZE=21000;  //if(i==0){
//	static long num[]=new long[SIZE];
	static List<Long> idDupList=new CopyOnWriteArrayList<>();
	
	private GenId genId;
//	private String type;
	
	@Override
	public void run(){
		for (int i = 0; i < 3; i++) {
//			if("one".equals(type)){
			if(i!=0){
//			if(i==0){
				long id=genId.get();
				setNum(id);
				Logger.info(Thread.currentThread().getName()+"run:"+i+"  : "+id);
			}else{
				long a[]=genId.getRangeId(10);
				setNum(a);
				Logger.info(Thread.currentThread().getName()+"run:"+i+"  : "+a[0]+" , "+a[1]);
			}
		}
	}
	
	public GenSerialUniqueIdThread(GenId genId,String threadName,String type){
		this.genId=genId;
		this.setName(threadName);
//		this.type=type;
	}
	
	public void setNum(long n){
		
		boolean isOk=idSet.add(n);
		if(!isOk) {
			Logger.info(n+"  ---------------------------已经存在了.");
			idDupList.add(n);
		}
	}
	
	public void setNum(long array[]){
		for (long i =array[0]; i <=array[1]; i++) {
			setNum(i);
		}
	}
}
