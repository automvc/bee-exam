/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.geo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.teasoft.beex.osql.mongodb.IndexType;
import org.teasoft.beex.osql.mongodb.MongodbSuidRichExt;
import org.teasoft.beex.osql.shortcut.BFX;
import org.teasoft.exam.comm.Printer;

import com.mongodb.client.model.geojson.LineString;
import com.mongodb.client.model.geojson.Polygon;
import com.mongodb.client.model.geojson.Position;

/**
 * 测试Mongodb地理信息插入,查询;
 * @author Kingstar
 * @since  2.1
 */
public class InsertAndSelectAllKind2 {

	public static void main(String[] args) {
		insertAndSelect();
	}

	public static void insertAndSelect() {
		
		MongodbSuidRichExt suidRichExt = BFX.getMongodbSuidRichExt();
		
		Hotel2 doc1 = new Hotel2().setName("tom").setRaid(Arrays.asList(10D, 10D)).setGps(new Gps2(10D, 10D));
		Hotel2 doc2 = new Hotel2().setName("jone").setRaid(Arrays.asList(10.1D, 10D)).setGps(new Gps2(10.1D, 10D));
		Hotel2 doc3 = new Hotel2().setName("john").setRaid( Arrays.asList(10D, 10.1D)).setGps(new Gps2(10D, 10.1D));
		Hotel2 doc4 = new Hotel2().setName("jack").setRaid( Arrays.asList(9.9D, 10D)).setGps(new Gps2(9.9D, 10D));
		Hotel2 doc5 = new Hotel2().setName("mary").setRaid( Arrays.asList(10D, 9.9D)).setGps(new Gps2(10D, 9.9D));
		Hotel2 doc6 = new Hotel2().setName("abby").setRaid( Arrays.asList(10.2D, 10D)).setGps(new Gps2(10.2D, 10D));
		Hotel2 doc7 = new Hotel2().setName("adam").setRaid( Arrays.asList(10.3D, 10D)).setGps(new Gps2(10.3D, 10D));
		Hotel2 doc8 = new Hotel2().setName("barry").setRaid( Arrays.asList(10.4D, 10D)).setGps(new Gps2(10.4D, 10D));
		Hotel2 doc9 = new Hotel2().setName("anne").setRaid( Arrays.asList(10.5D, 10D)).setGps(new Gps2(10.5D, 10D));
		int num = suidRichExt.insert(Arrays.asList(doc1, doc2, doc3, doc4, doc5, doc6, doc7, doc8, doc9));
		System.out.println("insert num : " + num);

		String indexReturn1 = suidRichExt.index("hotel", "raid", IndexType.geo2d);
		String indexReturn2 = suidRichExt.index("hotel", "gps", IndexType.geo2dsphere);
		System.out.println(indexReturn1);
		System.out.println(indexReturn2);

		// $geoWithin 匹配任意几何图形内搜索
		List<Hotel2> list = suidRichExt.geoWithin(new Hotel2(), "raid",
				new Polygon(Arrays.asList(new Position(10.2, 10), new Position(10, 10.2),
						new Position(9.8, 10), new Position(10, 9.8), new Position(10.2, 10))));
		System.out.println("----------------geoWithin raid-------------");
		Printer.printList(list);

		// $geoWithinBox 在以左下角和右上角坐标构成方形内搜索
		List<Hotel2> list2 = suidRichExt.geoWithinBox(new Hotel2(), "raid", 9.8, 9.8, 10.2, 10.2);
		System.out.println("----------------geoWithinBox raid-------------");
		Printer.printList(list2);

		// $geoWithinPolygon 在多边形内搜索
		List<Double> p1 = new ArrayList<>();
		List<Double> p2 = new ArrayList<>();
		List<Double> p3 = new ArrayList<>();
		p1.add(10d);
		p1.add(10d);
		p2.add(10.1);
		p2.add(10.16);
		p3.add(10.2);
		p3.add(10d);
		List<List<Double>> polygon = Arrays.asList(p1, p2, p3);
		List<Hotel2> list3 = suidRichExt.geoWithinPolygon(new Hotel2(), "raid", polygon, null);
		System.out.println("----------------geoWithinPolygon raid-------------");
		Printer.printList(list3);

		p2.clear();
		p2.add(9.9);
		p2.add(10.16);
		p3.clear();
		p3.add(9.8);
		p3.add(10d);
		polygon = Arrays.asList(p1, p2, p3);

		list3 = suidRichExt.geoWithinPolygon(new Hotel2(), "gps", polygon, null);
		System.out.println("----------------geoWithinPolygon gps-------------");
		Printer.printList(list3);

		// $geoWithinCenter 在指定圆心和半径的圆形内搜索
		List<Hotel2> list4 = suidRichExt.geoWithinCenter(new Hotel2(), "raid", 10d, 10d, 0.25);
		System.out.println("----------------geoWithinCenter raid-------------");
		Printer.printList(list4);

		// $geoWithinCenterSphere 在球体(地球)上指定圆心和弧度搜索, 例如搜索以[10,10]为中心500米内的文档, 参数为...10d, 10d, 0.5/6371
		list4 = suidRichExt.geoWithinCenterSphere(new Hotel2(), "gps", 10d, 10d, 11d / 6371);
		System.out.println("----------------geoWithinCenterSphere gps-------------");
		Printer.printList(list4);

		// $geoIntersects
		List<Hotel2> list5 = suidRichExt.geoIntersects(new Hotel2(), "gps",
				new LineString(Arrays.asList(new Position(10, 10.1), new Position(10.1, 10),
						new Position(10, 9.9))));
		System.out.println("----------------geoIntersects gps-------------");
		Printer.printList(list5);

		// $near
		List<Hotel2> list6 = suidRichExt.near(new Hotel2(), "gps", 10, 10, 20566d, 0d);
		System.out.println("----------------near gps-------------");
		Printer.printList(list6);

		// $nearSphere
		list6 = suidRichExt.near(new Hotel2(), "gps", 10, 10, 20566d, 10d);
		System.out.println("----------------nearSphere gps-------------");
		Printer.printList(list6);
	}

}
