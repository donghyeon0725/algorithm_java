package com.backjun.one;

import java.util.*;

public class KeyLogger {
    public static void main(String[] args) {
        solution2();
    }

    // 시간 초과
    public static void solution() {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        while (testCase-- > 0) {
            StringBuilder sb = new StringBuilder();
            char[] chars = sc.next().toCharArray();
            int index = 0;

            for (int i=0; i<chars.length; i++) {
                if (chars[i] == '<') {
                    index = index > 0 ? index - 1 : 0;
                } else if (chars[i] == '>') {
                    index = sb.length() > index ? index + 1 : sb.length();
                } else if (chars[i] == '-') {
                    if (index > 0) {
                        sb.deleteCharAt(index - 1);
                        index--;
                    }
                } else {
                    sb.insert(index++, chars[i]);
                }
            }

            System.out.println(sb.toString());
        }
    }

    // 시간 초과
    public static void solution1() {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        while (testCase-- > 0) {
            List<Character> sb = new LinkedList<>();
            char[] chars = sc.next().toCharArray();
            int index = 0;

            for (int i=0; i<chars.length; i++) {
                if (chars[i] == '<') {
                    index = index > 0 ? index - 1 : 0;
                } else if (chars[i] == '>') {
                    index = sb.size() > index ? index + 1 : sb.size();
                } else if (chars[i] == '-') {
                    if (index > 0) {
                        sb.remove(index - 1);
                        index--;
                    }
                } else {
                    sb.add(index++, chars[i]);
                }
            }

            for (int i=0; i<sb.size(); i++)
                System.out.print(sb.get(i));
            System.out.println();
        }
    }

    // 정답
    public static void solution2() {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        while (testCase-- > 0) {
            Stack left = new Stack();
            Stack right = new Stack();
            StringBuilder sb = new StringBuilder();

            for (char c : sc.next().toCharArray()) {
                if (c == '<') {
                    if (!left.isEmpty())
                        right.push(left.pop());
                } else if (c == '>') {
                    if (!right.isEmpty())
                        left.push(right.pop());
                } else if (c == '-') {
                    if (!left.isEmpty())
                        left.pop();
                } else {
                    left.push(c);
                }
            }

            while (!right.isEmpty())
                left.push(right.pop());

            for (int i = 0; i < left.size(); i++)
                sb.append(left.get(i));
            System.out.println(sb.toString());
        }
    }

}
