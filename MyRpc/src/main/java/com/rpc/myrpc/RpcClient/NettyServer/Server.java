package com.rpc.myrpc.RpcClient.NettyServer;

import io.netty.channel.ChannelHandler;

public interface Server  {

    void run(int port, ChannelHandler clazz);
}
