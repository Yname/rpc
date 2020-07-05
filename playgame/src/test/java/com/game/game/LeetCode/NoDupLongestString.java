package com.game.game.LeetCode;

import java.util.*;

public class NoDupLongestString {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//          HashSet 会对元素进行从小到大的排序
//          LinkedHashSet 是对元素自然顺序（即放入时的顺序）排序
        Set set = new LinkedHashSet();
        Set tempSet = new LinkedHashSet();
        String arrays = "abccbcbafjklohkfajdsfhaslfjdlaskjfkljalfdjlsajfdslksjfklkdjsalfjlkasjflashsfadshfdhsadjhfjhjhjhjuuuiuiuiooadlfalioqerfvnamajwfm";
        char[] chars = arrays.toCharArray();
        for (int i = 0; i < chars.length; i++) {
//          如果加入了重复的值 则会false，如果在末尾  且新的set列比旧的长则放入tempSet
            boolean add = set.add(chars[i]);
            if ((!add || i == chars.length-1 ) && set.size() > tempSet.size()){
                tempSet.clear();
                tempSet.addAll(set);
                set.clear();
            }
        }
        System.out.println(Arrays.toString(tempSet.toArray()));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
