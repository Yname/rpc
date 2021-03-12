package com.rpc.myrpc.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransitDepotImpl implements TransitDepot {
    public final static List<Object> list = new ArrayList<>();
    public final static Map<Object,Object> map = new HashMap<>();
    public final static Map<String,Object[]> map2 = new HashMap<>();
    public final static Map<String,Object> map3 = new HashMap<>();

    public static void addList(Object object){
        list.add(object);
    }

    public static void addMap(Map<Object,Object> object){
        map.putAll(object);
    }

    public static void addMapArr(Map<String,Object[]> object){
        map2.putAll(object);
    }

    public static void addStrMap(Map<String,Object> object){
        map3.putAll(object);
    }

}
