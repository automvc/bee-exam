/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.tran;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 * @author ctc
 * @since 1.0
 */
public class MongoDbTest2_Cluster2 {
	
	public static void main(String[] args) {
		test();
	}

	//mongodb要以集合方式部署
	public static void test() {
		MongoClient mongoClient = null;
		try {
//	          mongoClient =MongoClients.create("mongodb://localhost:28018");
			mongoClient = MongoClients
					.create("mongodb://127.0.0.1:28011,127.0.0.1:28012,127.0.0.1:28013");

			// 连接到数据库
			MongoDatabase mongoDatabase = mongoClient.getDatabase("testa");
			System.out.println("Connect to database successfully");

			MongoCollection<Document> cols = mongoDatabase.getCollection("student"); // Collection 相当于表 ;Document相当于行.
			System.out.println("集合 student 选择成功");

			MongoCollection<Document> collection = cols;
			Document document = new Document();
			document.append("name", "MongoDB3").append("email", "database@163.com")
					.append("age", 21);
//	                 append("by", "Fly");  
			collection.insertOne(document);

			// 检索查看结果
//	         FindIterable<Document> findIterable = cols.find();  
			FindIterable<Document> findIterable = cols.find().limit(3); // 分页
//	         FindIterable<Document> findIterable = cols.find().limit(3).skip(2);   //分页     skip, limit无先后之分
			MongoCursor<Document> mongoCursor = findIterable.iterator();

			while (mongoCursor.hasNext()) {
				Document d = mongoCursor.next();
				System.out.println(d);
				System.out.println("toJson: " + d.toJson());

				System.out.println(d.get("name"));
				System.out.println(d.get("age"));
				System.out.println(d.get("email"));
				System.out.println(d.get("_id"));

				System.out.println(d.containsKey("id"));
			}

			BasicDBObject query = new BasicDBObject();
			// 复杂的条件查询，查询ranking大于等于5小于9的记录
			query = new BasicDBObject();
			query.put("ranking", new BasicDBObject("$gte", 5).append("$lt", 9));

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		} finally {
			if (mongoClient != null) mongoClient.close();
		}
	}
}
