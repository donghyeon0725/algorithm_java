package com.programmers;

import java.util.*;

public class MockExam {
    public int[] solution(int[] answers) {
        int[] choice1 = {1, 2, 3, 4, 5};
        int[] choice2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] choice3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[][] score = {{1, 0}, {2, 0}, {3, 0}};


        for (int i=0; i<answers.length; i++) {
            if (answers[i] == choice1[i % choice1.length])
                score[0][1]++;

            if (answers[i] == choice2[i % choice2.length])
                score[1][1]++;

            if (answers[i] == choice3[i % choice3.length])
                score[2][1]++;
        }

        Arrays.sort(score, (a, b) -> b[1] - a[1]);
        List<Integer> winner = new ArrayList<>();
        for (int i=0; i<score.length; i++) {
            if (score[0][1] == score[i][1])
                winner.add(score[i][0]);
        }
        return winner.stream().mapToInt(s -> s).toArray();
    }

    public static void main(String[] args) {
        MockExam exam = new MockExam();
        exam.solution(new int[]{1, 2, 3, 4, 5});
    }
}
