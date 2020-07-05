package com.game.game.LeetCode;

import java.util.*;

public class TestTwo {

    public static void main(String[] args) {
        int[] time = {1,5,8,11,16,17,29,34,39};
        int[] timeLine = {3,7,12,17,19,31,40};
        Map tempMap = new HashMap();
        int tempNum = -1;
//        time里的值  只允许用一次
        for (int i = 0; i < time.length; i++) {
            for (int j = 0; j < timeLine.length; j++) {
//                判断是否相等
                if (time[i] == timeLine[j]){
                    j++;
                }
//                获取相差绝对值
                int abs = Math.abs(timeLine[j] - time[i]);
                if (abs <= tempNum || j == 0){
                    tempNum = abs;
                    tempMap.remove(time[i]);
                    tempMap.put(time[i],timeLine[j]);
                }
            }
            System.out.println("line==>"+tempMap.get(time[i]) +" time==>" + time[i]);
        }
        System.out.println(tempMap.keySet());
        System.out.println(tempMap.values());
    }
}
