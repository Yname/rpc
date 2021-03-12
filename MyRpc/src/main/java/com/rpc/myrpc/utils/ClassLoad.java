package com.rpc.myrpc.utils;

import java.lang.reflect.InvocationTargetException;

public class ClassLoad {

    public static Object loadClass(Class clazz){
        Object o = null;
        try {
             o = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return o;
    }

    public static Object loadClass(String clazz){
        Object o = null;
        try {
            o = Class.forName(clazz).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }



}
