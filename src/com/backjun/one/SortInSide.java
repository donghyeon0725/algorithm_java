package com.backjun.one;

import com.dataType.heap.Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SortInSide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        while (number > 0) {
            queue.add(number % 10);
            number /= 10;
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty())
            sb.append(queue.poll());

        System.out.println(sb.toString());

    }
}
