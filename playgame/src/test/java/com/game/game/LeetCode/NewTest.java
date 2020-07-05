package com.game.game.LeetCode;

import java.util.*;

public class NewTest {


    public static void main(String[] args) {
        Integer[] nums = {3,4,5,6,7,6,8};
        Integer target = 11;
//        Scanner scanner = new Scanner(System.in);
//        String next = scanner.next();
        Map<Integer,Integer> map = new HashMap<>();
        int i = 0;
//        int j = 0;
//        if(target / 2 == 0){
//            target
//        }

        while (i < target){
            if (i == target){
                    return ;
            }
            i++;
            --target;
            map.put(target,i);
            System.out.println(target);
            System.out.println(map.get(target));
//            j++;
        }
        System.out.println("===========");
        System.out.println(target);
        System.out.println(i);
//        i >= target
//        int j = 0;
        for (int k = 0; k < nums.length ; k++) {

            int ii = i ;
            int iitar = target ;

            while (ii >= 0){

                if (nums[k].equals(ii)){
                    map.put(iitar, -(k+1));
                    System.out.println("++++++++++"+iitar+"++++"+k);
                }
                if (nums[k].equals(iitar)){
                    map.put(-(k+1),map.get(iitar));
                    System.out.println("++++++++++"+map.get(iitar)+"++++"+k);
                }
               ii--;iitar++;
            }

        }

        Set<Integer> integers = map.keySet();
        for (Integer list : integers
             ) {
            if (list < 0){
                if (map.get(list) < 0){
                    Integer integer = map.get(list);
                    list = -list-1;
                    integer = -integer-1;
                    System.out.println(list+","+integer);
                }
            }
        }


    }


}
