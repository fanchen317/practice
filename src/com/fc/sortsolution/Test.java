package com.fc.sortsolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public int[] quickSort(int[] targetArr) {
        int[] arr = Arrays.copyOf(targetArr, targetArr.length);
        return quickSortOper(arr, 0, arr.length - 1);
    }

    private int[] quickSortOper(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partiton(arr, left, right);
            quickSortOper(arr, left, partitionIndex - 1);
            quickSortOper(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partiton(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[pivot] > arr[i]) {
                swap(arr, index, i);
                index++;
            }
        }
        swap(arr, index - 1, pivot);
        return index - 1;
    }

    public int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] < right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }

    public int[] heapSort(int[] targetArr) {
        int[] arr = Arrays.copyOf(targetArr, targetArr.length);
        int len = arr.length;

        buildMaxHeap(arr, len);
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    private void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, largest, len);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
//        arr[i] = arr[i] + arr[j];
//        arr[j] = arr[i] - arr[j];
//        arr[i] = arr[i] - arr[j];
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        Test test = new Test();
        int[] arr = {4, 6, 8, 5, 9, 2, 3, 1, 6, 7, 11, 20};

        int[] quickSortArr = test.quickSort(arr);
        for (int i : quickSortArr) {
            System.out.print(i + " ");
        }
        System.out.println("");

        int[] mergeSortArr = test.mergeSort(arr);
        for (int i : mergeSortArr) {
            System.out.print(i + " ");
        }
        System.out.println("");

        int[] heapSortArr = test.heapSort(arr);
        for (int i : heapSortArr) {
            System.out.print(i + " ");
        }

        System.out.println("");

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == "2") {
                list.remove("2");
            }
            System.out.println(list.get(i));
        }

    }


}
