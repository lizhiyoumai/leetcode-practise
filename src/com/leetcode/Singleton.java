package com.leetcode;

/**
 * 单例的各种实现
 */
public class Singleton {
    /**
     * 饿汉式
     */
//    private static Singleton instance = new Singleton();
//    private Singleton() {}
//    public static Singleton getInstance() {
//        return instance;
//    }

    /**
     * 懒汉式
     */
//    private static Singleton instance;
//    private Singleton() {}
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    /**
     * 线程安全的懒汉式
     */
//    private static Singleton instance = new Singleton();
//    private Singleton() {}
//    public static synchronized Singleton getInstance() {
//        return instance;
//    }

    /**
     * 双重校验锁
     */
//    private static Singleton instance;
//    private Singleton() {}
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    /**
     * 优化后的DLC
     */
//    private static volatile Singleton instance;
//    private Singleton() {}
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    /**
     * 静态内部类
     */
//    private static class SingletonHoler {
//        private static Singleton singleton = new Singleton();
//    }
//    private Singleton() {}
//    public static Singleton getInstance() {
//        return SingletonHoler.singleton;
//    }

    /**
     * 枚举
     */
    public enum SomeThing {
        INSTANCE;
        private Singleton instance;
        SomeThing() {
            instance = new Singleton();
        }
        public Singleton getInstance() {
            return instance;
        }
    }

    public static void main(String[] args) {
        Singleton instance1 = SomeThing.INSTANCE.getInstance();
        Singleton instance2 = SomeThing.INSTANCE.getInstance();
        System.out.println(instance1 == instance2);;
    }
}
