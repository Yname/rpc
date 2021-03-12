package com.rpc.myrpc.RpcClient.NettyServer.dynamic;

public class HandlerWide extends AbstractDynamic {
    @Override
    public void mark(boolean mark) {
        AbstractDynamic.outMark = mark;
    }

    @Override
    public Object loadClazz(String tClass) {
        return null;
    }

    @Override
    public void loadFile() {

    }

    @Override
    public Object loadClazz(String tClass, String tmethod) {
        return null;
    }

    @Override
    public Object loadClazz(String tClass, String tmethod, Object... paramsStr) {
        return null;
    }

    @Override
    public Object loadClazz(String tClass, String tmethod, String paramsStr) {
        return null;
    }


}
