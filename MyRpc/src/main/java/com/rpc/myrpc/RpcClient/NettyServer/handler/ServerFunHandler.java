package com.rpc.myrpc.RpcClient.NettyServer.handler;

import com.rpc.myrpc.RpcClient.NettyServer.dynamic.ReadyDynamic;
import com.rpc.myrpc.utils.ClassLoad;
import com.rpc.myrpc.utils.StringUtils;
import com.rpc.myrpc.utils.TransitDepotImpl;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Map;

public class ServerFunHandler extends ChannelInboundHandlerAdapter {
    private Object msgStr;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msgStr == null){
            ByteBuf m = (ByteBuf) msg;
            byte[] bytes = new byte[m.readableBytes()];
            m.readBytes(bytes);
            String str = new String(bytes);
            msgStr = resolveStr(str);
            if (msgStr == null){
                msgStr = "0";
            }else {
                msgStr = "1";
            }
        }else {
            ByteBuf m = (ByteBuf) msg;
            byte[] bytes = new byte[m.readableBytes()];
            m.readBytes(bytes);
            msgStr = new String(bytes);
        }
    }


    private Object resolveStr(String str) throws Exception {
        Object rtn = null;
        Map<String, Object> map = StringUtils.resolveStr(str);
        if (map == null){
            return "ServerFunHandler.Exception";
        }
        TransitDepotImpl.addStrMap(map);
        rtn = ClassLoad.loadClass((String) map.get("clazzStr"));
        return rtn;
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        if (msgStr.toString().equals("0")){
            throw new Exception("请输入和协议对称的类名和方法");
        } else if (msgStr.toString().equals("1")){
            ByteBuf buf = ctx.alloc().buffer(msgStr.toString().getBytes().length);
            buf.writeBytes(msgStr.toString().getBytes());
            ctx.writeAndFlush(buf);
        }else if (msgStr.toString().equals("11")){
            msgStr = load();
            ByteBuf buf = ctx.alloc().buffer(msgStr.toString().getBytes().length);
            buf.writeBytes(msgStr.toString().getBytes());
            ctx.writeAndFlush(buf);
            ctx.channel().close();
        }

//        关闭的是所有的channel，如客户端的SocketChannel与服务器的Channel;  close() and closeFuture()
//        ctx.channel().close();
    }


    private String load() throws Exception {
        Object rtn;
        ReadyDynamic readyDynamic = ReadyDynamic.class.getDeclaredConstructor().newInstance();
        rtn = readyDynamic.loadClazz((String) TransitDepotImpl.map3.get("clazzStr"), (String) TransitDepotImpl.map3.get("methodStr"), (String) TransitDepotImpl.map3.get("paramsStr"));
        return (String) rtn;
    }

}
