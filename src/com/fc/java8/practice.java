package com.fc.java8;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author fanchen
 * @Date 2022/4/1 10:06
 */
public class practice {
    //计算机俱乐部
    private static List<Student> computerClub = Arrays.asList(
            new Student("2015134001", "小明", 15, "1501"),
            new Student("2015134003", "小王", 14, "1503"),
            new Student("2015134006", "小张", 15, "1501"),
            new Student("2015134008", "小梁", 17, "1505")
    );
    //篮球俱乐部
    private static List<Student> basketballClub = Arrays.asList(
            new Student("2015134012", "小c", 13, "1503"),
            new Student("2015134013", "小s", 14, "1503"),
            new Student("2015134015", "小d", 15, "1504"),
            new Student("2015134018", "小y", 16, "1505")
    );
    //乒乓球俱乐部
    private static List<Student> pingpongClub = Arrays.asList(
            new Student("2015134022", "小u", 16, "1502"),
            new Student("2015134021", "小i", 14, "1502"),
            new Student("2015134026", "小m", 17, "1504"),
            new Student("2015134027", "小n", 16, "1504")
    );

    private static List<List<Student>> allClubStu = new ArrayList<>();

    public static void main(String[] args) {
        allClubStu.add(computerClub);
        allClubStu.add(basketballClub);
        allClubStu.add(pingpongClub);


        //1.集合
        Stream<Student> stream = basketballClub.stream();

        //2.静态方法
        Stream<String> stream2 = Stream.of("a", "b", "c");

        //3.数组
        String[] arr = {"a", "b", "c"};
        Stream<String> stream3 = Arrays.stream(arr);

        //此处只是演示 此类需求直接用List构造器即可
        List<Student> collect = computerClub.stream().collect(Collectors.toList());
        Set<Student> collect1 = pingpongClub.stream().collect(Collectors.toSet());

        //注意key必须是唯一的 如果不是唯一的会报错而不是像普通map那样覆盖
        Map<String, String> collect2 = pingpongClub.stream()
                .collect(Collectors.toMap(Student::getIdNum, Student::getName));

        //分组 类似于数据库中的group by
        Map<String, List<Student>> collect3 = pingpongClub.stream()
                .collect(Collectors.groupingBy(Student::getClassNum));

        //字符串拼接 第一个参数是分隔符 第二个参数是前缀 第三个参数是后缀
        String collect4 = pingpongClub.stream()
                .map(Student::getName).collect(Collectors.joining(",", "[", "]"));

        //【小u,小i,小m,小n】
        //三个俱乐部符合年龄要求的按照班级分组
        Map<String, List<Student>> collect5 = Stream.of(basketballClub, pingpongClub, computerClub)
                .flatMap(e -> e.stream().filter(student -> student.getAge() < 17))
                .collect(Collectors.groupingBy(Student::getClassNum));

        //按照是否年龄>16进行分组 key为true和false
        ConcurrentMap<Boolean, List<Student>> collect6 = Stream.of(basketballClub, pingpongClub, computerClub)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingByConcurrent(s -> s.getAge() > 16));


        //筛选1501班的学生
        computerClub.stream()
                .filter(e -> e.getClassNum().equals("1501")).forEach(System.out::println);

        //筛选年龄大于15的学生
        List<Student> collect7 = computerClub.stream()
                .filter(e -> e.getAge() > 15).collect(Collectors.toList());

        //篮球俱乐部所有成员名 + 暂时住上商标^_^,并且获取所有队员名
        List<String> collect8 = basketballClub.stream()
                .map(e -> e.getName() + "^_^")
                .collect(Collectors.toList());
        collect8.forEach(System.out::println);

        //获取年龄大于15的所有俱乐部成员
        List<Student> collect9 = Stream.of(basketballClub, computerClub, pingpongClub)
                .flatMap(e -> e.stream().filter(student -> student.getAge() > 15))
                .collect(Collectors.toList());
        collect9.forEach(System.out::println);

        //用双层list获取所有年龄大于15的俱乐部成员
        List<Student> collect10 = allClubStu.stream()
                .flatMap(e -> e.stream().filter(student -> student.getAge() > 15))
                .collect(Collectors.toList());
        collect10.forEach(System.out::println);

        //篮球俱乐部所有成员名 + 赞助商商标^_^,并且获取所有队员详细内容
        List<Student> collect11 = basketballClub.stream()
                .peek(e -> e.setName(e.getName() + "^_^"))
                .collect(Collectors.toList());
        collect11.forEach(System.out::println);

        List<String> list = Arrays.asList("b","b","c","a");
        list.forEach(System.out::print); //bbca
        List<String> collect12 = list.stream().distinct().sorted().collect(Collectors.toList());
        collect12.forEach(System.out::print);//abc
        //获取list中排序后的top2 即截断取前两个
        List<String> collect13 = list.stream()
                .distinct().sorted().limit(2)
                .collect(Collectors.toList());
        collect13.forEach(System.out::println);

        boolean b = basketballClub.stream()
                .allMatch(e -> e.getAge() < 20);

        boolean b1 = basketballClub.stream()
                .anyMatch(e -> e.getAge() < 20);

        boolean b2 = basketballClub.stream()
                .noneMatch(e -> e.getAge() < 20);

        Optional<Student> first = basketballClub.stream()
                .findFirst();
        if (first.isPresent()) {
            Student student = first.get();
            System.out.println(student);
        }

        Optional<Student> any = basketballClub.stream()
                .findAny();
        if (any.isPresent()) {
            Student student = any.get();
            System.out.println(student);
        }

        Optional<Student> any1 = basketballClub.stream()
                .parallel().findAny();
        System.out.println(any1);


    }
}
