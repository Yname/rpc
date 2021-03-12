import com.rpc.myrpc.RpcClient.NettyServer.handler.ServerOk;
import com.rpc.myrpc.handler.TestIOImpl;
import com.rpc.myrpc.handler.thread.StartThread;
import com.rpc.myrpc.handler.thread.StartThreadImpl;
import com.rpc.myrpc.utils.ClassLoad;
import com.rpc.myrpc.utils.StringSequeue;
import com.rpc.myrpc.utils.TransitDepotImpl;
import com.y.Test2;
import test.TestClazz;

import java.lang.reflect.Method;
import java.util.*;

public class TestOK extends TestIOImpl {
    @Override
    public void setObj(Object obj) {
        super.setObj(obj);
    }


    public static void main(String[] args) {
//        main2();
        tet();
//        get("");
    }

    public static void tet(){
        StringSequeue.getLongQueue("com.y.Test2");
        Object[] objects = TransitDepotImpl.map2.get("test.TestClazz");
        System.out.println(Arrays.toString(objects));
    }

    public static void get(String pathName){
        String parentName = null;
        List<String> list = new ArrayList<>();
        Map<String,Object[]> mapMethod = new HashMap<>();
        Test2 o = (Test2) ClassLoad.loadClass(Test2.class);
        Class<?>[] interfaces = o.getClass().getInterfaces();
//        for(Class obj: interfaces){
//            String name = obj.getName();
//            if (name.equals(pathName)){
////                比较协议名字
//                parentName = name;
//                System.out.println(name);
//                Method[] methods = obj.getMethods();
//                for(Method obj2: methods){
//                    list.add(obj2.getName());
//                }
//            }
//        }
        mapMethod.putIfAbsent(parentName, list.toArray());
        System.out.println(Arrays.toString(mapMethod.get(parentName)));

    }






    public boolean equals_sdf(Object obj) {
        return super.equals(obj);
    }

    public static void main2() {



        StartThread start = new StartThreadImpl();

        start
                .injectSerHandler(ServerOk.class)
                .serverRun();

        TestClazz obj = (TestClazz) TestIOImpl.getObjP();
        obj = new Test2();
        TestOK ok = new TestOK();
        ok.setObj(obj);
        String name = Thread.currentThread().getName();
        System.out.println(name+"]]");
        Thread.currentThread().notifyAll();
        System.out.println("name");
        System.out.println("name");

    }

}
