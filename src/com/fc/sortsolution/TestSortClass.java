package com.fc.sortsolution;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author fanchen
 */
public class TestSortClass {
    public static void main(String[] args){
        QuickSortSolution quickSortSolution = new QuickSortSolution();
        int[] arr = {2, 6, 4, 7, 1, 7, 8, 0, 10};
        System.out.println("-----------------------------------");
        System.out.println("快速排序结果:");
        int[] newQuickSortArr = quickSortSolution.quickSort(arr);
        for (int i : newQuickSortArr) {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        BubbleSortSolution bubbleSortSolution = new BubbleSortSolution();
        System.out.println("-----------------------------------");
        System.out.println("冒泡排序结果:");
        int[] newBubbleSortArr = bubbleSortSolution.bubbleSort(arr);
        for (int i : newBubbleSortArr) {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        SelectionSortSolution selectionSortSolution = new SelectionSortSolution();
        System.out.println("-----------------------------------");
        System.out.println("冒泡排序结果:");
        int[] newSelectionSortArr = selectionSortSolution.selectionSort(arr);
        for (int i : newSelectionSortArr) {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        HeapSortSolution heapSortSolution = new HeapSortSolution();
        System.out.println("-----------------------------------");
        System.out.println("堆排序结果:");
        int[] newHeapSortArr = heapSortSolution.heapSort(arr);
        for (int i : newHeapSortArr) {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        MergeSortSolution mergeSortSolution = new MergeSortSolution();
        System.out.println("-----------------------------------");
        System.out.println("归并排序结果:");
        int[] newmergeSortArr = mergeSortSolution.mergeSort(arr);
        for (int i : newmergeSortArr) {
            System.out.print(i + " ");
        }
        System.out.println(" ");


    }

}
