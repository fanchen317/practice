package com.fc;

import com.fc.entity.ListNode;
import com.fc.entity.TreeNode;

import java.util.*;

public class Solution2 {
    /**
     * 剪绳子
     * @param n
     * @return
     */
    public static int cuttingRope(int n){//n=10
        //当n=2或n=3的时候 最大值都是1*1 或1*1*1
        if(n <= 3){
            return  n-1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        //len = 4  len<=10 len++ 从4开始计算
        for (int len = 4; len <= n ; len++) {
            //因为减掉1意义不是很大(1乘任何数都得1) 所以需要从2减
            for (int k = 2; k < len - 1; k++) {

                dp[len] = Math.max(dp[len], dp[k] * dp[len-k]);
            }
        }
        return dp[n];
    }

    /**
     * 二进制中1的个数
     * @param n
     * @return
     */
    public static int hammingWeight(int n){
        int count = 0;
        while(n != 0){
            n &= n -1;
            count++;
        }
        return count;
    }

    /**
     * 数值的整数次方
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n){
        if (x == 0 ){
            return 0;
        }
        long b = n;
        double res = 1.0;
        if (b < 0){
            x = 1 / x;
            b = -b;
        }
        while (b > 0){
            if ((b & 1) == 1){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

    /**
     * 打印从1到最大的n位数
     * @param n
     * @return
     */
    public static int[] printNumbers(int n){
        int end = (int) (Math.pow(10, n) - 1);
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    /**
     * 删除链表的节点
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val){
        if (head.val == val){
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null && cur.val != val){
            pre = cur;
            cur = cur.next;
        }
        if (cur != null){
            pre.next = cur.next;
        }
        return head;
    }

    /**
     * 正则表达式匹配
     * @param A
     * @param B
     * @return
     */
    public static boolean isMatch(String A, String B){
        //获取A 和 B字符长度
        int n = A.length();
        int m = B.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <= m; j++){
                //分成空正则和非空正则两种
                if (j == 0){
                    f[i][j] = i ==0;
                }else {
                    //非空正则分为两种情况 * 和 非*
                    if (B.charAt(j - 1) != '*'){
                        if(i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')){
                            f[i][j] = f[i - 1][j - 1];
                        }
                    }else {
                        //碰到 * 了,分为看和不看两种情况
                        //不看
                        if (j >= 2){
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')){
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }

    /**
     * 表示数值的字符串
     * @param s
     * @return
     */
    public static boolean isNumber(String s){
        if (s == null || s.length() == 0){
            return false;
        }
        s = s.trim();
        try{
            double a = Double.parseDouble(s);
        }catch(Exception e){
            return false;
        }
        char c = s.charAt(s.length() - 1);
        return (c >= '0' && c <= '9') || c == '.';
    }

    /**
     * 调整数组顺序使奇数位于偶数前面
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums){
        int[] arr = new int[nums.length];
        int index = 0;
        List<Integer> even = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1){
                arr[index++] = nums[i];
            }else if (nums[i] % 2 == 0){
                even.add(i);
            }
        }
        for (Integer i : even) {
            arr[index++] = nums[i];
        }
        return arr;
    }

}
