/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */
package org.teasoft.exam.bee.mongodb.tran;

import org.bson.Document;

import com.mongodb.client.ClientSession;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.InsertOneResult;

/**
 * @author ctc
 * @since 1.0
 */
//两个插入， 中间有异常，两个都提交不正确
public class TransactionTest4 {

	public static void main(String[] args) {
		String uri = "mongodb://127.0.0.1:28011,127.0.0.1:28012,127.0.0.1:28013";
//		String uri = "mongodb://localhost:27017/testb?retryWrites=false";
//		String uri = "mongodb://localhost:27017/testb?authSource=admin&retryWrites=false";
//		String uri = "mongodb://localhost:27017/testb?authSource=admin&replicaSet=globaldb&retrywrites=false";
		MongoClient client = MongoClients.create(uri);
//		MongoClient client = MongoClient("192.168.52.131:27017", retryWrites="false");
		ClientSession clientSession = null;
		try {
			MongoCollection<Document> collection = client.getDatabase("testa").getCollection("customer");

			clientSession = client.startSession();  //放在拿collection之后也可以
			clientSession.startTransaction();
			System.err.println("开始事务。。。");
//			InsertOneResult a=collection.insertOne(new Document("firstName", "601"));
			InsertOneResult a=collection.insertOne(clientSession,new Document("firstName", "701")); //要将clientSession传入，才能回滚
			System.out.println(a.toString());
//			int ii=1/0;
//			System.err.println(ii);
			
			//中断提交时，第一条插入的语句已打印出来；
			
////			InsertOneResult b=collection.insertOne(new Document("firstName", "602"));
//			InsertOneResult b=collection.insertOne(clientSession,new Document("firstName", "502"));
//			System.out.println(b.toString());
			
			
			// 检索查看结果
			FindIterable<Document> findIterable = collection.find(clientSession).limit(3); // 分页
//	         FindIterable<Document> findIterable = cols.find().limit(3).skip(2);   //分页     skip, limit无先后之分
			MongoCursor<Document> mongoCursor = findIterable.iterator();

			while (mongoCursor.hasNext()) {
				Document d = mongoCursor.next();
				System.out.println(d);
				System.out.println("toJson: " + d.toJson());

				System.out.println(d.get("firstName"));
//				System.out.println(d.get("age"));
//				System.out.println(d.get("email"));
				System.out.println(d.get("_id"));

				System.out.println(d.containsKey("id"));
			}
			
			
			clientSession.commitTransaction();
			System.err.println("事务提交!!!");
		} catch (RuntimeException e) {
			System.err.println("------in RuntimeException-----------");
			System.err.println(e.getMessage());
			clientSession.abortTransaction();
			System.err.println("事务中断，事务开始至此的提交无效!!!");
			System.err.println("after abortTransaction");
		} finally {
			clientSession.close();
		}

		System.err.println("finished!");
	}

}
