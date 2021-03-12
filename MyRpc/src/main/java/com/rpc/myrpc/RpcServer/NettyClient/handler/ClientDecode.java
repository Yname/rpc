//package com.rpc.myrpc.RpcServer.NettyClient.handler;
//
//import com.rpc.myrpc.handler.NettyHandlerWide;
//import io.netty.buffer.ByteBuf;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.handler.codec.ByteToMessageDecoder;
//
//import java.io.ByteArrayInputStream;
//import java.io.ObjectInputStream;
//import java.util.List;
//
//public class ClientDecode extends ByteToMessageDecoder {
//    @Override
//    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
//        if (in.readByte() < -1){
//            return;
//        }
//
//        byte[] bytes = new byte[in.readableBytes()];
//        in.readBytes(bytes);
//        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
//        ObjectInputStream ois = new ObjectInputStream(bais);
//        out.add(ois);
//        NettyHandlerWide.rtnMsg =  ois.readObject();
//
//    }
//}
