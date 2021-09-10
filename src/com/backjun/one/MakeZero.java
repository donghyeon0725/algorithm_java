package com.backjun.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MakeZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        while (testCase-- > 0) {
            int len = sc.nextInt();

            dfs(2, len, "1");

            expressions = expressions.stream().sorted((a,b) -> {
                char[] aa = a.toCharArray();
                char[] bb = b.toCharArray();

                for (int i=0; i<Math.min(aa.length, bb.length); i++) {
                    if (aa[i] != bb[i]) {
                        return (int)aa[i] - (int)bb[i];
                    }
                }
                return 1;
            }).collect(Collectors.toList());

            List<String> collect = expressions.stream().filter(expression -> {

                String temp = expression.replace(" ", "");
                final String[] split = temp.split("-|\\+");
                int index = 0;
                int result = Integer.parseInt(split[index++]);

                for (char s : expression.toCharArray()) {
                    if (s == '+')
                        result += Integer.parseInt(split[index++]);
                    else if (s == '-')
                        result -= Integer.parseInt(split[index++]);
                }

                if (result == 0)
                    return true;

                return false;
            }).collect(Collectors.toList());

            collect.forEach(System.out::println);

            if (testCase >= 1)
                System.out.println();

            expressions.clear();
        }

    }

    private static List<String> expressions = new ArrayList<>();
    public static void dfs(int search, Integer last, String expression) {
        if (search > last) {
            expressions.add(expression);
            return;
        }


        dfs(search + 1, last, expression + "+" + search);
        dfs(search + 1, last, expression + "-" + search);
        dfs(search + 1, last, expression + " " + search);
    }
}
