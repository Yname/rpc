package com.rpc.myrpc.RpcProtocol;

import java.util.HashMap;
import java.util.Map;

public class NettyConfig2J implements EntityProtocol{
    private int defPort ;
    private String defHost;
    private final Map<String, Object> map = new HashMap<>();

    public NettyConfig2J() {
        this.defPort = EntityProtocol.defPort;
        this.defHost = EntityProtocol.defHost;
    }

    public NettyConfig2J(String host, int port) {
        this.defHost = host;
        this.defPort = port;
    }

    public int getDefPort() {
        return defPort;
    }

    public void setDefPort(int defPort) {
        this.defPort = defPort;
    }

    public String getDefHost() {
        return defHost;
    }

    public void setDefHost(String defHost) {
        this.defHost = defHost;
    }

    @Override
    public Map<String, Object> getObject() {
        map.putIfAbsent("port",getDefPort());
        map.putIfAbsent("host",getDefHost());
        map.putIfAbsent("NettyConfig2J",this);
        System.out.println(getClass().getClassLoader());
        return map;
    }
}
