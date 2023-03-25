package com.fc.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author fanchen
 * @Date 2022/9/15 11:26
 */
public class Main {
    public Main() throws ClassNotFoundException {
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz1 = Class.forName("com.fc.reflect.Student");
        Class<?> clazz2 = Student.class;
        Class<?> clazz3 = new Student().getClass();

//        System.out.println(clazz1);//class com.fc.reflect.Student
//        System.out.println(clazz1.getName());//com.fc.reflect.Student
//        System.out.println(clazz1.getSimpleName());//Student
//        System.out.println(clazz1.getPackage());//package com.fc.reflect
//        System.out.println(clazz1.getPackage().getName());//com.fc.reflect

        Student s1 = new Student("张三", 3);
        Student s2 = new Student("李四", 4);
        Student s3 = new Student("王五", 5);
        //2.创建数组将刚刚的3个对象存入数组中
        Student[] s = {s1, s2, s3};
        //3.直接打印数组，查看数组中的元素
        System.out.println(Arrays.toString(s));
        //4.遍历学生数组，拿到每一个学生对象，做进一步的操作
//        for (Student stu : s) {
//            //System.out.println(stu);
//            stu.play();//通过遍历到的对象，执行play()
//            System.out.println(stu.age);//通过遍历到的对象，打印age属性
//        }

        //反射方法
        Class<?> clazz = Class.forName("com.fc.reflect.Student");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            ////获取所有公开的成员变量,包括继承变量
            System.out.println(field.getName());// age
            System.out.println(field.getType());// int
        }

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);// public java.lang.String com.fc.reflect.Student.toString()
            System.out.println(method.getName());// toString
            System.out.println(Arrays.toString(method.getParameterTypes()));// []
            System.out.println(method.getReturnType().getName());// java.lang.String
            System.out.println(Arrays.toString(method.getParameters()));// []
        }

        String a = "1";
        System.out.println(a instanceof String);
    }

    private <T>T getSub(Class<T> clazz){
        return (T) clazz;
    }
}
