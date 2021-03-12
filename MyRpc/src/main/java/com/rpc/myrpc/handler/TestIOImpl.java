package com.rpc.myrpc.handler;

public abstract class  TestIOImpl implements TestIO{

    public static Object objectP;
    public static Object object;

    public static Object getObjP(){
        return objectP;
    }

    public static Object getObj(){
        return object;
    }

    @Override
    public void setObj(Object obj) {
        object = obj;
    }
}
