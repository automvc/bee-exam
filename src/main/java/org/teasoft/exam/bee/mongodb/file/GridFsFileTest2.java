///*
// * Copyright 2016-2023 the original author.All rights reserved.
// * Kingstar(honeysoft@126.com)
// * The license,see the LICENSE file.
// */
//
//package org.teasoft.exam.bee.mongodb.file;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import org.teasoft.bee.mongodb.GridFsFile;
//import org.teasoft.bee.osql.Condition;
//import org.teasoft.bee.osql.Op;
//import org.teasoft.beex.osql.mongodb.MongodbSuidRichExt;
//import org.teasoft.beex.osql.shortcut.BFX;
//import org.teasoft.honey.osql.shortcut.BF;
//import org.teasoft.honey.osql.util.DateUtil;
//import org.teasoft.honey.util.Printer;
//
///**
// * @author Kingstar
// * @since  2.1
// */
//public class GridFsFileTest2 {
//	
//	public static void main(String[] args) {
//		MongodbSuidRichExt suidRichExt=BFX.getMongodbSuidRichExt();
//		
////		List list=suidRichExt.selectFiles(new GridFsFile(), null);
////		Printer.printList(list);
//		
//		GridFsFile gfs=new GridFsFile();
////		gfs.setFilename("msdia80.7z");
////		gfs.setFilename("filename");
////		gfs.setId("640cad39f7eebc616006cc83"); //不支持。  一般使用这个方法，就是为了拿文件id
//		
////		gfs.setChunkSize(261120);
//////		gfs.setLength(165L);
////		
////		Map<String,Object> metadata =new HashMap<>();
////		metadata.put("type", "7z");
//////		metadata.put("metadata.type", "mp4"); //不对
////		gfs.setMetadata(metadata);
////		
//////		List list=suidRichExt.selectFiles(gfs, null);
//////		Printer.printList(list);
////		
////		
////		//测试排序
////		Condition c=BF.getCondition();
//////		c.orderBy("filename");
//////		c.orderBy("length");
////		c.orderBy("length",OrderType.DESC);
////		
////		List list=suidRichExt.selectFiles(gfs, c);
////		Printer.printList(list);
//		
//		
//		SimpleDateFormat dateFormat_ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//		Date date = null;
//		try {
////			date = dateFormat_.parse("2023-03-23 03:22:10.405");
//			date = dateFormat_.parse("2023-03-23 11:22:10.405");  //这里输入的是要UTF-8;   数据库存的是2023-03-23 03:22:10.405; 直接复制DB里的不行
//		} catch (Exception e) {
//			
//		}
////		Condition c2=BF.getCondition();
////		c.orderBy("filename");
////		c.orderBy("length");
//		
////		System.out.println(date.toString());
////		System.out.println(date.toLocaleString());
//		
////		gfs.setUploadDate(date); //ok
//		
//		Condition condition=BF.getCondition();
//		condition.op("uploadDate", Op.ge, DateUtil.toDate("2023-03-22 02:22:10"));
//		
//		List list3=suidRichExt.selectFiles(gfs, condition);
//		Printer.printList(list3);		
//		
//	}
//
//}
