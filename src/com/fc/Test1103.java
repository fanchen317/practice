package com.fc;

import java.util.*;

/**
 * @Author fanchen
 * @Date 2022/11/3 17:04
 */
public class Test1103 {
    public int[] test (int[] arr) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        if (arr.length > 0) {
            for (int i : arr) {
                if (map.containsKey(i)) {
                    int count = map.get(i);
                    map.put(i, ++count);
                } else {
                    map.put(i, 1);
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }

        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Test1103 test1103 = new Test1103();
        int[] testArr = {2,3,2,9};
        int[] test = test1103.test(testArr);
        for (int i : test) {
            System.out.print(i + " ");
        }

        String testStr = "asdasdmksajnkfansfnkanf";
        String str = test1103.res(testStr);

        System.out.println();
        System.out.println(str);


        Map<String, Integer> map = new HashMap<>();
        map.put("a", 0);
        Integer a = map.put("a", 1);
        Integer b = map.put("b", 1);
        System.out.println(a);
        System.out.println(b);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        boolean add = set.add(1);
        System.out.println(add);
        boolean add1 = set.add(2);
        System.out.println(add1);
    }

    public String res (String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();

    }
}
