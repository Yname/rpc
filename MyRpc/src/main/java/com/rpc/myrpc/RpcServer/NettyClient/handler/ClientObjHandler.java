package com.rpc.myrpc.RpcServer.NettyClient.handler;

import com.rpc.myrpc.handler.NettyHandlerWide;
import com.rpc.myrpc.handler.OutHandlerImpl;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ClientObjHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String builder = OutHandlerImpl.getArrStr();
        ByteBuf buf = ctx.alloc().buffer(builder.getBytes().length);
        buf.writeBytes(builder.getBytes());
        ctx.writeAndFlush(buf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf m = (ByteBuf) msg;
        byte[] bytes = new byte[m.readableBytes()];
        m.readBytes(bytes);
//        String s = new String(bytes);
        System.out.println(bytes.length);
        if (bytes.length > -1){
//            File file = new File("template");
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//            System.out.println(ois);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
//            System.out.println(ois.read(bytes));
//            System.out.println(ois.readByte());
            NettyHandlerWide.rtnMsg =  ois;
        }else {
            System.out.println("jjjj");
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        System.out.println("什么也不做！");
    }
}
