package com.fc;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 排序算法
 * @author fanchen
 */
public class SortAlgorithm {
    /**
     * 快速排序算法
     * @param arr
     */
    public int[] quickSort(int[] arr){
         int[] newArr = Arrays.copyOf(arr, arr.length);

         return quickSortOper(newArr, 0, arr.length - 1);
    }

    private int[] quickSortOper(int[] arr, int left, int right) {
        if(left < right){
            int partitionIndex = partition(arr, left, right);
            quickSortOper(arr, left, partitionIndex - 1);
            quickSortOper(arr, partitionIndex + 1, right);
        }
        return arr;
    }
    //5  7  8   9  10  23  16
    //pivot = 5
    //index = 7
    //

    //设定基准值(pivot)
    private int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right ; i++) {
            if (arr[i] < arr[pivot]){
                swap(arr , i, index);
                index ++;
            }
        }
        swap(arr, pivot, index - 1 );
        return index - 1;
    }

    /**
     * 冒泡排序算法
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < 1; j++) {
                
            }
        }

    }

    /**
     * 选择排序算法
     * @param arr
     */
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        //0 ~ N-1
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            //i ~ N-1 找最小值的下标
            for (int j = i; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]){
                   minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 常用交换数值方法
     * @param arr           数组
     * @param i             第一个数的坐标,也可以是左数的坐标
     * @param j             第二个数的坐标,也可以是右数的坐标
     */
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 高效的交换运算(但只适用于数值类型)
     * @param arr           数组
     * @param i             第一个数的坐标
     * @param j             第二个数的坐标
     */
    public static void QuickSwap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
