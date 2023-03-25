package com.fc;

import com.fc.entity.ListNode;
import com.fc.entity.TreeNode;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int m,n,k;
    public boolean[][] visited;
    /**
     * 机器人的远动范围
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k){
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];

        return dfss(0, 0, 0, 0);
    }
    public int dfss(int i, int j, int si,int sj){
        if (i >= m || j >= n || k < si + sj || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        // 像右移动一个格子(i + 1, j), 看看能不能被10整除,不能则si + 1,可以整除则si - 8([9,0]->[10,0])总数计算9->1所以减8,sj因为j坐标没发生变化 所以值不变,同理向下移动
        return 1 + dfss(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj)
                + dfss(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj -8);
    }

    /**
     * 矩阵中的路径
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word){
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != words[k]) {
            return false;
        }
        if (k == words.length - 1){
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, words, i + 1, j,k + 1) || dfs(board, words, i - 1, j,k + 1)||
                      dfs(board, words, i, j + 1,k + 1) || dfs(board, words, i, j - 1,k + 1);
        board[i][j] = words[k];
        return res;
    }

    /**
     * 旋转数组的最小数字
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers){
//        if(numbers.length == 0){
//            return 0;
//        }
//        if(numbers.length == 1){
//            return numbers[0];
//        }
//
//        if(numbers[0] >= numbers[numbers.length - 1]){
//            for (int i = numbers.length - 1; i >0 ; i--) {
//                if(numbers[i] < numbers[i- 1]){
//                    return numbers[i];
//                }
//            }
//        }
//        return numbers[0];

        int i = 0, j = numbers.length - 1;
        while(i < j){
            int m = (i + j) / 2;
            if(numbers[m] > numbers[j]) {
                i = m + 1;
            } else if (numbers[m] < numbers[j]) {
                j = m;
            } else {
                j--;
            }
        }
        return numbers[i];

    }

    /**
     * 青蛙跳台阶问题
     * @param n
     * @return
     */
    public static int numWays(int n){
        if(n < 3){
            if(n == 0){
                return 1;
            }else{
                return n;
            }
        }
        int a = 1;
        int b = 2;
        for (int i = 2; i < n; i++) {
            int sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return b;
    }
    /**
     * 斐波那契数列
     * @param n
     * @return
     */
    public static int fib(int n){
        if(n == 0){
            return 0;
        }
        if(n < 3){
            return 1;
        }

        int a = 1;
        int b = 2;
        for (int i = 3; i < n; i++) {
            int sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }

        return b;
    }
    /**
     *重建二叉树
     *Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     *             3
     *         9        20
     *                15   7
     *Output: [3,9,20,null,null,15,7]
     * 3
     * 中序
     * l:9   r:15,20,7
     * 分别判断 9
     * 右边  20为根节点
     * l:15   r:7
     * @param preorder  前序
     * @param inorder   中序
     * @return
     */
     int[] preorder;
     HashMap<Integer, Integer> dic = new HashMap<>();
     public TreeNode buildTree(int[] preorder, int[] inorder){
        this.preorder = preorder;
        if (preorder.length == 1 && inorder.length == 1){
            return new TreeNode(preorder[0]);
        }
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i],i);
        }
        return recu(0,0,inorder.length-1);
     }
    // 0 0 4
    //
    public TreeNode recu(int head, int l, int r){
        if (l > r){
            return null;
        }
        TreeNode node = new TreeNode(preorder[head]);
        int i = dic.get(preorder[head]);
        node.left = recu(head + 1,l,i - 1);
        node.right = recu(head + i -l + 1,i + 1, r);
        return node;
    }

    /**
     * 从头到尾打印链表
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head){
        ListNode temp = head;
        int size = 0;
        while(temp  != null){
            temp = temp.next;
            size++;
        }
        temp = head;
        int[] ints = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ints[i] = temp.val;
            temp = temp.next;
        }

        return ints;
    }
    /**
     * 替换空格
     * @param s
     * @return
     */
    public static String replaceSpace(String s){
        if(s == null){
            return "";
        }
        char[] ss = s.toCharArray();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == ' '){
                sb.append("%20");
            }else{
                sb.append(ss[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 二维数组查找
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target){
        if (matrix.length == 0){
            return false;
        }
        if (matrix.length == 0 || matrix[0].length ==0){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = rows - 1,j = 0;
        while(i >= 0 && j < cols){
            if (matrix[i][j] < target){
                j++;
            }else if (matrix[i][j] > target){
                i--;
            }else {
                return true;
            }
        }
        return false;
    }

    /**
     * 数组中重复数字
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums){
        Map<Integer,Integer> newNums = new HashMap<Integer,Integer>();
        for (int num : nums) {
            if(newNums.get(num) == null){
                newNums.put(num,1);
            }else {
                int value = newNums.get(num).intValue();
                newNums.put(num, ++ value);
            }
        }
        int resultValue = -1;
        Set<Integer> values = newNums.keySet();
        for (Object value : values) {
            if(newNums.get(value) > 1) {
                resultValue = (Integer) value;
                break;
            }
        }

        return resultValue;
    }
}
