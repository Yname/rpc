import com.rpc.myrpc.RpcClient.NettyServer.handler.ServerFunHandler;
import com.rpc.myrpc.RpcClient.NettyServer.handler.ServerStrHandler;
import com.rpc.myrpc.handler.thread.StartThread;
import com.rpc.myrpc.handler.thread.StartThreadImpl;
import com.rpc.myrpc.utils.ClassLoad;
import com.rpc.myrpc.utils.StringSequeue;
import com.y.Test2;
import test.TestClazz;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Test {
    static void run(){
//        NettyBridge wide = new NettyHandlerWide();
//        wide.injectSC(ServerStrInHandler.class, null);
        StartThread start = new StartThreadImpl();
        start
                .injectSerHandler(ServerFunHandler.class)
                .serverRun();
    }


    public static void tet(){

//        long longQueue = StringSequeue.getLongQueue(TestClazz.class);
//        Object o = ClassLoad.loadClass(TestClazz.class);
//        Object testClazz = ClassLoad.loadClass("TestClazz");
//        Method[] methods = TestClazz.class.getMethods();


    }




    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        run();
//        main2();
//        jake();
//        tet();


//        Method[] methods = TestClazz.class.getMethods();





//        String str = "[asdf,asdfadf]";
//        List<String> list = Arrays.asList(str);
//        System.out.println(Arrays.toString(list.toArray()));
//        Object o1 = Class.forName("com.y.Test2").newInstance();
//        Method[] test2s = Class.forName("com.y.Test2").getMethods();
//        Object[] objects = new Object[2];
//        objects[0] = "asd";
//        objects[1] =new String[]{"asdf","adf"};
//        for(Method obj: test2s){
//            if (obj.getName().equals("say8")){
//                Object invoke = obj.invoke(o1,objects); //应该是用foreach构建的
//                System.out.println(invoke);
//            }
//        }
    }

    public static void jake() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Object o1 = Class.forName("com.y.Test2").newInstance();
        Method[] test2s = Class.forName("com.y.Test2").getMethods();
        String[] str = {"youzs","sfasdf","sdfa","safd"};
        Object[] objects = new Object[1];
        objects[0] = str;
        for(Method obj: test2s){
            if (obj.getName().equals("say5")){
                Object invoke = obj.invoke(o1,objects); //应该是用foreach构建的
                System.out.println(":"+invoke);
            }
        }
    }

    public static void main2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
//        NettyBridge wide = new NettyHandlerWide();
//       wide.injectSC(ServerStrInHandler.class, null).serverStart();


        Object o1 = Class.forName("com.y.Test2").newInstance();
        Method[] test2s = Class.forName("com.y.Test2").getMethods();
        String[] str = {"youzs","sfasdf","sdfa","safd"};
        String[] str2 = {"youzs"};
        String[] array = new String[]{};
        int[] ints;
        Integer[] integers;

        String string = "w23";
        Object[] objs = {str,str};
        Object[] objects =
//                new Object[3000000];
                {};
//        for (int i = 0; i < 1000000; i++) {
//            objects[i] = "123";
//        }
//        for (int i = 0; i < 1000000; i++) {
//            objects[i+1000000] = str;
//        }
//
//        for (int i = 0; i < 1000000; i++) {
//            objects[i+2000000] = str2;
//        }


        int i = 23;

        StringBuilder builder =
                new StringBuilder();
        for (Object object : objects) {
            String s = resolveParType(object);
            builder.append(s).append(",");
        }

        builder.delete(builder.length()-1,builder.length());
        System.out.println(builder.toString());
        String string1 = builder.toString();

//        System.out.println(string1);
        Object[] objects1 = resolveParStr(string1);




        for(Method obj: test2s){
            if (obj.getName().equals("say4")){
                Object invoke = obj.invoke(o1,objects1); //应该是用foreach构建的
                System.out.println(":"+invoke);
            }
        }

    }

    public static String resolveArr2Str(Object...obj){
        StringBuilder builder = new StringBuilder();
        for (Object object : obj) {
            String s = resolveParType(object);
            builder.append(s).append(",");
        }
        builder.delete(builder.length()-1,builder.length());
        return builder.toString();
    }

    private static String resolveParType(Object object){
        String sub = null;
        if (object instanceof String){
            sub = (String) object;
        }else if (object instanceof String[]){
            sub = Arrays.toString((String[]) object);
        }
        return sub;
    }

    private static String[] resolveStr2Arr(String substring){
        List<Object> tempStr = new ArrayList<Object>();
        for (int i = 0,j=0; i < substring.length() ; i++) {
            if (substring.charAt(i) == ','  ){
                tempStr.add(substring.substring(j,i).trim());
                j = i+1;
            }
            if ((i+1) == substring.length()){
                tempStr.add(substring.substring(j,i+1).trim());
            }
        }
        String[] objs = new String[tempStr.size()];
        for (int i = 0; i < tempStr.size(); i++) {
            objs[i] = (String) tempStr.get(i);
        }
        return objs;
    }


    private static Object[] resolveParStr(String string){
        Object[] objects = new Object[1];
        List<Object> temp = new ArrayList<>();
        long start =  System.currentTimeMillis() ;
        if (string.isEmpty()){  //为空
            System.out.println("string为空");
            return objects;
        }else if (string.contains(",")){  //说明至少有2个
            string = string+',';//在末尾加一个标识符','便于处理
            for (int i = 1,j=0,f = 0; i < string.length(); i++) {
                if (string.charAt(i) == ',' ||  string.charAt(i) == '[' || string.charAt(i) == ']' ) {
                    if (string.charAt(i) == ',' && f == 0 && i > j) {
                        temp.add(string.substring(j, i));
                        j = i + 1;
                    }else {
                        if (string.charAt(i) == '[') {
                            f = 1;
                            j = i + 1;
                        } else if (string.charAt(i) == ']') {
                            String substring = string.substring(j, i);
                            String[] strings = resolveStr2Arr(substring);
                            temp.add(strings);
                            j = i + 2;
                            f = 0;
                        }
                    }
                }
            }
            Object[] objs = new Object[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                objs[i] = temp.get(i);
            }
            objects = objs;
        }else {  //只有一个
            if (string.charAt(0) == '['){
                objects[0] = resolveStr2Arr(string);
            }else {
                objects[0] = string;
            }
        }
        long end =  System.currentTimeMillis() ;
        System.out.println(end - start);
        return objects;
    }

    void print(){
        Method[] methods = Test2.class.getMethods();
        for (Method method: methods){
            Class<?>[] parameterTypes = method.getParameterTypes();
            for(Class obj: parameterTypes){
                System.out.println(obj);
            }
        }

    }


}
