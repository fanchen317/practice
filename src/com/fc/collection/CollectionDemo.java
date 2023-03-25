package com.fc.collection;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author fanchen
 * @Date 2022/3/25 11:39
 */
public class CollectionDemo {
    public static void main(String[] args) {
        //队列
        Queue<String> queue = new LinkedList<String>();

        List<String> strings = Arrays.asList("a", "b", "c");
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        queue.offer("f");
        queue.offer("g");
        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println("=======");
        System.out.println("poll: " + queue.poll());//返回第一个元素并删除
        System.out.println("element: " + queue.element()); //返回第一个元素
        System.out.println("peek: " + queue.peek()); // 返回第一个元素

        //栈
        System.out.println("=======");
        Stack<Integer> stack = new Stack<>();
        System.out.println("Stack: " + stack);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Stack: " + stack);
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());


    }
}
