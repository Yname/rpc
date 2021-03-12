package com.y;

import com.rpc.myrpc.utils.ClassLoad;
import test.TestClazz;
import test.TestObj;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Test2 implements TestClazz, Serializable {

    public static void main(String[] args) throws ParseException {
//        TestClazz clazz = new com.y.Test2();
//        TestClazz o = (TestClazz) ClassLoad.loadClass(com.y.Test2.class);
//        TestClazz test2 = (TestClazz) ClassLoad.loadClass("com.y.Test2");
//
//        System.out.println(clazz == o);
//        System.out.println(clazz == test2);
//        System.out.println(o == test2);
//        clazz.say3();
//        o.say3();
//        test2.say3();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(new Date()));
        System.out.println(sdf.parse(sdf.format(new Date())));
    }

    private static final long serialVersionUID = -5973855401421608260L;

    public void say(String name) {
        System.out.println(name+"===]]]");
    }

    public String say2(String name) {
        return name+"热爱生活！";
    }


    public String say5(String...name) {

        for(String obj: name){
             if (obj.equals("youzs")){
                 return "OK";
             }
        }
        return "Not";
    }

    public String say7(String str1,String str2,String str3) {
        return str1+str2+str3;
    }

    public void say8(String str1,String...str2) {

        if (str1.equals("youzs")){
            for(String obj: str2){
                if (obj != null){
                    System.out.println(obj);
                }
            }
        }

    }

    public String say6(String...name) {
        StringBuilder str = new StringBuilder();
        for(String obj: name){
            str.append(obj).append("世界！");
        }
        return str.toString();
    }

    public TestObj say3() {
        return new AA();
    }

    public void say4() {
        System.out.println("say4+000");
    }

    class AA implements TestObj{
        AA(){
            System.out.println("AAAAAA]]]]]]]");
        }
    }
}
