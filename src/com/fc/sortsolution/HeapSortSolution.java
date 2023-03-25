package com.fc.sortsolution;

import java.util.Arrays;

/**
 * @author fanchen
 */
public class HeapSortSolution {
    /**
     * 堆排序
     * 升序用大根堆       大根堆定义:arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
     * 降序用小根堆       小根堆定义:arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
     * @param arr
     * @return
     */
    public int[] heapSort(int[] arr){
        int[] newArr = Arrays.copyOf(arr, arr.length);

        int len = newArr.length;

        buildMaxHeap(newArr, len);

        for (int i = len - 1; i > 0 ; i--) {
            swap(newArr, 0, i);
            len--;
            heapify(newArr, 0, len);
        }
        return newArr;
    }

    private void buildMaxHeap(int[] arr, int len){
        for (int i = (int) Math.floor(len / 2); i >= 0 ; i--) {
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len){
        //左叶子节点
        int left = 2 * i + 1;
        //右叶子节点
        int right = 2 * i + 2;
        int largest = i;

        if(left < len && arr[left] > arr[largest]){
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]){
            largest = right;
        }

        if (largest != i){
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
