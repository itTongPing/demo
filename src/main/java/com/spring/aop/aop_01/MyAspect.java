package com.spring.aop.aop_01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class MyAspect implements MethodInterceptor {


    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("前");
        Object proceed = methodInvocation.proceed();

        System.out.println("后");

        return proceed;
    }
}
