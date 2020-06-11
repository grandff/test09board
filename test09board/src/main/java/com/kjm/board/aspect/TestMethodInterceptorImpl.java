package com.kjm.board.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kjm.board.controller.HomeController;

public class TestMethodInterceptorImpl implements MethodInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(TestMethodInterceptorImpl.class);
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		logger.info("invoke on !!!! ");
		
		String method = "";
		Object obj = null;
		
		try {
			// 1. 메소드 실행 전에 메소드명 획득
			method = invocation.getMethod().getName();			// method 이름 가져옴 
			logger.info("1. call method name is " + method);
			
			// 2. 메소드 실행 전 수행로직 구현
			logger.info("2. {} 메소드 실행[전] 수행 로직 구현", method);
			
			// 3. 해당 메소드 호출
			obj = invocation.proceed();
			logger.info("3. called {} return {} ", method, obj);
			
			// 4. 메소드 실행 후 수행 로직 구현
			logger.info("4. {} 메소드 실행 [후] 수행 로직 구현", method);			
		}catch(Exception e) {
			logger.info("error :: " + e.toString());
		}
		
		
		
		return obj;
	}

}
