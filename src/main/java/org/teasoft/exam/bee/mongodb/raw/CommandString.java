package org.teasoft.exam.bee.mongodb.raw;
//旧语法 
public class CommandString {
	
final static String find0 = "db.movies.find( { title: \"The Favourite\" } )";
final static String find1 = "db.movies.find ()";
final static String find2 = "db.movies.find({ \"title\": \"Jurassic }) aa\" } , { title: 1, type: 1, _id: 0,runtime:1 })";
final static String find3 = "db.movies.find({ \"title\": \"Jurassic }) aa\" },{ title: 1, type: 1, _id: 0,runtime:1 })";
final static String find4 = "db.movies.find( { \"title\": \"Tag\" } ).limit(1).sort({\"runtime\":1}).skip(2)";

//or里有：}, {  ，y
//final static String find5 = """
//	db.movies.find( {
//year: 2018,
//$or: [ { "awards.wins": { $gte: 5 } }, { genres: "Drama" } ]
//} )
//    """;

final static String find5 = "	db.movies.find( {\r\n"
		+ "year: 2018,\r\n"
		+ "$or: [ { \"awards.wins\": { $gte: 5 } }, { genres: \"Drama\" } ]\r\n"
		+ "} )";
	
final static String find6 = "db.movies.find( { \"title\": \"Tag\" } ).sort({\"runtime\":-1})";
			
	
final static String find7 = "db.movies.find({\"title\": \"Tag\"}).sort({\"runtime\":1}).skip(1).limit(1)";
	
//skip(), limilt(), sort()三个放在一起执行的时候，执行的顺序是先 sort(), 然后是 skip()，最后是显示的 limit()。
//以下不按顺序写
final static String find8 = "db.movies.find( { \"title\": \"Tag\" } ).limit(1).sort({\"runtime\":1}).skip(1)";

final static String find9 = "db.movies.findOne( { _id: 123 } )";


final static String find10 = "db.movies.find({ \"title\": \"Tag\" },{ title: 1, type: 1, _id: 0 })";

//比5多选字段
//final static String find11 = """
//db.movies.find( {
//year: 2018,
//$or: [ { "runtime": { $gte: 115 } }, { genres: "Drama" } ]
//} ,{ title: 1, type: 1, _id: 0,runtime:1 })
//""";

final static String find11="db.movies.find( {\r\n"
		+ "year: 2018,\r\n"
		+ "$or: [ { \"runtime\": { $gte: 115 } }, { genres: \"Drama\" } ]\r\n"
		+ "} ,{ title: 1, type: 1, _id: 0,runtime:1 })";

final static String find12 = "db.movies.find ()";
final static String find13 = "db.movies.find ({})";


final static String find14 = "db.movies.find({//and 加上 or 一起查询\r\n"
		+ "    \"runtime\":{$in:[130,105]},\r\n"
		+ "    $or:[{\"year\":{$lt:2020}},{\"title\":\"Tag\"}]\r\n"
		+ "    })";
//final static String find14 = """
//db.movies.find({//and 加上 or 一起查询
//    "runtime":{$in:[130,105]},
//    $or:[{"year":{$lt:2020}},{"title":"Tag"}]
//    })
//""";
		
//过滤条件是空的	
final static String find15 = "db.movies.find({},{\"name\":1}).sort({Age:-1})";

final static String find16 = "db.movies.find \n("
		+ "{})";


//final static String find17 = """
//		db.movies.find ( //
//		{})
//		""";
final static String find17 = "		db.movies.find ( //\r\n"
		+ "		{})";


final static String find18 = "		db.movies.find ( // 注释\r\n"
		+ "		{})";
//final static String find18 = """
//		db.movies.find ( // 注释
//		{})
//""";


final static String find19 = "		db.movies.find // 注释\r\n"
		+ "			( \r\n"
		+ "		{})";



final static String find20 = "		db.movies.find // 注释\r\n"
		+ "			\r\n"
		+ "			( \r\n"
		+ "		{})";

final static String find21 = "db.movies.find // 注释\r\n"
		+ "\r\n"
		+ "(//// 注释2\r\n"
		+ "{})";

final static String find22 = "db.movies.find // 注释\r\n"
		+ "\r\n"
		+ "( /*\r\n"
		+ " 多行注释\r\n"
		+ " */\r\n"
		+ "{})";
//final static String find22 = """
//db.movies.find // 注释
//
//( /*
// 多行注释
// */
//{})
//""";	


final static String find23 = "db.movies.find( \r\n"
		+ "\r\n"
		+ "{ title: \"The Favourite\" } )";
//final static String find23 = """
//db.movies.find( 
//
//{ title: "The Favourite" } )
//""";

//字段用双引号
final static String find24 = "db.movies.find( { \"title\": \"Tag\" } )  ";
//in
final static String find25 = "db.movies.find( { rated: { $in: [ \"PG\", \"PG-13\" ] } } )";

final static String find26 = "db.movies.find( { countries: \"Mexico\", \"imdb.rating\": { $gte: 7 } } )";

//getCollection语法
final static String find27 ="db.getCollection(\"movies\").find()";
final static String find28 ="db.getCollection('movies').find()";
final static String find29 ="db.getCollection('movies' ).find()";
//可以容忍集合名有多余的空格
final static String find30 ="db.getCollection( ' movies' ).find()";




final static String find31 ="db.testMongo_t.find({\"status\":{$in:[4,5,6,7]}})//单个条件查询";
final static String find32 ="db.testMongo_t.find({\"status\":{$in:[4,5,6,7]},\"name\":\"haiNun1\"})//并且语句查询；";

final static String find33 = "db.testMongo_t.find({//或语句查询\r\n"
		+ "  $or:[\r\n"
		+ "      {\"status\":{$in:[4,5,6,7]}},\r\n"
		+ "      {\"status\":1},\r\n"
		+ "      {\"name\":\"haiNun1\"}\r\n"
		+ "      ]\r\n"
		+ "  })";
final static String find34 = "db.testMongo_t.find({//and 加上 or 一起查询\r\n"
		+ "    \"status\":{$in:[4,5,6,7]},\r\n"
		+ "    $or:[{\"status\":{$lt:6}},{\"name\":\"haiNun\"}]\r\n"
		+ "    })";

final static String find35 = "db.xx.find({},{\"article.text\":1}).sort({time:1})";

//final static String find36 = """	
//db.yyy.aggregate([
//    { $unwind: '$Articles' },
//    {
//        $project: {
//            _id: 0,
//            Author: 1,
//            Title: '$Articles.Title',
//            PostTime: '$Articles.PostTime'
//        }
//    },
//    { $sort: { PostTime: -1 } }
//]);
//""";
//原文链接：https://blog.csdn.net/leinminna/article/details/89817410



