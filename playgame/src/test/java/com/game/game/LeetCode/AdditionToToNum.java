package com.game.game.LeetCode;

import java.util.LinkedList;
import java.util.List;

public class AdditionToToNum {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        List list = new LinkedList();
        int num1 = 2359;
        int num2 = 2766;
//        splitInter函数是切割整数，将整数变成字符放入节点
        List<Character> characters1 = splitInter(num1);
        List<Character> characters2 = splitInter(num2);
//        计算2个整数的长度差  的绝对值
        int size = characters1.size() - characters2.size();
        int abs = Math.abs(size);

        int i;
//        如果第一哥整数较长
        if (size >= 0){
            i = characters1.size();
            for (int j = 0; j < abs; j++) {
                characters2.add((char) 48);
            }
        }else {  //第二个整数较长
            i = characters2.size();
            for (int j = 0; j < abs; j++) {
                characters1.add((char) 48);
            }
        }


        int carryPost = 0;
//        使用的进位符，如果相加大于等于10，则进位填 1 ，反之 0
        int one = 0;
        for (int j = 0; i > 0; i--){
//            carryDevice计算添位的方法
            carryPost = carryDevice(characters1.get(j), characters2.get(j), one);
//            切割结果，如果结果大于等于10，表示需要进位
            List<Character> characters = splitInter(carryPost);
//            只加第0位，即个位
            list.add(characters.get(0));
            if (carryPost >= 10) {
                one = 1;
            }
            else one = 0;
            j++;
        }
//      输出相加的值，逆序
        System.out.println(list.toString());


        long end = System.currentTimeMillis();
        System.out.println(end - start);


    }

    public static int carryDevice(Character ch1,Character ch2,int one){
        return ch1 + ch2 - 96 + one;
    }

//
    public static List<Character> splitInter(int num){
        List list = new LinkedList();
//        将数字转化成字符串  ，再转化为char数组， 再放入节点
        String num11 = String.valueOf(num);
        char[] chars = num11.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            list.add(chars[i]);
        }
        return list;
    }
}
