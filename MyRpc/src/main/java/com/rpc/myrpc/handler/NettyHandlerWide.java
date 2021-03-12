package com.rpc.myrpc.handler;

import com.rpc.myrpc.RpcClient.NettyServer.Server;
import com.rpc.myrpc.RpcProtocol.EntityProtocol;
import com.rpc.myrpc.RpcServer.NettyClient.Client;
import com.rpc.myrpc.utils.ClassLoad;
import io.netty.channel.ChannelHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * 对外暴露的nettyHandler接口
 */
public class NettyHandlerWide implements NettyBridge {
//    //handler
//    private NettyHandler handler;
    //设置服务端handler
    public static volatile Object rtnMsg;
    private Object objN;
    //方法参数
    private String paramsStr;
    private Object[] strsParams;
//    private String className;
    private int port;
    private volatile boolean lock = false;
    private String host;
    //server端
    private String serverClazz;
    //client端
    private String clientClazz;
    //协议，就是port，host
    EntityProtocol protocol;
    private String objName;
//    private String NettyHandlerImplClazz;
    private final Map<String,Class> map = new HashMap<>();
    private static NettyBridge bridge = new NettyHandlerWide();
    public static NettyBridge getBridge(){
        return bridge;
    }

    public NettyHandlerWide() {
//        this("",null);
        this(null);
    }

//    public NettyHandlerWide(String className) {
////        this(className,null);
//    }

    public NettyHandlerWide(EntityProtocol protocol) {
//        this.className = className;
        this.protocol = protocol;
//        this.NettyHandlerImplClazz = nettyHandlerImplClazz;

//        setHandler(nettyHandlerImplClazz);

//        if ("".equals(className) || getClassName() == null)
//            setClassName(Constants.defaultHandler);

        if (this.protocol == null){
            this.port = EntityProtocol.defPort;
            this.host = EntityProtocol.defHost;
        }else {
            if (!protocol.getObject().isEmpty()){
                this.port = (int) protocol.getObject().get("port");
                this.host = (String) protocol.getObject().get("host");
            }else {
                this.port = EntityProtocol.defPort;
                this.host = EntityProtocol.defHost;
            }
        }

    }

//    public NettyHandlerWide setHandler(String NettyHandlerImplClazz){
//        if (NettyHandlerImplClazz.equals(""))
//            NettyHandlerImplClazz = Constants.NettyHandlerImplClazz;
//
//        NettyHandler nettyHandlerImpl = null;
//        try {
//            nettyHandlerImpl = (NettyHandler) Class.forName(NettyHandlerImplClazz).newInstance();
//        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        this.handler = nettyHandlerImpl;
//        return this;
//    }

    public String getClientClazz() {
        return clientClazz;
    }

    public void setClientClazz(String clientClazz) {
        this.clientClazz = clientClazz;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

//    @Override
//    public NettyHandler getHandle() {
//        return handler;
//    }

    @Override
    public String getClassHandler(String className){
        return className;
    }

    public NettyHandlerWide setStrName(String objName,String paramsStr) {
        this.objName = objName;
        this.paramsStr = paramsStr;
        return this;
    }

    public NettyHandlerWide setStrs(String objName,Object...paramsStr) {
        this.objName = objName;
        this.strsParams = paramsStr;
        return this;
    }

    public NettyHandlerWide setObj(Object obj) {
        this.objN = obj;
        return this;
    }

    public String getServerClazz() {
        return serverClazz;
    }

    public void setServerClazz(String serverClazz) {
        this.serverClazz = serverClazz;
    }

//    public void setClassName(String className) {
//        this.className = className;
//    }
//
//    public String getClassName() {
//        return className;
//    }

    public void setProtocol(EntityProtocol protocol) {
        this.protocol = protocol;
    }

    public EntityProtocol getProtocol() {
        return protocol;
    }

    public int getPort(){
        return port;
    }

    public NettyHandlerWide injectSC(Class servClz, Class cliClz){
        map.putIfAbsent("ServerHandler",servClz);
        map.putIfAbsent("ClientHandler",cliClz);
        return this;
    }

    public Object getRtnMsg(){
        return rtnMsg;
    }

    public void clientRun(){
        if ("".equals(getClientClazz()) || getClientClazz() == null)
            clientClazz = Constants.clientClazz;
        Client client = (Client) ClassLoad.loadClass(clientClazz);
        if (client != null){
            OutHandler impl = (OutHandler) ClassLoad.loadClass(OutHandlerImpl.class);
            impl.setArrStr(objName,strsParams);
//            impl.setClazz(objN);
            client.run(getPort(),getHost(), (ChannelHandler) ClassLoad.loadClass(map.get("ClientHandler")));
        }
    }

    public void serverRun(){
        if ("".equals(getServerClazz()) || getServerClazz() == null)
            serverClazz = Constants.serverClazz;
        Server server = (Server) ClassLoad.loadClass(serverClazz);
        if (server != null){
            ChannelHandler serverHandler = (ChannelHandler) ClassLoad.loadClass(map.get("ServerHandler"));
            server.run(getPort(), serverHandler);
        }
    }





}
