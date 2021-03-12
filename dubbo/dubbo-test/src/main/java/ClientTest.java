import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.time.LocalDateTime;

public class ClientTest {
    static class DemoClientHandler extends SimpleChannelInboundHandler<String> {

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
            System.out.println("" + ctx.channel().remoteAddress());
            System.out.println("client output:" + msg);
            ctx.writeAndFlush("from client" + LocalDateTime.now());
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            String msg = "来自客户端的问候!";
            ctx.writeAndFlush(msg);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {

                        socketChannel.pipeline().addLast(new DemoClientHandler());
                    }
                });
        ChannelFuture channelFuture = bootstrap.connect("localhost",8899).sync();
        channelFuture.channel().closeFuture().sync();

        eventLoopGroup.shutdownGracefully();
    }
}
