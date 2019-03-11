package com.spring.proxy;

public class ProxyTest {


    public static void main(String[] args) {

        UserService proxyInstance = (UserService) JdkProxy.getProxyInstance(new UserServiceImpl());
        proxyInstance.show("a");


        UserServiceImpl cglibProxy = (UserServiceImpl) CglibProxy.createCglibProxy(new UserServiceImpl());
        cglibProxy.cglibMethod();

    }
}
