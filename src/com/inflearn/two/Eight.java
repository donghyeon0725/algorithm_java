package com.inflearn.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 등수구하기
 *
 * N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을
 * 작성하세요.
 * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다. 즉 가장 높은 점수가 92점인데 92점이
 * 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
 *
 *
 * ▣ 입력설명
 * 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력
 * 된다.
 *
 * ▣ 출력설명
 * 입력된 순서대로 등수를 출력한다.
 *
 * ▣ 입력예제 1
 * 6
 * 77 79 82 100 66 77
 *
 * ▣ 출력예제 1
 * 4 3 2 1 6 4
 * */
public class Eight {

    // 점수에 해당하는 등수
    private static int[] rankOfScore = new int[101];

    private static int[] input = {77,79,82,100,66,77};

    static {

        // 점수를 기준으로 점수보다 더 낮은 사람이 있는지 확인
        for (int score = 0; score <= 100; score++) {

            int rank = 1;
            // 사람 수만큼 반복
            for (int i=0; i<input.length; i++) {

                // 오직 이 점수보다 높은 점수에 몇명이 있는지만 판별
                if (input[i] > score) {
                    rank++;
                }
            }

            rankOfScore[score] = rank;
        }

    }


    // 앞에서 부터 하나하나 세는 방법
    public static String solution(int[] arr) {
        int total = arr.length;
        int[] result = new int[total];

        for (int i=0; i<total; i++) {

            int rank = 1;

            for (int j=0; j<total; j++) {

                // 같은 대상이면
                if (i == j) {
                    continue;
                }

                int myScore = arr[i];
                int otherScore = arr[j];

                // 나보다 다른 사람의 점수가 높으면 등수 ++
                if (otherScore > myScore) {
                    rank++;
                }
            }

            result[i] = rank;
        }

        return Arrays.toString(result);
    }

    // 미리 구해놓은 등수표를 가지고 구하는 방법
    public static String solution_1(int[] scores) {

        List<Integer> result = new ArrayList<>();

        for (int score : scores) {
            result.add(rankOfScore[score]);
        }

        return Arrays.toString(result.toArray());
    }

    public static void main(String[] args) {
        int[] input = {77,79,82,100,66,77};

        System.out.println(solution(input));



        System.out.println(solution_1(input));
    }
}
