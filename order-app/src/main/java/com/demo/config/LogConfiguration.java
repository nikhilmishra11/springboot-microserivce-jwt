package com.demo.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableAspectJAutoProxy
@Aspect
@Slf4j
public class LogConfiguration {

	@Around("execution(* com.demo.controller..*(..)))")
	public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();

		final StopWatch stopWatch = new StopWatch();

		stopWatch.start();
		Object result = proceedingJoinPoint.proceed();
		stopWatch.stop();

		log.trace("Execution time: {}.{}()::{} ms", className, methodName, stopWatch.getTotalTimeMillis());
		return result;
	}
}