import jdk.nashorn.internal.ir.debug.ClassHistogramElement;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class Server {
    private Selector selector;
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);//调整缓冲区大小为1024字节
    private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);


    public void start() throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.bind(new InetSocketAddress(3400));

        selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        while ( !Thread.currentThread().isInterrupted()){
            int select = selector.select();
            System.out.println(select);
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();

            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                if (!key.isValid()){
                    continue;
                }
                if (key.isAcceptable()){
                    accept(key);
                }
                if (key.isReadable()){
                    read(key);
                }
                if (key.isWritable()){
                    write(key);
                }
                keyIterator.remove();
            }
        }
    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        this.readBuffer.clear();//清除缓冲区，准备接受新数据
        int numRead;
        try{
            numRead = socketChannel.read(this.readBuffer);
        }catch (IOException e){
            key.cancel();
            socketChannel.close();
            return;
        }
        String str = new String(readBuffer.array(), 0, numRead);
        System.out.println(str);
        socketChannel.register(selector,SelectionKey.OP_WRITE);

    }

    private void write(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        String str = "str";
        System.out.println("write:"+str);

        sendBuffer.clear();
        sendBuffer.put(str.getBytes());
        sendBuffer.flip();//反转，由写变为读
        channel.write(sendBuffer);
        //注册读操作 下一次进行读
        channel.register(selector,SelectionKey.OP_READ);
    }

    private void accept(SelectionKey key) throws IOException {
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
        SocketChannel clientChannel = ssc.accept();
        clientChannel.configureBlocking(false);
        clientChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("a new client connected "+clientChannel.getRemoteAddress());

    }
}
