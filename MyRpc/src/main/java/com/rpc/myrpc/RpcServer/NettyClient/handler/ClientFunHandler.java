package com.rpc.myrpc.RpcServer.NettyClient.handler;

import com.rpc.myrpc.handler.NettyHandlerWide;
import com.rpc.myrpc.handler.OutHandlerImpl;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientFunHandler extends ChannelInboundHandlerAdapter {
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
        String rtn  = new String(bytes);
        System.out.println(rtn);
        NettyHandlerWide.rtnMsg = rtn;
//        ctx.channel().close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        ctx.pipeline().addLast(new ClientStr2Handler());

        if (NettyHandlerWide.rtnMsg.toString().equals("1")){
            String builder = "11";
            ByteBuf buf = ctx.alloc().buffer(builder.getBytes().length);
            buf.writeBytes(builder.getBytes());
            ctx.writeAndFlush(buf);
        }else {
            System.out.println("什么也不做！");
        }

    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }
}
