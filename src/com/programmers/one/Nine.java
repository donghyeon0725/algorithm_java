package com.programmers.one;

import java.util.Arrays;

public class Nine {

    /**
     * 효율성 테스트 실패
     *
     * B의 입장에서 A에게 이길 수 있는 가장 작은 카드를 뽑음
     *
     * 효율성 테스트 실패
     * */
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        boolean[] isUsed = new boolean[A.length];


        int score = 0;
        for (int b : B) {

            for (int a=A.length-1; a>=0; a--) {
                if (!isUsed[a] && A[a] < b) {
                    isUsed[a] = true;
                    score++;
                    break;
                }
            }
        }

        return score;
    }

    public int solution1(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int score = 0;
        int b = B.length - 1;
        for (int a = A.length - 1; a >= 0; a--) {
            if (A[a] < B[b]) {
                score++;
                b--;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};

        int[] AA = {2,2,2,2};
        int[] BB = {1,1,1,1};

        Nine nine = new Nine();
        System.out.println(nine.solution1(A, B));
        System.out.println(nine.solution1(AA, BB));
    }
}
