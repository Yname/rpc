package com.rpc.myrpc.RpcClient.NettyServer.dynamic;

import com.rpc.myrpc.utils.StringUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReadyDynamic<T> implements ReadyLoad {

    private Class tClazz;


    @Override
    public Object loadClazz(String tClass,String tmethod) {
        T o = null;
        Object rtnMsg = null;
        try {
            Object o1 = Class.forName(tClass).newInstance();
            Method[] methods = Class.forName(tClass).getMethods();
            for (Method method : methods){
                if (method.getName().equals(tmethod)){
                    rtnMsg = method.invoke(o1, "");
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return rtnMsg;
    }

    @Override
    public Object loadClazz(String tClass, String tmethod, Object... paramsStr) {
        Object rtnMsg = null;
        try {
            Object o1 = Class.forName(tClass).newInstance();
            Method[] methods = Class.forName(tClass).getMethods();
            for (Method method : methods){
                if (method.getName().equals(tmethod)){
                    rtnMsg = method.invoke(o1, paramsStr);
                    System.out.println(rtnMsg);
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return rtnMsg;
    }

    @Override
    public Object loadClazz(String tClass, String tmethod, String paramsStr) {
        Object rtnMsg = null;
        try {
            Object o1 = Class.forName(tClass).newInstance();
            Method[] methods = Class.forName(tClass).getMethods();
            for (Method method : methods){
                if (method.getName().equals(tmethod)){
                    rtnMsg = method.invoke(o1, StringUtils.resolveParStr(paramsStr));

                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return rtnMsg;
    }




    @Override
    public Object loadClazz(String tClass) {
        T o = null;
        try {
            Object o1 = Class.forName(tClass).newInstance();
            Method[] method = Class.forName(tClass).getMethods();
            for (Method m : method){
//                if (m.getName().equals())
                Object youzs = m.invoke(o1, "youzs!!!!!!!");
                System.out.println(youzs);
            }

//            method.invoke()
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public Class<T> loadClazz(Class tClass){
        T t = null;
        try {
            t = (T) tClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return (Class<T>) t;
    }

    @Override
    public void loadFile() {

    }


}
