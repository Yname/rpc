package com.y.demo.handler;


import org.springframework.context.annotation.EnableAspectJAutoProxy;
import sun.applet.AppletClassLoader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class GameHandlerService {

    interface A {
        String print();
    }
    static class B implements A{

        @Override
        public String print() {
            System.out.println("print");
            return "ooo";
        }
    }

    public static void main(String[] args) {
//        A a = new B();
//        A a1 = (A) Proxy.newProxyInstance(a.getClass().getClassLoader(),
//                a.getClass().getInterfaces(), (proxy, method, args1) -> method.invoke(a, args1));
//        String print = a1.print();
//
//        System.out.println(print);
//        if (a1.print() != null){
//            System.out.println("not null");
//        }

    }


}
