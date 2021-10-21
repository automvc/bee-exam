/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.honey.osql.autogen.ColumnBean;
import org.teasoft.honey.osql.autogen.ColumnUtil;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.NameTranslateHandle;
import org.teasoft.honey.util.StreamUtil;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class ChangeSqlScript {
	

	//更改mysql脚本中的字段命名,如:
	//`projectName` varchar(60) COLLATE utf8_bin DEFAULT NULL,
	//-->
	//`project_name` varchar(60) COLLATE utf8_bin DEFAULT NULL,
	public static void main(String[] args) throws JsonProcessingException,IOException{
		
		HoneyConfig honeyConfig=HoneyConfig.getHoneyConfig();
		honeyConfig.setUrl("jdbc:mysql://localhost:3306/teasoft0?characterEncoding=UTF-8");
		honeyConfig.setUsername("root");
		honeyConfig.setPassword("123456");
//		List<ColumnBean> list=ColumnUtil.getColumnList("tableinfo");
		List<ColumnBean> list=ColumnUtil.getColumnList("tableinfo_copy");
//		List<ColumnBean> list=ColumnUtil.getColumnList("columninfo");
		Map<String,String> map=new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			ColumnBean b=list.get(i);
			map.put("  `" +b.getName()+ "` ", "  `" +NameTranslateHandle.toColumnName(b.getName())+ "` ");
		}
		
		System.err.println(map);
		InputStream in=new FileInputStream("D:\\temp\\tableinfo.sql");
//		InputStream in=new FileInputStream("D:\\temp\\columninfo.sql");
		System.out.println(StreamUtil.stream2String(in,map));
		
		System.err.println(DatabaseConst.MariaDB);
	}

}
