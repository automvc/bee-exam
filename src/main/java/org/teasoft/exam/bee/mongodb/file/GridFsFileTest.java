/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.file;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.teasoft.bee.mongodb.GridFsFile;
import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.beex.osql.mongodb.MongodbSuidRichExt;
import org.teasoft.beex.osql.shortcut.BFX;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.1
 */
public class GridFsFileTest {
	
	public static void main(String[] args) {
		MongodbSuidRichExt suidRichExt=BFX.getMongodbSuidRichExt();
		
//		List list=suidRichExt.selectFiles(new GridFsFile(), null);
//		Printer.printList(list);
		
		GridFsFile gfs=new GridFsFile();
//		gfs.setFilename("msdia80.7z");
//		gfs.setFilename("filename");
//		gfs.setId("640cad39f7eebc616006cc83"); //不支持。  一般使用这个方法，就是为了拿文件id
		
		gfs.setChunkSize(261120);
//		gfs.setLength(165L);
		
		Map<String,Object> metadata =new HashMap<>();
		metadata.put("type", "7z");
//		metadata.put("metadata.type", "mp4"); //不对
		gfs.setMetadata(metadata);
		
//		List list=suidRichExt.selectFiles(gfs, null);
//		Printer.printList(list);
		
		
		//测试排序
		Condition c=BF.getCondition();
//		c.orderBy("filename");
//		c.orderBy("length");
		c.orderBy("length",OrderType.DESC);
		
		List list=suidRichExt.selectFiles(gfs, c);
		Printer.printList(list);
		
	}

}
