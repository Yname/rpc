package com.rpc.myrpc.RpcServer.NettyClient.handler;

import com.rpc.myrpc.handler.NettyHandlerWide;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientStr2Handler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String builder = NettyHandlerWide.rtnMsg.toString();
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

    }


}
