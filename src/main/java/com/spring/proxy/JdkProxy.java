package com.spring.proxy;

import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy{



    final static MyAspect myAspect = new MyAspect();



    public static Object getProxyInstance(final Object target){



        Object obj = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                  myAspect.pre();
                  Object obj2 = method.invoke(target, args);
                  myAspect.after();
                return obj2;
            }
        });


        return obj;
    }


    public static void main(String[] args) throws Throwable {


        InvocationHandler handler = new InvocationHandler(){
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object obj = method.invoke(proxy, args);
                return obj;
            }
        };

        Object obj = new Object();
        Object hashCode = handler.invoke(obj, obj.getClass().getMethod("hashCode"), null);
        System.out.println("handler--->"+hashCode+"object--->"+obj.hashCode());


    }


}
