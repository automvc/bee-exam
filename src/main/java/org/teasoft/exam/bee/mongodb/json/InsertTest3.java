package org.teasoft.exam.bee.mongodb.json;

import org.teasoft.bee.osql.IncludeType;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.shortcut.BF;

public class InsertTest3 {
	
	public static void main(String[] args) {

		Exam exam = new Exam();

		SuidRich suidRich = BF.getSuidRich();

		int b = suidRich.insert(exam, IncludeType.INCLUDE_BOTH);

		System.err.println(b);
		
		System.err.println(exam.getId());

	}

}
