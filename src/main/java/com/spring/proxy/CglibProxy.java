package com.spring.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy {

    final static MyAspect myAspect = new MyAspect();


    public static Object createCglibProxy(final UserServiceImpl userService){

        Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(userService.getClass());


        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    myAspect.pre();

                   Object obj =  method.invoke(userService, objects);
                myAspect.after();

                return obj;

            }
        });




        return enhancer.create();
    }

}
