package com.rpc.myrpc.RpcClient.NettyServer;


import com.rpc.myrpc.RpcClient.NettyServer.handler.ServerDecoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerImpl implements Server {

    private final static Logger logger = LoggerFactory.getLogger(ServerImpl.class);

    @Override
    public void run(int port,ChannelHandler clazz){
        logger.info("服务端 :=="+"START RUN ServerImpl.run METHOD");
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap bs = new ServerBootstrap();
        bs.group(bossGroup,workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception {
                        sc.pipeline().addFirst(
//                                new ServerDecoder(),
                                clazz);
//                        sc.pipeline().addLast(new TestHandler4());
                    }
                })
                //是提供给NioServerSocketChannel 用来接收进来的连接
                .option(ChannelOption.SO_BACKLOG,128)
                .childOption(ChannelOption.SO_KEEPALIVE,true);
        try {
//             绑定端口，开始接收进来的连接
            ChannelFuture cf = bs.bind(port).sync().channel().closeFuture().sync();
//             等待服务器  socket 关闭
//            cf.channel().closeFuture().sync();
            logger.info("服务端 :=="+"CLOSE CHANNEL METHOD");
        } catch (InterruptedException e) {
            logger.info("服务端错误信息 :=="+e);
        }finally {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            logger.info("服务端 :=="+"FINISH ALL EventLoopGroup");
        }
    }

}
