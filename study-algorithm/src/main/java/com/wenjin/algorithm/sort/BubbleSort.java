package com.wenjin.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    @Test
    public void testBubbleSort() {

        int[] data = {5, 7, 4, 3, 6, 8, 2, 1, 9};
//        sort(data);
        bubbleSort(data);
    }


    public void bubbleSort(int[] data) {
        int temp = -1;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(data));
    }

    public void sort(int[] data) {
        int temp;
        boolean swap = false;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    swap = true;
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }

            if (!swap) {
                // 一次都没有交换则直接退出
                break;
            } else {
                swap = false;
            }
        }

        System.out.println("sorted data: " + Arrays.toString(data));
    }
}
