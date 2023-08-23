package com.wenjin.algorithm.sort;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序
 */
public class MergerSort {

    @Test
    public void testMergerSort() {
        Random random = new Random();

//        int[] data = {5, 7, 4, 3, 6, 8, 2, 1, 9};

        int[] data = new int[10000];
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt();
        }
//        System.out.println("排序前: " + Arrays.toString(data));

        int[] temp = new int[data.length];
        long start = System.currentTimeMillis();
        mergeSort(data, 0, data.length - 1, temp);
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start));
//        System.out.println("排序后: " + Arrays.toString(data));

//        System.out.println(Arrays.toString(data));

    }


    /**
     * 分 + 合
     */
    public void mergeSort(int[] arr, int left, int right, int[] temp) {

//        System.out.println("left: " + left +"right: " + right);
        // 知道left == right不能分为止
        if (left < right) {
            // 每次计算中间位置
            int middle = (left + right) / 2;

            // 像左递归分解
            mergeSort(arr, left, middle, temp);
            // 像右递归分解
            mergeSort(arr, middle + 1, right, temp);

            merge(arr, left, middle, right, temp);
        }
    }

    /**
     * 合并
     */
    public void merge(int[] arr, int left, int middle, int right, int[] temp) {

//        System.out.println("left: " + left +"right: " + right);
        int i = left;   // 左边有序序列的初始索引
        int j = middle + 1;     //右边有序序列的初始索引
        int t = 0; //temp数组的当前索引

        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }

        // 左边还有未比较的数据
        while (i <= middle) {

            temp[t] = arr[i];
            t++;
            i++;

        }
        // 右边还有未比较的数据
        while (j <= right) {

            temp[t] = arr[j];
            t++;
            j++;

        }

        // 将temp数据拷贝到原数组arr
        // 注意, 将temp中的数据拷贝到arr指定位置
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
