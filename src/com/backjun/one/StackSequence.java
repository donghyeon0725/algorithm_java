package com.backjun.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StackSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int index = 1;
        int[] arr = new int[n];
        boolean can = true;
        List<Character> chars = new ArrayList<>();

        for (int i=0; i<n; i++)
            arr[i] = sc.nextInt();


        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<arr.length; i++) {

            if (arr[i] >= index) {
                while (arr[i] >= index) {
                    stack.push(index);
                    index++;
                    chars.add('+');
                }
            }

            final int num = stack.pop();
            if (arr[i] == num)
                chars.add('-');
            else {
                can = false;
                break;
            }
        }

        if (!can)
            System.out.println("NO");
        else
            for (int i=0; i<chars.size(); i++)
                System.out.println(chars.get(i));
    }

    public static void optimization() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int index = 1;
        List<CharSequence> chars = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<n; i++) {
            int target = sc.nextInt();

            if (target >= index) {
                while (target >= index) {
                    stack.push(index);
                    index++;
                    chars.add("+");
                }
            }

            if (target == stack.pop())
                chars.add("-");
            else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(String.join(",", chars));
    }
}
