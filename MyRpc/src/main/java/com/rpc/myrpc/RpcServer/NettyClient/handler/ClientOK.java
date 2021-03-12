package com.rpc.myrpc.RpcServer.NettyClient.handler;

import com.rpc.myrpc.handler.NettyHandlerWide;
import com.rpc.myrpc.handler.OutHandlerImpl;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class ClientOK extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Object object = OutHandlerImpl.getClazz();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(object);
        oos.flush();
        byte[] bytes = baos.toByteArray();

        ByteBuf buf = ctx.alloc().buffer(bytes.length);
        buf.writeBytes(bytes);
        ctx.writeAndFlush(buf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf m = (ByteBuf) msg;
        byte[] bytes = new byte[m.readableBytes()];
        m.readBytes(bytes);
        NettyHandlerWide.rtnMsg = new String(bytes);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        System.out.println("什么也不做！");
    }
}
