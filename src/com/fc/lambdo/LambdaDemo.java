package com.fc.lambdo;

import com.fc.lambdo.entity.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author fanchen
 * @Date 2022/3/25 17:09
 */
public class LambdaDemo {
    public static List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User("a", "ew"));
        users.add(new User("a", "ab"));
        users.add(new User("c", "wer"));
        users.add(new User("sd", "br"));
        users.add(new User("ads", "bhf"));
        users.add(new User("dads", "bd"));
        users.add(new User("gfg", "bj"));
    }

    public static void main(String[] args) {
        System.out.println(users);

        System.out.println("==================");
        System.out.println("1、forEach两种遍历方式");
        System.out.println("forEach遍历方式一");
        users.forEach(user -> System.out.println(user + " "));
        System.out.println("forEach遍历方式二");
        users.forEach(System.out::println);

        System.out.println("==================");
        System.out.println("2、排序");
        String[] players = {"1", "3", "2", "0"};
        System.out.println("排序前");
        List<String> list = Arrays.asList(players);
        list.forEach(player -> System.out.print(player + " "));
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("\n排序后");
        List<String> list1 = Arrays.asList(players);
        list1.forEach(player -> System.out.print(player + " "));

        System.out.println("\n==================");
        System.out.println("3、用setter、getter");
        users.forEach(user -> user.setUsername(user.getUsername() + "---123---"));
        users.forEach(user -> System.out.println(user));

        System.out.println("==================");
        System.out.println("4、过滤器");
        users.stream()
                .filter(p -> p.getUsername().equals("a"))
                .limit(1)
                .forEach(u -> System.out.println(u.getPassword() + " "));
        users.stream()
                .sorted((p1, p2) -> p1.getUsername().compareTo(p2.getUsername()))
                .limit(10)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("==================");
        System.out.println("5、stream处理");
        List<User> userList = users.stream()
                .sorted((p1, p2) -> p1.getUsername().compareTo(p2.getUsername()))
                .limit(5)
                .collect(Collectors.toList());
        userList.forEach(u -> System.out.println(u + " "));
        users.stream()
                .sorted((p1, p2) -> p1.getUsername().compareTo(p2.getUsername()))
                .limit(10)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("==================");
        System.out.println("6、max");
        User maxUser = users.stream()
                .max((p1, p2) -> p1.getUsername().length() - p2.getUsername().length())
                .get();
        System.out.println("maxUser: " + maxUser);

        System.out.println("==================");
        System.out.println("7、min");
        User minUser = users.stream()
                .min((p1, p2) -> p1.getUsername().length() - p2.getUsername().length())
                .get();
        System.out.println("minUser: " + minUser);

        System.out.println("==================");
        System.out.println("8、sum");
        int sum = users.parallelStream()
                .mapToInt(p -> p.getUsername().length())
                .sum();
        System.out.println(sum);

        System.out.println("==================");
        System.out.println("9、将list转化为String");
        String usersStr = users.stream()
                .map(User::getUsername)
                .collect(Collectors.joining(";"));
        System.out.println("usersStr: " + usersStr);

        System.out.println("==================");
        System.out.println("10、将list转化为Set");
        Set<String> usersSet = users.stream()
                .map(User::getUsername)
                .collect(Collectors.toSet());
        System.out.println("usersSet: " + usersSet);

        System.out.println("==================");
        System.out.println("11、将list转化为TreeSet");
        TreeSet<String> usersTreeSet = users.stream()
                .map(User::getUsername)
                .collect(Collectors.toCollection(TreeSet::new));
        usersTreeSet.forEach(u -> System.out.println(u + " "));


        System.out.println("==================");
        System.out.println("12、统计");
        List<Integer> intNum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics intSummaryStatistics = intNum.stream()
                .mapToInt(x -> x)
                .summaryStatistics();
        System.out.println("intSummaryStatistics: " + intSummaryStatistics);
        System.out.println("总数：" + intSummaryStatistics.getCount());
        System.out.println("平均：" + intSummaryStatistics.getAverage());
        System.out.println("最大：" + intSummaryStatistics.getMax());
        System.out.println("最小：" + intSummaryStatistics.getMin());
        System.out.println("总计：" + intSummaryStatistics.getSum());


        System.out.println("==================");
        System.out.println("13、线程");
        System.out.println("继承Thread的形式");
        new Thread(() -> System.out.println("我是线程run方法"))
                .start();
        System.out.println("实现runnable的形式");
        Runnable r2 = () -> System.out.println("我是线程的run方法");
        r2.run();;

    }
}
