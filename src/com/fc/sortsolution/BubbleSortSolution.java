package com.fc.sortsolution;

import java.util.Arrays;

/**
 * @author fanchen
 */
public class BubbleSortSolution {
    public int[] bubbleSort(int[] arr){
        int[] newArr = Arrays.copyOf(arr, arr.length);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (newArr[j] > newArr[j + 1]){
                    swap(newArr, j, j + 1);
                }
            }
        }
        return newArr;
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
