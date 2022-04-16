package com.programmers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

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

        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
//        int[][] wires = {{1,2},{3,4}};
//        int[][] wires = {{1,2},{2,7},{3,4},{4,5},{6,7}};

        PrinterNew1 printerNew1 = new PrinterNew1();

        System.out.println(printerNew1.solution(n, wires));;
    }

    public int solution(int n, int[][] wires) {

        int min = Integer.MAX_VALUE;

        for (int t=0; t<wires.length; t++) {
            int[] dis = wires[t];
            int[][] newWires = newArrWithRemove(wires, t);

            int[] parent = new int[n];
            int[] size = new int[n];

            Arrays.fill(size, 1);
            for (int i=0; i<parent.length; i++) {
                parent[i] = i;
            }

            for (int[] wire : newWires) {
                int rootL = parent[wire[0] - 1];
                int rootR = parent[wire[1] - 1];
                int tempL = rootL;

                rootL = rootL < rootR ? rootL : rootR;
                rootR = tempL < rootR ? rootR : tempL;

                parent[rootL] = rootL;
                parent[rootR] = rootL;
                size[rootL] = size[rootL] + size[rootR];
            }

            int result = size[parent[dis[0] - 1]] - size[parent[dis[1] - 1]];
            if (Math.abs(result) < min) {
                min = Math.abs(result);
            }
        }

        return min;
    }

    public int[][] newArrWithRemove(int[][] arr, int t) {
        int[][] result = new int[arr.length - 1][2];

        int index = 0;
        for (int i=0; i<arr.length; i++) {
            if (i != t) {
                result[index] = arr[i];
                index++;
            }
        }

        return result;
    }

}
