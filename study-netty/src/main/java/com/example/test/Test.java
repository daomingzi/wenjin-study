package com.example.test;


import com.example.common.ListNode;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        int count = 0;
//        int num = 0;
//        for (int i = 0; i <= 100; i++) {
//            num = num + i;
//            count = count++;
//        }
//        System.out.println(count);
//        System.out.println(num);
//        double d1 = -0.5;
//        System.out.println("------");
//        System.out.println(Math.ceil(d1));
//        System.out.println(Math.floor(d1));

        hasCycle();
    }

    public static void hasCycle() {


        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        int i = 0;
        while (i != intArray.length ) {
            System.out.println(intArray[i]);
            i++;
        }

    }
}
