package com.fc.collection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * list扩容
 * @Author fanchen
 * @Date 2022/9/19 16:46
 */
public class ListDemo {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {

            System.out.println("index=" + i + ", value=" + "test" + i);
            System.out.println("扩容:" + getTableSize(list));
            list.add("test" + i);
        }
    }

    private static int getTableSize(List<String> list) throws Exception {
        Class<? extends List> aClass = list.getClass();
        Field f = aClass.getDeclaredField("elementData");
        f.setAccessible(true);
        Object[] objects = (Object[]) f.get(list);
        return objects.length;
    }
}
