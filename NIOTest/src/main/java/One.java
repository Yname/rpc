import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class One {
    public static void main(String[] args) throws IOException {

        if (args.length==0){
            args = new String[3];
            args[0]="127.0.0.1";
            args[1]="hello Nio";
            args[2] = "8888";
        }

        if ((args.length < 2) || args.length > 3)
            throw new IllegalArgumentException("");
        String server = args[0];
        byte[] argument = args[1].getBytes();

        int serverPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;
        //打开通道
        SocketChannel sc = SocketChannel.open();
        //设置通道为非阻塞
        sc.configureBlocking(false);
        //如果不是指定的连接状态， 并且是完成了链接
        if (!sc.connect(new InetSocketAddress(server,serverPort))){
            while (!sc.finishConnect()){
                System.out.println("...."); //nothing to do！
            }
        }
        //装饰一个缓冲区
        ByteBuffer writeBuf = ByteBuffer.wrap(argument);
        ByteBuffer readBuf = ByteBuffer.allocate(argument.length);

        int totalByteRcvd = 0;
        int byteRcvd;

        while (totalByteRcvd < argument.length){
            if (writeBuf.hasRemaining()){
                sc.write(writeBuf);
            }
            if ((byteRcvd = sc.read(readBuf)) == -1){
                throw  new SocketException("Connection closed");
            }
            totalByteRcvd += byteRcvd;
            System.out.println(".");
        }

        System.out.println("Received: " + // convert to String per default charset
                new String(readBuf.array(), 0, totalByteRcvd));
        sc.close();
    }
}
