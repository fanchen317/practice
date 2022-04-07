package com.fc.java8.lambda;

import com.fc.java8.Person;

import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author fanchen
 * @Date 2022/4/1 15:20
 */
public class Demo1 {
    public static void main(String[] args) {
        //无参无返回值
        goShow(new UserService() {
            @Override
            public void show() {
                System.out.println("show方法执行了.....  ");
            }
        });
        System.out.println("------");
        goShow(() -> {
            System.out.println("Lambda show 方法执行了");
        });

        //有参有返回值
        System.out.println("======");
        List<Person> list = new ArrayList<>();
        list.add(new Person("zhangsan", 13, "男"));
        list.add(new Person("sd", 11, "男"));
        list.add(new Person("asdad", 12, "男"));
        list.add(new Person("sdas", 15, "男"));

//        Collections.sort(list, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });
        Collections.sort(list, (Person o1, Person o2) -> {
            return o1.getAge() - o2.getAge();
        });
        for (Person person : list) {
            System.out.println(person);
        }

        //lambda省略写法
    }

    public static void goShow(UserService userService) {
        userService.show();
    }
}
