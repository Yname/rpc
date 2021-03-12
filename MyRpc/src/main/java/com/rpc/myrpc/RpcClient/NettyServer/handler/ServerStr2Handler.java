package com.rpc.myrpc.RpcClient.NettyServer.handler;

import com.rpc.myrpc.RpcClient.NettyServer.dynamic.ReadyDynamic;
import com.rpc.myrpc.utils.StringUtils;
import com.rpc.myrpc.utils.TransitDepotImpl;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Map;

public class ServerStr2Handler extends ChannelInboundHandlerAdapter {

    private String msgStr;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf m = (ByteBuf) msg;
        byte[] bytes = new byte[m.readableBytes()];
        m.readBytes(bytes);
        String str = new String(bytes);
        if (!str.equals("1")){
//            map.put("methodStr",methodStr);
//            map.put("clazzStr",clazzStr);
//            map.put("paramsStr",paramsStr);
            System.out.println("ServerStr2Handler.channelRead.什么也不做");
        }else {
            msgStr = load();
//            ctx.channel().writeAndFlush(msgStr);
        }

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buf = ctx.alloc().buffer(msgStr.getBytes().length);
        buf.writeBytes(msgStr.getBytes());
        ctx.writeAndFlush(buf);
//        关闭的是所有的channel，如客户端的SocketChannel与服务器的Channel;  close() and closeFuture()
        ctx.channel().close();
    }

    private String load() throws Exception {
        Object rtn;
        ReadyDynamic readyDynamic = ReadyDynamic.class.getDeclaredConstructor().newInstance();
        rtn = readyDynamic.loadClazz((String) TransitDepotImpl.map3.get("clazzStr"), (String) TransitDepotImpl.map3.get("methodStr"), (String) TransitDepotImpl.map3.get("paramsStr"));
        return (String) rtn;
    }
}
