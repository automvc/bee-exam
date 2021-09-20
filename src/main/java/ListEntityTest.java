import java.util.List;

import org.teasoft.bee.osql.MoreTable;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactory;

/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class ListEntityTest {
	
public static void main(String[] args) {
		
		MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
		Clazz00 c00=new Clazz00();
		List<Clazz00> list00=moreTable.select(c00);
		Printer.printList(list00);
		
		SuidRich suidRich=BeeFactory.getHoneyFactory().getSuidRich();
		suidRich.deleteById(Clazz00.class, 0);
		
		suidRich.select(new Clazz00());
}

}
