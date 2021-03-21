package com.algorithm.sort;

import java.util.*;
import java.util.stream.Collectors;

public class Sort {
    private static int[] arr = {47, 61, 21, 94, 97, 38, 31, 63, 71, 8, 52, 54, 19, 1, 74, 77, 13, 4, 39, 30, 6, 35, 60, 25, 51, 17, 42, 36, 18, 92, 55, 29, 67, 89, 41, 90, 78, 23, 70, 88, 98, 45, 69, 72, 28, 56, 62, 75, 100, 7, 64, 57, 24, 80, 33, 86, 50, 73, 44, 32, 3};

    /**
     * 정렬하기
     * */
    public static void sort() {
        Arrays.sort(arr);

        for (int i=0; i<arr.length; i++) {
            System.out.println(arr);
        }
    }

    /**
     * 역순으로 정렬하기
     * */
    public static void sortReverse() {
        Integer[] IntegerArrs = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(IntegerArrs, Collections.reverseOrder());

        for (int i=0; i<IntegerArrs.length; i++) {
            System.out.println(IntegerArrs[i]);
        }
    }

    /**
     * 계정 정렬하기
     * */
    public static void sortAccount() {
        Account a6 = new Account(6, "kim7");
        Account a2 = new Account(3, "kim2");
        Account a1 = new Account(1, "kim1");
        Account a3 = new Account(2, "kim4");
        Account a4 = new Account(5, "kim5");
        Account a5 = new Account(8, "kim6");
        Account a7 = new Account(9, "kim8");


        List<Account> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        list.add(a6);
        list.add(a7);

        Collections.sort(list);

        for (Account a : list) {
            System.out.println(a);
        }
    }




}
