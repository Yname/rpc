import com.rpc.myrpc.RpcServer.NettyClient.handler.ClientOK;
import com.rpc.myrpc.RpcServer.NettyClient.handler.ClientObjHandler;
import com.rpc.myrpc.Test;
import com.rpc.myrpc.handler.thread.AbstractStartThread;
import com.rpc.myrpc.handler.thread.StartThreadImpl;
import com.rpc.myrpc.utils.StringSequeue;
import test.TestClazz;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestOK {


    public static void main(String[] args) {
//        StringSequeue.getLongQueue(TestClazz.class);
//        TestClazz clazz = null;
//        String simpleName = clazz.getClass().getSimpleName();
//        System.out.println(simpleName);
        String str = "57 0";
//        int i = Integer.parseInt(str);
//        System.out.println(i);

        boolean match = match(str);
        System.out.println(match);

    }


    public static boolean match(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    public  void main2(String[] args) {
        TestClazz clazz = null;
        AbstractStartThread thread = new StartThreadImpl();
        thread.injectCliHandler(ClientOK.class);
        thread.setObj(clazz).clientRun();

    }
}
