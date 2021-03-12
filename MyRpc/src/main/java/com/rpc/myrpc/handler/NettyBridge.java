package com.rpc.myrpc.handler;



public interface NettyBridge {
//    NettyHandler getHandle();
    String getClassHandler(String className);
    int getPort();
    NettyHandlerWide injectSC(Class servClz, Class cliClz) ;
    public NettyHandlerWide setStrs(String objName,Object...paramsStr);
    public NettyHandlerWide setObj(Object boj);
    Object getRtnMsg();
    public void clientRun();
    public void serverRun();
}
