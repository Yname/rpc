package com.rpc.myrpc.RpcServer.NettyClient.handler;

public class ClientPojo {
    private String name;
    public ClientPojo(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ClientPojo{" +
                "name='" + name + '\'' +
                '}';
    }
}
