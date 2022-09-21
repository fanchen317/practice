package com.fc;

/**
 * @Author fanchen
 * @Date 2022/8/31 14:32
 */
public class Test {
    static class Annoyance extends Exception {
    }

    static class Sneeze extends Annoyance {
    }

    static class Human {
        public static void main(String[] args) throws Exception {
            try {
                try {
                    throw new Sneeze();
                } catch (Annoyance a) {
                    System.out.println("Caught Annoyance");
                    throw a;
                }
            } catch (Sneeze s) {
                System.out.println("Caught Sneeze");
                return;
            } finally {
                System.out.println("Hello World!");
            }


        }
    }
}