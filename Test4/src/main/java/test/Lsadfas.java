package test;

import java.sql.SQLOutput;
import java.util.*;

public class Lsadfas {
    public static void main(String[] args) throws InterruptedException {

//        test();
//        nnnn();
        List<String> list = new ArrayList();
        Iterator iterator = list.iterator();

        if (iterator.hasNext()){
            iterator.next();
        }

        for(String obj: list){
                obj.equals("1");
        }


    }

    static void nnnn(){
        double[] dd = {0.7,0.75,0.85,0.95,1.05,1.15,1.25,1.35,0.8,0.9,1.1,1.3,1.5,1.7,1.9,2.1,2.3,2.5,2.7,1.5,1.65,1.95,2.25,2.55,2.85,3.15,3.45,3.75,4.05,4.35,2,2.2,2.6,3,3.4,3.8,4.2,4.6,5,5.4,5.8,2.8,2.9,3.1,3.3,3.5,3.7,3.9,4.1,4.3,4.6,5,5.4,5.8,6.2,3.3,3.4,3.6,3.8,4,4.2,4.4,4.6,4.8,5,5.2,5.4,5.6,5.8,6,6,6.25,6.75,7.25,7.75,8.25,6,6.75,8.25,9.75,11.25,13.5};
        System.out.println(dd[dd.length-1]);
    }

    static void test(){
        String[] str = {"sdf","asdf"};
        System.out.println(Arrays.toString(str));
    }

     static void print(String name){

         Object[] objects = {"123",new String[]{"123","wer"},"123"};
         String string = Arrays.toString(objects);
         System.out.println(string);
         if (string.equals("[]")){  //为空
             System.out.println("string为空");
         }else if (string.contains(",")){  //说明至少有2个
             List<Integer> list = new ArrayList<Integer>();
             list.add(1);
             List<Object> temp = new ArrayList<Object>();
             char[] chars = string.toCharArray();
             for (int i = 0; i < chars.length && chars.length > 2; i++) { //不为空
                 if ( (chars[i] == ',' && chars[i+1] == ' '))
                     list.add(i+1);
             }
             list.add(chars.length);
             System.out.println(list.toString());
             for (int i = 1; i < list.size(); i++) {
                 temp.add(string.substring(list.get(i-1),list.get(i)-1).trim());
             }
             System.out.println(Arrays.toString(temp.toArray()));
         }else {  //只有一个
             String substring = string.substring(string.indexOf("[")+1, string.indexOf("]"));
             System.out.println(substring);
         }
    }
}
