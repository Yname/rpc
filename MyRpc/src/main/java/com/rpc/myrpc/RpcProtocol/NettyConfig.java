package com.rpc.myrpc.RpcProtocol;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

//@Configuration
//@ConfigurationProperties(prefix = "yzznetty")
//@PropertySource(value = "classpath:application.yml")

public class NettyConfig implements EntityProtocol {
    private int port;
    private String host;
    final Map<String, Object> map = new HashMap<>();

    public NettyConfig() {
        getObject();
    }
    public NettyConfig(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        System.out.println("NettyConfig"+port);
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        System.out.println("NettyConfig"+host);
        this.host = host;
    }


    @Override
    public Map<String, Object> getObject() {
        map.putIfAbsent("port",getPort());
        map.putIfAbsent("host",getHost());
        map.putIfAbsent("NettyConfig",this);
        System.out.println(getClass().getClassLoader());
        return map;
    }
}
