package com.easykotlin.lectures.jfp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaFPDemos {

    public static void main(String[] args) {
        JavaFPDemos javaFPDemos = new JavaFPDemos();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(javaFPDemos.filterOddNums(list));


        List<String> stringList = Arrays.asList("a", "ab", "abc", "abcd", "abcde", "abcdef", "abcdefg");
        System.out.println(javaFPDemos.filterOddLengthStrings(stringList));


    }

    public List<Integer> filterOddNums(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (Integer i : list) {
            if (i % 2 == 1) {
                result.add(i);
            }
        }
        return result;
    }

    public List<String> filterOddLengthStrings(List<String> list) {
        List<String> result = new ArrayList<>();
        for (String i : list) {
            if (i.length() % 2 == 1) {
                result.add(i);
            }
        }
        return result;
    }


}