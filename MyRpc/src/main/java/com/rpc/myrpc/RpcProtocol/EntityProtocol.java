package com.rpc.myrpc.RpcProtocol;

import java.io.Serializable;
import java.util.Map;

public interface EntityProtocol extends Serializable {
    int defPort = 9022;
    String defHost = "localhost";
    Map<String,Object> getObject();
}
