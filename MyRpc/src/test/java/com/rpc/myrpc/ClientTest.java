package com.rpc.myrpc;

import java.util.Map;

public class ClientTest {


//    @Bean
//    public NettyHandlerImpl myService() {
//        return new NettyHandlerImpl();
//    }

    static Map<String,Object> prit(Map<String,Object> map){
        map.putIfAbsent("123","123");
        return map;
    }
    public static void main(String[] args) throws InterruptedException {


        
    }
}
