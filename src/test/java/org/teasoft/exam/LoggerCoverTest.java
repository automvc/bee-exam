/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.junit.Test;
import org.teasoft.bee.osql.search.Operator;
import org.teasoft.honey.logging.FileLogger;
import org.teasoft.honey.logging.Jdk14LoggingImpl;
import org.teasoft.honey.logging.NoLogging;
import org.teasoft.honey.logging.SystemLogger;

/**
 * @author Kingstar
 * @since  1.11
 */
public class LoggerCoverTest {
	
	@Test
	public void test() {
		test0();
	}
	
	private void test0() {
		NoLogging noLogging=new NoLogging();
		noLogging.info("test NoLogging");
		noLogging.debug("test NoLogging");
		noLogging.trace("test NoLogging");
		noLogging.warn("test NoLogging");
		noLogging.error("test NoLogging");
		noLogging.warn("test NoLogging",new Throwable("test NoLogging"));
		noLogging.error("test NoLogging",new Throwable("test NoLogging"));
		noLogging.isDebugEnabled();
		noLogging.isErrorEnabled();
		noLogging.isInfoEnabled();
		noLogging.isTraceEnabled();
		noLogging.isWarnEnabled();
		new NoLogging(LoggerCoverTest.class.getName());
		
		SystemLogger systemLogger=new SystemLogger();
		systemLogger.info("test SystemLogger");
		systemLogger.debug("test SystemLogger");
		systemLogger.trace("test SystemLogger");
		systemLogger.warn("test SystemLogger");
		systemLogger.error("test SystemLogger");
		systemLogger.warn("test SystemLogger",new Throwable("test SystemLogger"));
		systemLogger.error("test SystemLogger",new Throwable("test SystemLogger"));
		systemLogger.isDebugEnabled();
		systemLogger.isErrorEnabled();
		systemLogger.isInfoEnabled();
		systemLogger.isTraceEnabled();
		systemLogger.isWarnEnabled();
		
		systemLogger.debug("FileLogger debug", new Exception());
		SystemLogger systemLogger2=new SystemLogger(LoggerCoverTest.class.getName());
		systemLogger2.trace("trace");
		
		Jdk14LoggingImpl jdk14LoggingImpl=new Jdk14LoggingImpl("test");
		jdk14LoggingImpl.info("test Jdk14LoggingImpl");
		jdk14LoggingImpl.debug("test Jdk14LoggingImpl");
		jdk14LoggingImpl.trace("test Jdk14LoggingImpl");
		jdk14LoggingImpl.warn("test Jdk14LoggingImpl");
		jdk14LoggingImpl.error("test Jdk14LoggingImpl");
//		jdk14LoggingImpl.warn("test Jdk14LoggingImpl",new Throwable("test Jdk14LoggingImpl"));
//		jdk14LoggingImpl.error("test Jdk14LoggingImpl",new Throwable("test Jdk14LoggingImpl"));
		jdk14LoggingImpl.isDebugEnabled();
		jdk14LoggingImpl.isErrorEnabled();
		jdk14LoggingImpl.isInfoEnabled();
		jdk14LoggingImpl.isTraceEnabled();
		jdk14LoggingImpl.isWarnEnabled();
		
		Operator operator=Operator.like;
		jdk14LoggingImpl.info(operator.getOperator());
		
		FileLogger fileLogger=new FileLogger();
		fileLogger.isDebugEnabled();
		fileLogger.isErrorEnabled();
		fileLogger.isInfoEnabled();
		fileLogger.isTraceEnabled();
		fileLogger.isWarnEnabled();
		fileLogger.debug("FileLogger debug");
		fileLogger.warn("warn");
		fileLogger.error("error");
		fileLogger.debug("FileLogger debug", new Exception());
		fileLogger.warn("FileLogger debug", new Exception());
		fileLogger.error("FileLogger debug", new Exception());
		FileLogger fileLogger2=new FileLogger(LoggerCoverTest.class.getName());
		fileLogger2.trace("trace");
		fileLogger2.debug("FileLogger debug", new Exception());
		fileLogger2.warn("FileLogger debug", new Exception());
		fileLogger2.error("FileLogger debug", new Exception());
	}

}