	final static String insertOne = "			 db.movies.insertOne(\r\n"
			+ "				  {\r\n"
			+ "				    title: \"The Favourite\",\r\n"
			+ "				    runtime: 121,\r\n"
			+ "				    rated: \"R\",\r\n"
			+ "				    year: 2018,\r\n"
			+ "				    type: \"movie\"\r\n"
			+ "				  }\r\n"
			+ "				)";
	
	final static String insertMany = "db.movies.insertMany([\r\n"
			+ "			                      {\r\n"
			+ "			                         title: \"Jurassic World: Fallen Kingdom\",\r\n"
			+ "			                         genres: [ \"Action\", \"Sci-Fi\",\"Drama\" ],\r\n"
			+ "			                         runtime: 130,\r\n"
			+ "			                         rated: \"PG-13\",\r\n"
			+ "			                         year: 2018,\r\n"
			+ "			                         directors: [ \"J. A. Bayona\" ],\r\n"
			+ "			                         cast: [ \"Chris Pratt\", \"Bryce Dallas Howard\", \"Rafe Spall\" ],\r\n"
			+ "			                         type: \"movie\"\r\n"
			+ "			                       },\r\n"
			+ "			                       {\r\n"
			+ "			                         title: \"The Favourite\",\r\n"
			+ "			                         genres: [ \"Comedy\", \"Action\" ],\r\n"
			+ "			                         runtime: 105,\r\n"
			+ "			                         rated: \"R\",\r\n"
			+ "			                         year: 2018,\r\n"
			+ "			                         directors: [ \"Jeff Tomsic\" ],\r\n"
			+ "			                         cast: [ \"Annabelle Wallis\", \"Jeremy Renner\", \"Jon Hamm\" ],\r\n"
			+ "			                         type: \"movie\"\r\n"
			+ "			                       }\r\n"
			+ "			                   ])";
	
	
	//语法有问题
//	final static String updateOne = """
//			db.movies.updateOne( { title: "Tag" },
//				{
//				  $set: {
//				    plot: "One month every year, five highly competitive friends
//				           hit the ground running for a no-holds-barred game of tag"
//				  }
//				  { $currentDate: { lastUpdated: true } }
//				})
//				            """;
	
