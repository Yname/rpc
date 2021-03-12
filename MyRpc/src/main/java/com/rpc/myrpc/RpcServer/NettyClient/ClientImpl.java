package com.rpc.myrpc.RpcServer.NettyClient;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientImpl implements Client {
    private final static Logger logger = LoggerFactory.getLogger(ClientImpl.class);

    public void run(int port, String host, ChannelHandler clazz) {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addFirst(clazz);
//                        ch.pipeline().addLast(new TestOutHandler());
                        logger.info("客户端 :=="+"FINISH RUN ClientImpl.childHandler.initChannel METHOD");
                    }
                })
                .option(ChannelOption.SO_KEEPALIVE,true);
        ChannelFuture cf = null;
        try {
            cf = bootstrap.connect(host,port).sync();
            cf.channel().closeFuture().sync();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
//        finally {
////            workGroup.shutdownGracefully();
//
//        }
    }



}
