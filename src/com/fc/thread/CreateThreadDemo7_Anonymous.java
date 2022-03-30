package com.fc.thread;

/**
 * @Author fanchen
 * @Date 2022/3/28 16:49
 */
public class CreateThreadDemo7_Anonymous {
    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    printInfo("interface");
//                }
//            }
//        }){
//            @Override
//            public void run() {
//                while (true) {
//                    printInfo("sub class");
//                }
//            }
//        }.start();

        new Thread(() -> {
            while (true) {
                printInfo("sub class");
            }
        }).start();
    }

    /**
     * 输出当前线程的信息
     */
    private static void printInfo(String text) {
        System.out.println(text);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
