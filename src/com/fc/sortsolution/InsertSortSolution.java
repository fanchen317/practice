package com.fc.sortsolution;

import java.util.Arrays;

/**
 * @author fanchen
 */
public class InsertSortSolution {
    public int[] insertSort(int[] arr){
        int[] newArr = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < newArr.length; i++) {
            int temp = newArr[i];
            for (int j = 1; j < newArr.length - 1; j++) {
                if (temp > newArr[j]){
                    int tmp = temp;

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
