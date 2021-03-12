package com.rpc.myrpc.RpcClient.NettyServer.dynamic;


public abstract class AbstractDynamic implements DynamicWide, ReadyLoad {

    public static boolean outMark;
    private String mark;
    @Override
    public void mark(String mark) {
        this.mark = mark;
    }

    @Override
    public void mark(boolean mark) {

    }

    @Override
    public boolean getMark() {
        return outMark;
    }

    @Override
    public Class loadClazz(Class tClass) {
        return null;
    }
}
