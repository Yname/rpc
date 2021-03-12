package com.rpc.myrpc.utils;

import java.util.*;

public class StringUtils {

    /**
     *  将String数组或String  转为String
     * @param object 任意类型  @注意：目前只支持 String 和 String[]
     * @return sub
     */
    public static String resolveParType(Object object){
        String sub = null;
        if (object instanceof String){
            sub = (String) object;
        }else if (object instanceof String[]){
            sub = Arrays.toString((String[]) object);
        }
        return sub;
    }

    /**
     * 将object[]转化为String，注意object[]中只能存放 String类型和String[]
     * @param obj
     * @return
     */
    public static String resolveArr2Str(Object...obj){
        StringBuilder builder = new StringBuilder();
        for (Object object : obj) {
            String s = resolveParType(object);
            builder.append(s).append(",");
        }
        builder.delete(builder.length()-1,builder.length());
        return builder.toString();
    }

    /**
     *  将一个 "str1,str2,str3" 类型的字符串转化为数组
     * @param substring 将String类型转化为String数组，格式类型为: "str1,str2,str3"
     * @return strs 返回String[]
     */
    public static String[] resolveStr2Arr(String substring){
        List<Object> tempStr = new ArrayList<>();
        for (int i = 0,j=0; i < substring.length() ; i++) {
            if (substring.charAt(i) == ','){
                tempStr.add(substring.substring(j,i).trim());
                j = i+1;
            }
            if ((i+1) == substring.length()){
                tempStr.add(substring.substring(j,i+1).trim());
            }
        }
        String[] strs = new String[tempStr.size()];
        for (int i = 0; i < tempStr.size(); i++) {
            strs[i] = (String) tempStr.get(i);
        }
        return strs;
    }

    /**
     * 生成简单的类名，方法名的序列字符串
     * @param parentName
     * @return
     */
    public static StringBuilder strGenerator(String parentName){
        byte[] bytes = parentName.getBytes();
        StringBuilder builder = new StringBuilder();
        for(byte obj: bytes){
            if (obj == 46){
                builder.append(obj);
            }else if ( 47 < obj && obj < 58){
                builder.append(obj);
            }else if (64 < obj && obj <91){
                builder.append(obj);
            } else if (obj == 95){
                builder.append(obj);
            }else {
                obj -= 87;
                builder.append(obj);
            }
        }
        return builder;
    }


    /**
     * 将一个 "obj1,obj2,obj3" 类型的字符串转化为数组
     * @param string  "123,[123,123,123],123,123
     * @return
     */
    public static Object[] resolveParStr(String string){
        List<Object> temp = new ArrayList<>();
        long start =  System.currentTimeMillis() ;
        if (string.isEmpty()){  //为空
            System.out.println("string为空");
            return new Object[0];
        }else if (string.contains(",") && !string.contains("&")){  //说明至少有2个
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
            long end =  System.currentTimeMillis() ;
            System.out.println(end - start);
            return objs;
        }else {  //只有一个
//            objects = resolveStr2Arr(string.substring(1));
            if (string.contains("&&")){
                Object[] objects = new Object[1];
                long end =  System.currentTimeMillis() ;
                System.out.println(end - start);
                objects[0] = string.substring(2);
                return objects ;
            }else {
                Object[] objects = new Object[1];
                long end =  System.currentTimeMillis() ;
                System.out.println(end - start);
                objects[0] = resolveStr2Arr(string.substring(1));
                return objects ;
            }

        }
    }

    /**
     * @param str 一个com.y.Test::say2&123,123,[123,123]类型的字符串  :: 和 & 均是隔离符号，
     *           类路径名 :: 方法名 & 参数
     * @return map
     */
    public static Map<String,Object> resolveStr(String str) {
        Map<String,Object> map = new HashMap<>();
        String clazzStr;
        String methodStr;
        String paramsStr;
        paramsStr = str.substring(str.indexOf("&")+1);
        String tempStr = str.substring(0,str.indexOf("&"));
        clazzStr = tempStr.substring(0,str.lastIndexOf("::"));
        methodStr = tempStr.substring(str.lastIndexOf("::")+2);

        if (clazzStr.equals("") && methodStr.equals("")){
            return null;
        }

        map.put("methodStr",methodStr);
        map.put("clazzStr",clazzStr);
        map.put("paramsStr",paramsStr);
        return map;
    }


}
