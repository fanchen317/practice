package com.fc.sortsolution;

import java.util.Arrays;

/**
 * @author fanchen
 */
public class SelectionSortSolution {
    public int[] selectionSort(int[] arr){
        int[] newArr = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < newArr.length - 1; i++) {
            for (int j = i; j < newArr.length; j++) {
                if (newArr[i] > newArr[j]){
                    swap(newArr, i, j);
                }
            }
        }
        return newArr;
    }
    private void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
