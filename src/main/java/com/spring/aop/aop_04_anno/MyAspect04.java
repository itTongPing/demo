package com.spring.aop.aop_04_anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect04 {


    @Pointcut("execution(* com.spring.proxy.UserServiceImpl.*(..))")
    public void pointcut(){ }




    @Around("pointcut()")
    public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("前---anno--04");

        Object obj = joinPoint.proceed();

        System.out.println("后---anno--04");

        return obj;


    }




}
