package com.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PrinterNew1 {

    /**
     * 우선순위 배열을 정렬해서, 앞에서 부터 인덱스 차례대로 비교해 나가면 될 것 같음
     * 인덱스 값에 해당하는 문서가 나올 때까지 queue 를 poll & push 하면 됩니다.
     *
     * Arrays.sort 를 사용하면 낮은 값이 앞에 온다는 점 주의해서 사용하기
     * */
    public int solution(int[] priorities, int location) {

        Queue<Integer> queue = new LinkedList<>();
        int targetCursor = location;
        int maxCursor = 0;

        for (int priority : priorities) {
            queue.add(priority);
        }

        Arrays.sort(priorities);
        int size = priorities.length - 1;

        while (!queue.isEmpty()) {

            Integer documentPriority = queue.poll();

            if (documentPriority.equals(priorities[size - maxCursor])) {
                maxCursor++;
                if (targetCursor == 0)
                    break;

                targetCursor--;
            } else {
                queue.add(documentPriority);
                targetCursor--;
                if (targetCursor < 0)
                    targetCursor = queue.size() - 1;
            }
        }

        return maxCursor;
    }

    public static void main(String[] args) {
        PrinterNew1 printer = new PrinterNew1();
//        int[] priorities = {2, 1, 3, 2};
        int[] priorities = {1, 1, 9, 1, 1, 1};
        System.out.println(printer.solution(priorities, 0));
    }
}
