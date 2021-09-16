package com.backjun.one;

import java.util.Scanner;

public class SearchDocument {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String target = sc.nextLine();
        int max = Integer.MIN_VALUE;

        for (int i=0, count = 0, index = 0; i<target.length(); i++) {
            if (word.length() < target.length()) {
                max = 0;
                break;
            }
            StringBuilder search = new StringBuilder(word.substring(i));

            while ((index = search.indexOf(target)) != -1) {
                count++;
                search = new StringBuilder(search.substring(index + target.length()));
            }
            if (max < count)
                max = count;

            count = 0;
        }

        System.out.println(max);

    }
}
