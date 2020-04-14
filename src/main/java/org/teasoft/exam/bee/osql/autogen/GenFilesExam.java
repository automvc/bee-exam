/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(aiteasoft@163.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.autogen;

import java.util.HashMap;
import java.util.Map;

import org.teasoft.honey.osql.autogen.GenFiles;

/**
 * @author Kingstar
 * @since  1.7.2
 */
public class GenFilesExam {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<>();
		map.put("entityName1", "Orderhistory");
		map.put("entityName", "orderhistory");
		map.put("packageName", "com.automvc.enet.order.rest");
		更改成本地的具体路径  change to your real path
//		String basePath = "D:\\JavaWeb\\workspaceGit\\bee-exam\\src\\main\\java\\org\\teasoft\\exam\\bee\\osql\\autogen\\";
		String basePath = "D:\\xxx\\yyy\\bee-exam\\src\\main\\java\\org\\teasoft\\exam\\bee\\osql\\autogen\\";
		
		String templatePath = basePath + "OrderhistoryRest.java.template";
		String targetFilePath = basePath + "OrderhistoryRest.java";

		GenFiles.genFile(templatePath, map, targetFilePath);

	}

}
