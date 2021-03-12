package com.rpc.myrpc.RpcClient.NettyServer.handler;

import com.rpc.myrpc.RpcClient.NettyServer.dynamic.ReadyDynamic;
import com.rpc.myrpc.utils.StringUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.*;

public class ServerStrHandler extends ChannelInboundHandlerAdapter {

    private String msgStr;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf m = (ByteBuf) msg;
        byte[] bytes = new byte[m.readableBytes()];
        m.readBytes(bytes);
        String str = new String(bytes);
        msgStr = resolveStr(str);
        if (msgStr == null){
            return;
        }
        ctx.channel().writeAndFlush(msgStr);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buf = ctx.alloc().buffer(msgStr.getBytes().length);
        buf.writeBytes(msgStr.getBytes());
        ctx.writeAndFlush(buf);
//        关闭的是所有的channel，如客户端的SocketChannel与服务器的Channel;  close() and closeFuture()
        ctx.channel().close();

    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

//    断开连接后的操作
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        System.out.println("什么一不做！");
    }

    private String resolveStr(String str) throws Exception {
        Object rtn;
        Map<String, Object> map = StringUtils.resolveStr(str);
        ReadyDynamic readyDynamic = ReadyDynamic.class.getDeclaredConstructor().newInstance();
        rtn = readyDynamic.loadClazz((String) map.get("clazzStr"), (String) map.get("methodStr"), (String) map.get("paramsStr"));
        return (String) rtn;
    }
}
