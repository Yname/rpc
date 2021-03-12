package com.rpc.myrpc.handler;

public interface OutHandler {
    void setArrStr(String pathName,Object...paramsStr);
    void setClazz(Object object);
}
