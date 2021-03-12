package com.rpc.myrpc.handler.thread;

import com.rpc.myrpc.RpcServer.NettyClient.handler.ClientStrHandler;
import com.rpc.myrpc.handler.NettyBridge;
import com.rpc.myrpc.handler.NettyHandlerWide;
import com.rpc.myrpc.handler.TestIOImpl;

public abstract class AbstractStartThread implements StartThread {

    final NettyBridge bridge = getNettyBridge();

    private static NettyBridge getNettyBridge(){
        return NettyHandlerWide.getBridge();
    }

    public StartThread setStrs(String objName,Object...paramsStr){
        bridge.setStrs(objName,paramsStr);
        return this;
    }

    public StartThread setObj(Object obj){
        bridge.setObj(obj);
        return this;
    }

    public Object clientRun(){
        Thread thread = new Thread(new ClientThread());
        thread.setName("ClientRun");
        thread.start();
        if (thread.isAlive()){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return bridge.getRtnMsg();
    }

    public AbstractStartThread injectSerHandler(Class servClz){
        bridge.injectSC(servClz,null);
        return this;
    }
    public AbstractStartThread injectCliHandler(Class cliClz){
        bridge.injectSC(null,cliClz);
        return this;
    }

    public void serverRun()   {
        Thread thread = new Thread(new ServerThread());
        thread.setName("ServerRun");


        thread.start();
//        if (TestIOImpl.getObj() == null){
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
    @Override
    public void run() {}
}
