/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.util;

import static org.teasoft.honey.util.currency.BeeFinancialCalculator.calculate;
import static org.teasoft.honey.util.currency.BeeFinancialCalculator.preCheckExpression;

import java.math.RoundingMode;

import org.junit.Test;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.util.currency.CurrencyExpressionArith;

/**
 * @author Kingstar
 * @since  2.1.8
 * @since  2.4.0
 */
public class CurrencyExpressionArithTest {

	@Test
	public void test() {

		try {

			System.out.println(CurrencyExpressionArith.preCheckExpression("10-1*9"));

			System.out.println(calculate("1/3")); // 0.33 默认保留两位
			System.out.println(calculate("1/3", 6)); // 0.333333

//		System.out.println(calculate("1.545555/1", 3, RoundingMode.HALF_UP)); // 1.546
//		System.out.println(calculate("1.545555/1", 1, RoundingMode.HALF_UP)); // 1.5

			System.out.println(calculate("12/1", 3, RoundingMode.HALF_UP));

			System.out.println(calculate("(4+5)*(3-2)"));
//		System.out.println(calculate("a+bt*(c-d)-e/f")); // 只是符号转换就不行了 符号转换不能拿来运算

			System.out.println(calculate("1+2*(3-4)-5/6")); // 遇到+-号,栈有 +-*/ 都要出栈,碰到(就停止

			System.out.println(calculate("1+2*3/(5-4)+6"));
			System.out.println(calculate("6+3*2/(5-4)+1"));// 遇到*/号,栈有 同级元素*/ 都要出栈
			System.out.println(calculate("1+2*3/4")); // 遇到*/号,栈有 同级元素*/ 都要出栈

			System.out.println(calculate("6+3*(2/(5-4))+1"));

			System.out.println(calculate("(4+5)*(3/2)"));
			System.out.println(calculate("(4+5)/(3/2)")); // 测试运算逆波兰式时,栈用a/b是否有调反

			try {
				System.out.println(calculate("(4+5)*(3/2))"));// the number of '(' and ')' is not equal !
			} catch (Exception e) {
				Logger.error(e.getMessage());
			}

			try {
				System.out.println(calculate("(4#5)*(3/2)")); //there is some other char(not number) : #
			} catch (Exception e) {
				Logger.error(e.getMessage());
			}

//		//preCheckExpression提前检测表达式,是否合法
			System.out.println(preCheckExpression("(4#5)*(3/2)")); // 非法字符
			System.out.println(preCheckExpression("(4++5)*(3/2)")); // 连续运算符
			System.out.println(preCheckExpression("(4+*/5)*(3/2)")); // 连续运算符
			System.out.println(preCheckExpression("(4+*/5)*(3+-*2)")); // 连续运算符

			try {
				System.out.println(preCheckExpression("(a+b)*(c/2)")); // 非法字符
			} catch (Exception e) {
				Logger.error(e.getMessage());
			}

			try {
				System.out.println(preCheckExpression("(a+bt)*(c/2)")); // 非法字符
			} catch (Exception e) {
				Logger.error(e.getMessage());
			}

			try {
				System.out.println(preCheckExpression("(4+5))*(3/2)")); // 括号数量不致
			} catch (Exception e) {
				Logger.error(e.getMessage());
			}

		} catch (Exception e) {
			Logger.error(e.getMessage());
		}
	}

}
