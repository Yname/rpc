package com.rpc.myrpc.utils;

import java.lang.reflect.Method;
import java.util.*;

public class StringSequeue {


    public static void getLongQueue(Object objName){
        Object obj;
        if (objName instanceof String){
            obj = ClassLoad.loadClass((String) objName);
        }else {  //Class
            obj = ClassLoad.loadClass((Class) objName);
        }
        Class clazz = obj.getClass();
//        暂时拿不到父接口名
        setMap("test.TestClazz",clazz.getInterfaces());
    }

    public static void setMap(String pathName,Class[] clazz){
        String parentName = null;
        List<String> list = new ArrayList<>();
        Map<String,Object[]> mapMethod = new HashMap<>();
        for(Class obj: clazz){
            String name = obj.getName();
            //比较协议名字
            if (name.equals(pathName)){
                parentName = name;
                Method[] methods = obj.getMethods();
                for(Method obj2: methods){
                    list.add(obj2.getName());
                }
            }
        }
        mapMethod.putIfAbsent(parentName, list.toArray());
        TransitDepotImpl.addMapArr(mapMethod);
    }

}
