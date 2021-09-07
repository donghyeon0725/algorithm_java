package com.backjun.one;

import java.util.*;

public class FindNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set set = new HashSet<>();
        int len = sc.nextInt();

        for (int i=0; i<len; i++)
            set.add(sc.nextInt());

        int find = sc.nextInt();

        for (int i=0; i<find; i++)
            System.out.println(set.contains(sc.nextInt()) ? 1 : 0);
    }
}
