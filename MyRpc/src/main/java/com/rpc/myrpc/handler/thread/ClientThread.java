package com.rpc.myrpc.handler.thread;

import com.rpc.myrpc.RpcServer.NettyClient.handler.ClientStrHandler;

import java.util.HashMap;
import java.util.Map;

public class ClientThread extends AbstractStartThread{

    @Override
    public void run() {

        bridge.injectSC(null, ClientStrHandler.class)
                .clientRun();
    }




}
