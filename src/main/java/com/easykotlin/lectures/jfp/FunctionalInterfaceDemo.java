package com.easykotlin.lectures.jfp;

import java.util.function.Function;

import static java.lang.System.out;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        test1();
        test2();
        test22();
//        9801
//        25
//        25

        test3();
        test32();

    }

    static void test1() {
        Function<Integer, Integer> f = x -> x * x;
        Integer y = f.apply(99);
        out.println(y);
    }

    static void test2() {
        Function<Integer, Function<Integer, Integer>> f = x -> y -> x * x + y * y; // 科里化 Currying
        Integer y = f.apply(3).apply(4);
        out.println(y);
    }

    static void test22() {
        TwoParamsFunction<Integer, Integer, Integer> f = (x, y) -> x * x + y * y;
        Integer y = f.apply(3, 4);
        out.println(y);
    }

    @FunctionalInterface
    interface TwoParamsFunction<X, Y, Output> {
        Output apply(X x, Y y);
    }

    static void test3() {
        Function<Integer, Function<Integer, Function<Integer, Integer>>> f = x -> y -> z -> x * x + y * y + z * z; // 科里化 Currying
        Integer y = f.apply(3).apply(4).apply(5);
        out.println(y);
    }

    static void test32() {
        ThreeParamsFunction<Integer, Integer, Integer, Integer> f = (x, y, z) -> x * x + y * y + z * z;
        Integer y = f.apply(3, 4, 5);
        out.println(y);
    }

    @FunctionalInterface
    interface ThreeParamsFunction<X, Y, Z, Output> {
        Output apply(X x, Y y, Z z);
    }

}
