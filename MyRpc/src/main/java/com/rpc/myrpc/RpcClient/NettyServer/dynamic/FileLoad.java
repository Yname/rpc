package com.rpc.myrpc.RpcClient.NettyServer.dynamic;

public interface FileLoad extends Dynamic{
    String defPath = "";
    boolean isNotEmptyFile();
    boolean isNewFile();

}
