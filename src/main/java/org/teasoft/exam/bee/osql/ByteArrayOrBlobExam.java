/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.entity.ImageExam;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.StreamUtil;

/**
 * @author Kingstar
 * @since  2.1.10
 */
public class ByteArrayOrBlobExam {

	public static void main(String[] args) throws Exception {
		Suid suid=BF.getSuid();

		ImageExam imageExam = new ImageExam();

		String filePath = "F://testPic.jpg";
		File imageFile = new File(filePath);
		FileInputStream inputStream = new FileInputStream(imageFile);

		imageExam.setImage(inputStream); //将InputStream存入blob
		
		String str = "Hello, World!";
		byte[] byteArray = str.getBytes();
		imageExam.setBinary1(byteArray);  //存byte[]
		imageExam.setBinary2blob(byteArray); //将byte[]存入blob
		suid.insert(imageExam);
		
		ImageExam imageSelect = new ImageExam();
		imageSelect.setId(473684481);
//		imageSelect.setBinary1(byteArray); //不能用于过滤
		
		List<ImageExam> list=suid.select(imageSelect);
		Printer.printList(list);
		StreamUtil.inputStream2File(list.get(0).getImage(), "F://testPic2.jpg");
		
		
		System.out.println(StreamUtil.byteArray2String(list.get(0).getBinary1()));
		System.out.println(StreamUtil.byteArray2String(list.get(0).getBinary2blob()));

	}

}
