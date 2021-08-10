package com.programmers.one;

import java.util.Arrays;

public class Ten {
    public int[][] solution(int n) {

        // a : 출발지 => 1
        // b : 여분의 기둥 => 2
        // c : 목적지 => 3
        String hanoi = "ac";
        int last = 1;
        for (int i=2; i<=n; i++) {
            last += last + 1;
            // 처음 출발할 때는 여분의 기둥이 목적지로 보면 이전 경로와 동일하게 움직일 수 있다.
            hanoi = change(hanoi, 0) + "ac" + change(hanoi, 1);
        }

        int[][] answer = new int[last][];
        char[] top = hanoi.toCharArray();
        for (int i=0; i<last; i++) {
            answer[i] = new int[]{top[2 * i] % 96, top[2 * i + 1] % 96};
        }

        return answer;
    }

    public String change(String target, int t) {
        char[][] box = {{'a', 'c', 'b'}, {'b', 'a', 'c'}};

        StringBuilder sb = new StringBuilder();

        for (char c : target.toCharArray())
            sb.append(box[t][c % 97]);
        return sb.toString();
    }

    public int[][] solution1(int n) {

        // a : 출발지 => 1
        // b : 여분의 기둥 => 2
        // c : 목적지 => 3
        String hanoi = "ac";
        int last = 1;
        for (int i=2; i<=n; i++) {
            last += last + 1;
            // 처음 출발할 때는 여분의 기둥이 목적지로 보면 이전 경로와 동일하게 움직일 수 있다.
            hanoi = changeRestAndDestination(hanoi) + "ac" + changeRestAndStart(hanoi);
        }

        int[][] answer = new int[last][];
        char[] top = hanoi.toCharArray();
        for (int i=0; i<last; i++) {
            answer[i] = new int[]{top[2 * i] % 96, top[2 * i + 1] % 96};
        }

        return answer;
    }

    public String changeRestAndDestination(String target) {
        char[] box = {'a', 'c', 'b'};
        StringBuilder sb = new StringBuilder();

        for (char c : target.toCharArray())
            sb.append(box[c % 97]);
        return sb.toString();
    }

    public String changeRestAndStart(String target) {
        char[] box = {'b', 'a', 'c'};
        StringBuilder sb = new StringBuilder();

        for (char c : target.toCharArray())
            sb.append(box[c % 97]);
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 2;
        Ten ten = new Ten();

        int[][] result = ten.solution(n);

        for (int[] r : result)
            System.out.println(Arrays.toString(r));
    }


}
