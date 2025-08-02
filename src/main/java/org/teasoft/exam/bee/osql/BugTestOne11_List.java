/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.JdkSerializer;

/**
 * @author Kingstar
 * @since  1.8
 */

//有List包裹也没用, 实体不声明序列化也是不成的.
public class BugTestOne11_List {
	public static void main(String[] args) {
		//		TestPrepare.init();
		test();
	}

	public static void test() {

		try {

			Suid suid = BeeFactory.getHoneyFactory().getSuid();
//			SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

//			-------------------v.1.11-------start----------  
			
			
			Object obj[]=new Object[10];
			
			Orders a0 = new Orders();
			a0.setName("a0");
			List<Orders> list0 = new ArrayList<>();
			list0.add(a0);
			
			Orders a1 = new Orders();
			a1.setName("a1");
			List<Orders> list1 = new ArrayList<>();
			list1.add(a1);
			
//			obj[0]=a0;
//			obj[1]=a1;
			
			obj[0]=list0;
			obj[1]=list1;
			
			
			
//			Orders a000=(Orders)obj[0];
			Object newArray[]=Arrays.copyOfRange(obj, 0, 1);
			Orders a000=(Orders)((List)newArray[0]).get(0);
			
			a000.setName("a0-----");  //从缓存数组取出后,修改
			System.err.println(a000.getName());
			
			JdkSerializer jdks=new JdkSerializer();
			
			
			Orders a00000=(Orders)((List)jdks.unserialize(jdks.serialize(obj[0]))).get(0);
			
			
			
			System.err.println(a00000.getName());
			
			
			if(a00000==a000) {
				System.out.println("还是同一个对象!!!");
			}else {
				System.err.println("不是同一对象!!!");
				
			}
			
			
			Object newArray2[]=Arrays.copyOfRange(obj, 0, 1);
			Orders a0002=(Orders)((List)newArray2[0]).get(0);
			if(a0002==a000) System.out.println("还是同一个对象2222222222!!!");
			
			Orders orders=new Orders();
			orders.setId(121L);
			List<Orders> list2=suid.select(orders);
			
			long t1=System.currentTimeMillis();
			for (int i = 0; i < 10000; i++) {
				jdks.unserialize(jdks.serialize(list2));
			}
			
			long t2=System.currentTimeMillis();
			
			System.out.println((t2-t1));  //553,559
			
			
			
			
			
			String s1="string instance";
			List listObj=new ArrayList();
			listObj.add("ss");
			
			ArrayList arrayList=new ArrayList();
			arrayList.add("ee");
			
			
			List<Integer> listObjT=new ArrayList<>();
			listObjT.add(11);
			
//			List<?> listObj2=new ArrayList<String>();
//			listObj2.add("ss");
			
			
  			if(s1 instanceof String) {
  				System.out.println("s1 是String实例");
  			}
  			
			if(listObj instanceof List) {
				System.out.println("listObj 是List实例");
			}
			
			if(arrayList instanceof List) {
				System.out.println("arrayList 是List实例");
			}
			
			if(listObjT instanceof List) {
				System.out.println("listObjT 是List实例");
			}
			
		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In BugTest (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In BugTest (Exception):"+e.getMessage());
			e.printStackTrace();
		}

	}
}
