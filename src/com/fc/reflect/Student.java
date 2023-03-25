package com.fc.reflect;

/**
 * @Author fanchen
 * @Date 2022/9/15 11:25
 */
public class Student {
    //1.定义成员变量
    private String name;
    public int age;

    //2.给被封装属性提供get与set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //3.生成本类的无参构造与全参构造
    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //4.提供本类的普通方法
    public void play() {
        System.out.println("不玩游戏，学Java！");
    }

    public void sunDay(int n) {
        System.out.println("卷起来，没有假！");
    }

    //5.为了查看学生对象的具体属性与属性值，重写toString()
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