	final static String updateOne = "			db.movies.updateOne( { title: \"Tag\" },\r\n"
			+ "				{\r\n"
			+ "				  $set: {\r\n"
			+ "				    plot: \"One month every year, five highly competitive friends\r\n"
			+ "				           hit the ground running for a no-holds-barred game of tag\"\r\n"
			+ "				  },\r\n"
			+ "				   $currentDate: { lastUpdated: true }\r\n"
			+ "				})";


//deleteAll
final static String deleteAll = "db.movies.deleteMany({})";

final static String deleteMany = "db.movies.deleteMany( { title: \"The Favourite\" } )";

final static String deleteOne = "db.movies.deleteOne( { cast: \"Brad Pitt\" } )";

final static String deleteOne_2 = "db.movies.deleteOne( { _id: \"123\" } )";

final static String deleteOne_3 = "db.movies.deleteOne( { title: \"aa\" } )";

final static String deleteOne_4 = "db.movies.deleteOne( { title: \"The Favourite\" } )";


final static String remove = "db.movies.remove( { title: \"aa\" } )";
final static String deleteAll_Old = "db.col.remove({})";
//无{} 则语法不对：db.col.remove()

final static String insertMany21 = "db.inventory.insertMany( [\r\n"
		+ "                          { item: \"canvas\", qty: 100, size: { h: 28, w: 35.5, uom: \"cm\" }, status: \"A\" },\r\n"
		+ "                          { item: \"journal\", qty: 25, size: { h: 14, w: 21, uom: \"cm\" }, status: \"A\" },\r\n"
		+ "                          { item: \"mat\", qty: 85, size: { h: 27.9, w: 35.5, uom: \"cm\" }, status: \"A\" },\r\n"
		+ "                          { item: \"mousepad\", qty: 25, size: { h: 19, w: 22.85, uom: \"cm\" }, status: \"P\" },\r\n"
		+ "                          { item: \"notebook\", qty: 50, size: { h: 8.5, w: 11, uom: \"in\" }, status: \"P\" },\r\n"
		+ "                          { item: \"paper\", qty: 100, size: { h: 8.5, w: 11, uom: \"in\" }, status: \"D\" },\r\n"
		+ "                          { item: \"planner\", qty: 75, size: { h: 22.85, w: 30, uom: \"cm\" }, status: \"D\" },\r\n"
		+ "                          { item: \"postcard\", qty: 45, size: { h: 10, w: 15.25, uom: \"cm\" }, status: \"A\" },\r\n"
		+ "                          { item: \"sketchbook\", qty: 80, size: { h: 14, w: 21, uom: \"cm\" } },\r\n"
		+ "                          { item: \"sketch pad\", qty: 95, size: { h: 22.85, w: 30.5, uom: \"cm\" } }\r\n"
		+ "                       ] );";

final static String updateOne21 = "db.inventory.updateOne(\r\n"
		+ "		   { item: \"paper\" },\r\n"
		+ "		   {\r\n"
		+ "		     $set: { \"size.uom\": \"cm\", status: \"P\" },\r\n"
		+ "		     $currentDate: { lastModified: true }\r\n"
		+ "		   }\r\n"
		+ "		)";

final static String updateMany21 = "db.inventory.updateMany(\r\n"
		+ "		   { \"qty\": { $lt: 50 } },\r\n"
		+ "		   {\r\n"
		+ "		     $set: { \"size.uom\": \"in\", status: \"P\" },\r\n"
		+ "		     $currentDate: { lastModified: true }\r\n"
		+ "		   }\r\n"
		+ "		)";

final static String replaceOne21 = "db.inventory.replaceOne(\r\n"
		+ "		   { item: \"paper\" },\r\n"
		+ "		   { item: \"paper\", instock: [ { warehouse: \"A\", qty: 60 }, { warehouse: \"B\", qty: 40 } ] }\r\n"
		+ "		)";

final static String save21 = "db.inventory.save(\r\n"
		+ "		   { item: \"paper\" },\r\n"
		+ "		   { item: \"paper\", instock: [ { warehouse: \"A\", qty: 82 }, { warehouse: \"B\", qty: 40 } ] }\r\n"
		+ "		)";

final static String deleteAll21 = "db.inventory.deleteMany({})";

//https://blog.csdn.net/leinminna/article/details/89817410
//db.testMongo_t.updateOne(//根据name修改status
//带有注解， 两个花括号之间分行
//在关键字之间有注释，则原来的解析不了。   将输入的字符先去掉注释
final static String updateOne22 = "db.inventory.updateOne(//根据name修改status\r\n"
		+ "    {\r\n"
		+ "      \"name\":\"notebook\" /* adfdfd */\r\n"
		+ "    },\r\n"
		+ "    {\r\n"
		+ "    /* adfdfd\r\n"
		+ "      a\r\n"
		+ "      \r\n"
		+ "      */\r\n"
		+ "        $set:{\r\n"
		+ "            \"qty\":75\r\n"
		+ "        }\r\n"
		+ "    }"
        + "      )\r\n";  //少了这个，就找不到结果符了。
//final static String updateOne22 = """
//db.inventory.updateOne(//根据name修改status
//    {
//      "name":"notebook" /* adfdfd */
//    },
//    {
//    /* adfdfd
//      a
//      
//      */
//        $set:{
//            "qty":75
//        }
//    }
//)
//""";

//set部分为空
final static String updateOne23 = "db.inventory.updateOne(//根据name修改status\r\n"
		+ "    {\r\n"
		+ "      \"name\":\"notebook\" /* adfdfd */\r\n"
		+ "    },{})";
//      + "    },})";


final static String updateMany = "db.listingsAndReviews.updateMany(\r\n"
		+ "	  { security_deposit: { $lt: 100 } },\r\n"
		+ "	  {\r\n"
		+ "	    $set: { security_deposit: 100, minimum_nights: 1 }\r\n"
		+ "	  }\r\n"
		+ "	)";



final static String replaceOne = "db.accounts.replaceOne(\r\n"
		+ "  { account_id: 371138 },\r\n"
		+ "  { account_id: 893421, limit: 5000, products: [ \"Investment\", \"Brokerage\" ] }\r\n"
		+ ")";





final static String updateOne11 = "db.inventory.updateOne(//根据name修改status\r\n"
		+ "	    {\r\n"
		+ "	      \"item\":\"mat\"\r\n"
		+ "	    },\r\n"
		+ "	    {\r\n"
		+ "	        $set:{\r\n"
		+ "	            \"status\":2\r\n"
		+ "	        }\r\n"
		+ "	    }\r\n"
		+ "	)";

final static String updateOne12 = "	db.inventory.updateOne(//根据name修改status,添加degree和修改时间\r\n"
		+ "	    {\r\n"
		+ "	      \"item\":\"planner\"\r\n"
		+ "	    },\r\n"
		+ "	    {\r\n"
		+ "	        $set:{\r\n"
		+ "	            \"status\":3,\r\n"
		+ "	            \"degree\":1\r\n"
		+ "	        },\r\n"
		+ "	        $currentDate:{lastModified:true}\r\n"
		+ "	    }\r\n"
		+ "	)";

final static String updateMany11 = "	db.inventory.updateMany(//根据status批量修改；\r\n"
		+ "	    {\r\n"
		+ "	      \"status\":null\r\n"
		+ "	    },\r\n"
		+ "	    {\r\n"
		+ "	        $set:{\r\n"
		+ "	            \"status\":11,\r\n"
		+ "	            \"qty\":20\r\n"
		+ "	        },\r\n"
		+ "	        $currentDate:{lastModified:true}\r\n"
		+ "	    }\r\n"
		+ "	)";

final static String updateMany12 = "	db.inventory.updateMany(//按条件自增100\r\n"
		+ "	    {\"status\":{$lt:16}},\r\n"
		+ "	    {$inc: {\"status\": 100},\r\n"
		+ "	    $currentDate:{lastModified:true}\r\n"
		+ "	    }\r\n"
		+ "	)";

final static String updateMany13 = "	db.inventory.updateMany(//按条件-60（自减）\r\n"
		+ "	    {\"status\":{$gt:100}},\r\n"
		+ "	    {$inc: {\"status\": -60},\r\n"
		+ "	    $currentDate:{lastModified:true}\r\n"
		+ "	    }\r\n"
		+ "	)";
//	原文链接：https://blog.csdn.net/leinminna/article/details/89817410

}
