package com.rpc.myrpc.RpcClient.NettyServer.handler;

import com.rpc.myrpc.RpcClient.NettyServer.dynamic.ReadyDynamic;
import com.rpc.myrpc.utils.ClassLoad;
import com.rpc.myrpc.utils.StringUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.*;
import java.util.Map;

public class ServerObjHandler extends ChannelInboundHandlerAdapter {


    private Object msgStr;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf m = (ByteBuf) msg;
        byte[] bytes = new byte[m.readableBytes()];
        m.readBytes(bytes);
        String str = new String(bytes);
        str = str.substring(0,str.length()-1);

        msgStr = ClassLoad.loadClass(str);




//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("template"));


    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {




        byte[] bytes;
        ByteBuf buf;
        if (msgStr != null){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(msgStr);
            oos.flush();
            bytes= baos.toByteArray();
            oos.close();
        }else {
            bytes = new byte[0];
        }
        buf = ctx.alloc().buffer(bytes.length);
        buf.writeBytes(bytes);
        ctx.writeAndFlush(buf);
        ctx.channel().close();
//        关闭的是所有的channel，如客户端的SocketChannel与服务器的Channel;  close() and closeFuture()

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
