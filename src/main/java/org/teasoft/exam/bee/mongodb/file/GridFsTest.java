/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.file;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.1
 */
public class GridFsTest {
	
	public static void main(String[] args) throws Exception{
//		String filePath = "G:\\msdia80.7z";
		String filePath = "G:\\运行环境.7z";
		InputStream stream = new FileInputStream(filePath) ;

		
		HistoryFile history=new HistoryFile();
		history.setName("test");
		history.setFile(stream);
//		history.setFilename("msdia80.7z");
		history.setFilename(filePath);
		
		Map<String,Object> metadata=new HashMap<>();
		metadata.put("type", "txt-7z-23");
		history.setMetadata(metadata);
		
		SuidRich suidRich=BF.getSuidRich();
		int insertNum=suidRich.insert(history);
		stream.close();
		System.out.println("insertNum: "+insertNum);
	}

}
