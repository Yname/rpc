package com.rpc.myrpc;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import net.minidev.json.JSONUtil;

import java.nio.ByteBuffer;

public  class  One {
    public static void main(String[] args) {
        System.out.println("ONE");
    }


    void printOne(){

        String[] args = {};
        main(args);
    }


    class A extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ((ByteBuf)msg).release();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

            cause.printStackTrace();
            ctx.close();
            super.exceptionCaught(ctx,cause);
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
           final ByteBuf time = ctx.alloc().buffer(4);
           time.writeInt((int) ((System.currentTimeMillis())/1000L));
           final ChannelFuture f = ctx.writeAndFlush(time);
           f.addListener(new ChannelFutureListener() {
               @Override
               public void operationComplete(ChannelFuture future) throws Exception {
                   assert f == future;
                   ctx.close();
               }
           });
        }


    }
}
