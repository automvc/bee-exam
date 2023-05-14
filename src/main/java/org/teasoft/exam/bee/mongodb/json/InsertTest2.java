//package org.teasoft.exam.bee.mongodb.json;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.teasoft.bee.osql.PreparedSql;
//import org.teasoft.honey.osql.shortcut.BF;
//
//public class InsertTest2 {
//	
//	public static void main(String[] args) {
//		
////		String sql="insert into exam(id,lastName,firstName) values (?,?,?)"; //这种不行,要有变量名才能从Map中寻找参数
////		String sql="insert into exam(id,lastName,firstName) values (#{id},#{firstName},#{lastName})";
//		String sql="insert into exam(sex,lastName,firstName) values (#{sex},#{firstName},#{lastName})";
//		List<Map<String, Object>> list=new ArrayList<>();
//		Map<String, Object> map=new HashMap<>();
////		map.put("sex", null);
//		map.put("firstName", "aa");
//		map.put("lastName", "bb");
//		
//		Map<String, Object> map2=new HashMap<>();
////		map2.put("id", 124);
////		map2.put("sex", "1");
//		map2.put("firstName", "aa2");
//		map2.put("lastName", "bb2");
//		
//		list.add(map);
//		list.add(map2);
//		
//		PreparedSql pr=BF.getPreparedSql();
//		
//		int b=pr.insertBatch(sql, list);
//		System.err.println(b);
//		
//	}
//
//}
