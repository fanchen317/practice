package com.fc.collection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * map扩容
 * @Author fanchen
 * @Date 2022/9/19 16:46
 */
public class MapDemo {
    public static void main(String[] args) throws Exception {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(i, "test" + i);
            System.out.println("key=" + i + ",value=" + "test" + i);
            System.out.println("扩容:" + getTableSize(map));
        }

    }

    private static int getTableSize(Map<Integer, String> map) throws Exception {
        Class<? extends Map> aClass = map.getClass();
        Field f = aClass.getDeclaredField("table");
        f.setAccessible(true);
        Object[] objects = (Object[]) f.get(map);
        return objects.length;
    }
}
