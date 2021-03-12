package com.rpc.myrpc.RpcServer.NettyClient;

import io.netty.channel.ChannelHandler;

public interface Client {
     void run(int port, String host, ChannelHandler clazz);
}
