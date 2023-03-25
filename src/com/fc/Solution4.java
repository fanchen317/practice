package com.fc;

import com.fc.entity.ListNode;
import com.fc.entity.Node;
import com.fc.entity.TreeNode;

import java.util.*;

public class Solution4 {
    /**
     * 复杂链表的复制
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        //复制各节点,并建立"原节点 -> 新节点" 的Map映射
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        //构建新链表的next 和random指向
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        //返回新链表的头结点
        return map.get(head);
    }

    /**
     * 二叉搜索树与双向链表
     * @param root
     * @return
     */
    Node pre,head;
//    public Node treeToDoublyList(Node root) {
//        if (root == null) {
//            return null;
//        }
//        dfs(root);
//        head.left = pre;
//        pre.right = head;
//        return head;
//    }
//
//    private void dfs(Node cur) {
//        if (cur == null) {
//            return;
//        }
//        dfs(cur.left);
//        if (pre != null) {
//            pre.right = cur;
//        } else {
//            head = cur;
//        }
//        cur.left = pre;
//        pre = cur;
//        dfs(cur.right);
//    }

    /**
     * 序列化二叉树
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    private String rserialize(TreeNode root, String s) {
        if (root == null) {
            s += "None,";
        } else {
            s += String.valueOf(root.val) + ",";
            s = rserialize(root.left, s);
            s = rserialize(root.right, s);
        }
        return s;
    }

    /**
     * 反序列化二叉树
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    private TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);
        return root;
    }

    /**
     * 字符串的排列
     * @param s
     * @return
     */
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    private void swap(int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

    /**
     * 数组中出现次数超过一半的数字
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

    /**
     * 最小的k个数
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            vec[i] = arr[i];
        }
        return vec;
    }

    /**
     * 数据流中的中位数
     */
    class MedianFinder {
        Queue<Integer> A, B;
        public MedianFinder() {
            A = new PriorityQueue<>();//小顶堆,保存较大得到一半
            B = new PriorityQueue<>((x, y) -> (y-x));//大顶堆,保存较小的一半
        }
        public void addNum(int num) {
            if (A.size() != B.size()) {
                A.add(num);
                B.add(A.poll());
            } else {
                B.add(num);
                A.add(B.poll());
            }
        }
        public double findMedian() {
            return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
        }
    }

    /**
     * 连接子数组的最大和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    /**
     * 1~n整数中1出现的次数
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += high % 10;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}