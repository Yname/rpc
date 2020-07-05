package com.game.game;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(split("a a ddd bbb"));
    }

    public static List<String> split(String txt){

        List<String> list = new ArrayList<>();
        int j = 0;
//        String[] split = txt.split("\t", -1);
//        String[] strings = txt.split(" ");
        int i = 0,len = txt.length();
        while (i < len ){
           char C =txt.charAt(i);
           list.add(String.valueOf(C));
           i++;
           while (i < len && txt.charAt(i) == C){
               i++;
           }
       }
//       int j = 0,len2 = list.size();
//       while ( j < len2){
//
//        }

//        list.size();
        while ( j < list.size()){
            if (list.get(j).contains(" ")){
                list.remove(j);
            }
            j++;
        }



       return list;
    }
}
