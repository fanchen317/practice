package com.fc.sortsolution;

import java.util.Arrays;

/**
 * @author fanchen
 */
public class QuickSortSolution {
    /**
     * 复制数组,开始进行快速排序操作
     * @param arr
     * @return
     */
    public int[] quickSort(int[] arr){
        int[] newArr = Arrays.copyOf(arr, arr.length);
        return quickSortOper(newArr, 0, arr.length - 1);
    }

    /**
     * 递归进行分层后的元素排序
     * partitionIndex左边的为小于基准的值
     * partitionIndex右边的为大于基准的值
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int[] quickSortOper(int[] arr, int left, int right) {
        if(left < right){
            int partitionIndex = partition(arr, left, right);
            quickSortOper(arr, left, partitionIndex - 1);
            quickSortOper(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    /**
     * 进行分层操作,
     * 循环过后index左边元素为小于基准数值,
     * 右边元素大于基准数值,然后交换基准数值和index - 1 的值,
     * 并返回partition分层点
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right ; i++) {
            if (arr[i] < arr[pivot]){
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    /**
     * 交换两个index的值
     * @param arr
     * @param i
     * @param j
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
