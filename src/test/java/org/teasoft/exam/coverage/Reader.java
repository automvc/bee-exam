/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.coverage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;
import org.teasoft.honey.osql.util.PropertiesReader;

/**
 * @author Kingstar
 * @since  1.17
 */
public class Reader {
	@Test
	public void test() {
		PropertiesReader reader0=new PropertiesReader();
		
		String fileName="/bee.properties";
		InputStream in = PropertiesReader.class.getResourceAsStream(fileName);
		PropertiesReader reader=new PropertiesReader(in);
		
		reader.getValueText("abc");
		reader.getValue("abc","can not found");
	}

}
