package com.rpc.myrpc.RpcClient.NettyServer.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class ServerDecoder extends MessageToByteEncoder<Object> {


    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        byte[] body = convertToBytes(msg);  //将对象转换为byte
//        int dataLength = body.length;  //读取消息的长度
//        out.writeInt(dataLength);  //先将消息长度写入，也就是消息头

//        out.writeBytes(body);
        out.writeBytes(body);  //消息体中包含我们要发送的数据
    }

    private byte[] convertToBytes(Object msg) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(msg);
        oos.flush();
        byte[] bytes = baos.toByteArray();
        oos.close();
        baos.close();
        return bytes;
    }


}
