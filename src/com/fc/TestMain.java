package com.fc;

import com.fc.entity.ListNode;

public class TestMain {
    public static void main(String[] args) {
        //测试能否交换数值
        //SortAlgorithm.QuickSwap(new int[]{1, 2, 3, 4, 5},1,2);
        //测试选择排序能否使用
        //SortAlgorithm.selectionSort(new int[]{3, 4, 2, 3, 1});
        //Solution.findNumberIn2DArray(new int[][]{},0);
        //System.out.println(Solution.replaceSpace("     "));
        //System.out.println(Solution.fib(3));
        //System.out.println(Solution.numWays(100));
//        System.out.println(Solution2.cuttingRope(10));
//        int n = 2;
//        System.out.println(n &= n -1);
//        System.out.println(Solution2.hammingWeight(11));

        System.out.println(Solution2.isMatch("aab", "c*a*b"));
    }
}
