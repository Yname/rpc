package com.rpc.myrpc.handler.thread;

public interface StartThread extends Runnable{
    public Object clientRun();
    public void serverRun();
    public AbstractStartThread injectSerHandler(Class servClz);
    public AbstractStartThread injectCliHandler(Class cliClz);

}
