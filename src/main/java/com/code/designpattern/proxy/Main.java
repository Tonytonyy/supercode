package com.code.designpattern.proxy;

import org.junit.Test;

public class Main {
    @Test
    public void staticProxyTest(){
        User target = new Student();
        StudentProxy proxy = new StudentProxy(target);
        proxy.save();
    }

    @Test
    public void proxyFactoryTest(){
        User target = new Student();
        System.out.println(target.getClass());
        System.out.println(target.getClass().getInterfaces());
        User proxy = (User)new ProxyFactory(target).getProxyInstance();
        proxy.save();
        System.out.println(proxy.getClass());
    }
    @Test
    public void cglibProxyTest(){
        Student target = new Student();
        System.out.println(target.getClass());
        Student proxy = (Student) new CglibProxyFactory(target).getProxyInstance();
        proxy.save();
        System.out.println(proxy.getClass());
    }
}
