package com.rpc.myrpc.RpcClient.NettyServer.dynamic;

public interface DynamicWide extends Dynamic {
    void mark(String mark);
    void mark(boolean mark);
    boolean getMark();

}
