package com.rpc.myrpc.RpcServer.NettyClient.handler;

import com.rpc.myrpc.handler.NettyHandlerWide;
import com.rpc.myrpc.handler.OutHandlerImpl;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientStrHandler extends ChannelInboundHandlerAdapter {

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
        NettyHandlerWide.rtnMsg = new String(bytes);
        ctx.pipeline().addFirst(new ClientStr2Handler());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        System.out.println("什么也不做！");
    }
}
