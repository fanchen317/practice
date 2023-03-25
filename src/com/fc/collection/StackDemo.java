package com.fc.collection;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @Author fanchen
 * @Date 2022/3/30 11:00
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        // 将1,2,3,4,5添加到栈中
        for (int i = 0; i < 5; i++) {
            stack.push(String.valueOf(i + 1));
        }

        // 遍历打印出该栈
        iteratorThroughRandomAccess(stack);

        // 查找“2”在栈中的位置，并输出
        int pos = stack.search("2");
        System.out.println("the postion of 2 is:" + pos);

        // pop栈顶元素之后，遍历栈
        stack.pop();
        iteratorThroughRandomAccess(stack);

        // peek栈顶元素之后，遍历栈
        String peek = stack.peek();
        System.out.println("peek: " + peek);
        iteratorThroughRandomAccess(stack);

        // 通过Iterator去遍历Stack
        iteratorThroughIterator(stack);
    }

    /**
     * 通过迭代器遍历Stack
     */
    private static void iteratorThroughIterator(List<String> list) {
        String val = "";
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            val = iterator.next();
            System.out.println("val: " + val);
        }
    }

    /**
     * 通过快速访问遍历stack
     *
     * @param list
     */
    private static void iteratorThroughRandomAccess(List<String> list) {
        list.forEach(l -> System.out.print(l + " "));
        System.out.println();
    }
}
