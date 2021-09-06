package com.backjun.one;

import java.util.*;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        while (testCase-- > 0) {
            int count = sc.nextInt();
            int target = sc.nextInt();
            int result = 0;
            Queue<Integer[]> queue = new LinkedList();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> b - a);

            for (int order=0; order<count; order++) {
                int priority = sc.nextInt();
                queue.add(new Integer[]{priority, order});
                maxQueue.add(priority);
            }

            while (!queue.isEmpty()) {
                result++;
                final Integer max = maxQueue.poll();
                Integer[] number;

                while (max != (number = queue.poll())[0])
                    queue.add(number);

                if (number[1] == target) {
                    System.out.println(result);
                    break;
                }

            }

        }
    }
}
