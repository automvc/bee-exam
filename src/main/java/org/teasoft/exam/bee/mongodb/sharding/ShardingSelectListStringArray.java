
package org.teasoft.exam.bee.mongodb.sharding;

import java.util.List;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 分片值在javabean;
 * 1)没设置分库键; 2)设置分库键;
 * @author Kingstar
 * @since  2.0
 *
 */
public class ShardingSelectListStringArray {

	public static void main(String[] args) {
		try {
			InitDsAndMongoDsUtil.initDS();
			ShardingDoConfig.init();
			test();
		} finally {
			ClearDsAndMongoDsUtil.clearConfig();
		}
	}

	public static void test() {

		SuidRich suidRich = BF.getSuidRich(); // 1
		Orders orders1 = new Orders();

		orders1.setAbc("test bee ");

		List<String[]> list = suidRich.selectString(orders1);
		Printer.print(list);

		System.out.println("--------------------:");

		orders1.setOrderid(4L); // 分片值在javabean
		list = suidRich.selectString(orders1);
		Printer.print(list);

	}
}
