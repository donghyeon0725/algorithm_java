package com.inflearn.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 격자판 최대합
 *
 * 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
 * 10 13 10 12 15
 * 12 39 30 23 11
 * 11 25 50 53 15
 * 19 27 29 37 27
 * 19 13 30 13 19
 * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합
 * 니다.
 *
 *
 * ▣ 입력설명
 * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는
 * 다.
 *
 * ▣ 출력설명
 * 최대합을 출력합니다.
 *
 * ▣ 입력예제 1
 * 5
 * 10 13 10 12 15
 * 12 39 30 23 11
 * 11 25 50 53 15
 * 19 27 29 37 27
 * 19 13 30 13 19
 *
 * ▣ 출력예제 1
 * 155
 * */
public class Nine {

    public static int solution(int[][] arr) {
        List<Integer> scores = new ArrayList<>();

        int slash = 0;
        int backSlash = 0;

        for (int i=0; i<arr.length; i++) {

            int vertical = 0;
            int horizon = 0;

            for (int j=0; j<arr.length; j++) {
                // 가로 합
                horizon += arr[i][j];
                vertical += arr[j][i];
            }

            scores.add(horizon);
            scores.add(vertical);

            backSlash += arr[i][i];
            slash += arr[i][(arr.length-1) - i];
        }

        scores.add(backSlash);
        scores.add(slash);

        return scores.stream().max((a, b) -> {
            if (a > b) return 1;
            else if (a==b) return 0;
            else return -1;
        }).get();
    }


    public static void main(String[] args) {

        int[][] input = {
                {10,13,10,12,15},
                {12,39,30,23,11},
                {11,25,50,53,15},
                {19,27,29,37,27},
                {19,13,30,13,19}
        };

        System.out.println(solution(input));
    }
}
