package org.teasoft.exam.bee.mongodb.json;

import java.util.List;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;


public class TestExam {
	public static void main(String[] args) {
		
		
		SuidRich suidRich=BF.getSuidRich();
		
		List<Exam> list=suidRich.select(new Exam(),5);
		System.out.println(list.size());
		Printer.printList(list);
		
		List<org.teasoft.exam.bee.mongodb.json.Exam> list2=suidRich.select(new org.teasoft.exam.bee.mongodb.json.Exam(),5);
		System.out.println(list2.size());
		Printer.printList(list2);
		
		list2=suidRich.select(new org.teasoft.exam.bee.mongodb.json.Exam(),5);
		System.out.println(list2.size());
		Printer.printList(list2);
		
	}
}
