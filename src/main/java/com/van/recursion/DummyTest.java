package com.van.recursion;

public class DummyTest {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        bar();
        System.out.println("Executing main...");
    }

    private static void bar() {
        doWork();
        System.out.println("Executing bar...");
    }

    private static void doWork() {
        doMore();
        System.out.println("Executing doWork...");
    }

    private static void doMore() {
        System.out.println("Executing doMore...");
    }
}
