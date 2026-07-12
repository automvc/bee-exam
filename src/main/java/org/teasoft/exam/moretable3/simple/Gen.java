package org.teasoft.exam.moretable3.simple;

import org.teasoft.honey.osql.shortcut.BF;

import entity.News;

public class Gen {
	
	public static void main(String[] args) {
		System.out.println("------------");
		
//		BF.getSuidRich().createTable(TestUser.class, true);
//		BF.getSuidRich().createTable(Orders2026.class, true);
		
		
//		GenConfig genConfig=new GenConfig();
//		genConfig.setGenToString(true);
//		genConfig.setOverride(true);
//		
//		GenBean genBean=new GenBean(genConfig);
////		genBean.genSomeBeanFile("province");
////		genBean.genSomeBeanFile("city");
////		genBean.genSomeBeanFile("town");
////		genBean.genSomeBeanFile("village");
////		genBean.genSomeBeanFile("road");
//		
////		genBean.genSomeBeanFile("province_history"); //TODO 命名转换
//		
//		genBean.genSomeBeanFile("s");
		
//		BF.getSuidRich().createTable(Province.class, false);
//		BF.getSuidRich().createTable(City.class, false);
//		BF.getSuidRich().createTable(Town.class, false);
//		BF.getSuidRich().createTable(Village.class, false);
//		BF.getSuidRich().createTable(Road.class, false);
//		
//		BF.getSuidRich().createTable(ProvinceHistory.class, false);
//		BF.getSuidRich().createTable(S.class, false);
		
		BF.getSuidRich().createTable(News.class, false);
	}

}
