///*
// * Copyright 2016-2022 the original author.All rights reserved.
// * Kingstar(honeysoft@126.com)
// * The license,see the LICENSE file.
// */
//
//package org.teasoft.exam.bee.field;
//
//import java.util.List;
//
//import org.teasoft.beex.osql.ObjSQLRichExt;
//import org.teasoft.beex.osql.SuidRichExt;
//import org.teasoft.exam.bee.osql.entity.Orders;
//import org.teasoft.exam.comm.Printer;
//
///**
// * @author Kingstar
// * @since  2.0
// */
//@SuppressWarnings("unchecked")
//public class AutoFieldTest {
//	
//	public static void main(String[] args) {
//		SuidRichExt ext=new ObjSQLRichExt();
//		
//		List<Orders> list=ext.select(new Orders(), Orders::getUserid,Orders::getName);
//		
//		Printer.printList(list);
//	}
//
//}
