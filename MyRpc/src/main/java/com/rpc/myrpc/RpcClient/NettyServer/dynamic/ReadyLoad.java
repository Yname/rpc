package com.rpc.myrpc.RpcClient.NettyServer.dynamic;


public interface ReadyLoad extends Dynamic{
       Object loadClazz(String tClass);
       Class loadClazz(Class tClass);
       void loadFile();
       public Object loadClazz(String tClass,String tmethod);
       public Object loadClazz(String tClass,String tmethod,Object...paramsStr);
       public Object loadClazz(String tClass,String tmethod,String paramsStr);
}
