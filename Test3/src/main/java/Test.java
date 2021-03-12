import com.rpc.myrpc.RpcServer.NettyClient.handler.ClientFunHandler;
import com.rpc.myrpc.RpcServer.NettyClient.handler.ClientObjHandler;
import com.rpc.myrpc.RpcServer.NettyClient.handler.ClientStrHandler;
import com.rpc.myrpc.handler.thread.AbstractStartThread;
import com.rpc.myrpc.handler.thread.StartThreadImpl;
import test.TestClazz;

import java.io.IOException;
import java.io.ObjectInputStream;

public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String[] str = {"youzs","huaqian","sfas"};
        Object[] objs = {"12345",str};
        Object[] objects = new Object[1];
        objects[0] = str;

        AbstractStartThread thread = new StartThreadImpl();
        thread.injectCliHandler(ClientFunHandler.class);
        Object yzz = thread.setStrs("com.y.Test2::say5",  str).clientRun();
        System.out.println(yzz);

//        System.out.println(test2.readByte());
//        test2.defaultReadObject();

//        System.out.println(test2.readChar());
//        TestClazz o = (TestClazz)test2.readObject();
//        System.out.println(o.say2("name"));
//        NettyBridge wide = new NettyHandlerWide();
//        wide.injectSC(null, ClientStrInHandler.class)
//                .setStrs("Test2::say4",  "")
//                .clientStart();
//        String rtnMsg = wide.getRtnMsg();
//        System.out.println(rtnMsg);


//        Object[] arrParams = {"123",new String[]{"123","1234"}};
//        System.out.println(Arrays.toString(arrParams));
//        String string = arrParams[0]+arrParams[1].toString();
//        System.out.println(string);
//        System.out.println(Arrays.toString(string.getBytes()));
//        String sub = Arrays.toString(string.getBytes());
//        System.out.println(sub);
//
//        List<Object> list = new ArrayList<Object>();
//        list.add("");
//        list.toArray();



    }
}
