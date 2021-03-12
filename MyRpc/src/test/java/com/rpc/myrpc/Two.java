package com.rpc.myrpc;

import com.rpc.myrpc.RpcClient.NettyServer.dynamic.AbstractDynamic;
import com.rpc.myrpc.RpcClient.NettyServer.dynamic.DynamicWide;

import java.nio.ByteBuffer;

public  class Two {
    public static void main(String[] args) {

//        ByteBuffer buffer = ByteBuffer.allocate(1024);
//        byte[] bytes = new byte[1024];
//        ByteBuffer wrap = ByteBuffer.wrap(bytes);
//        ByteBuffer wraps = ByteBuffer.wrap(bytes,0,255);
        DynamicWide dynamicWide = null;
        try {
             dynamicWide = (DynamicWide) Class.forName("com.rpc.myrpc.RpcClient.NettyServer.dynamic.HandlerWide").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        assert dynamicWide != null;
        System.out.println(dynamicWide.getMark());
    }



}
