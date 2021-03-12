package com.rpc.myrpc.handler.thread;

import com.rpc.myrpc.RpcClient.NettyServer.handler.ServerStrHandler;

public class ServerThread extends AbstractStartThread {

    @Override
    public void run() {
        bridge.injectSC(ServerStrHandler.class, null).serverRun();
    }


}
