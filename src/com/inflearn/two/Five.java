package com.inflearn.two;

import java.util.Scanner;

/**
 * 에라토스 채
 * */
public class Five {
    public int solution(int n) {
        int answer = 0;

        // n+1 크기 만큼 생성 1부터 n까지의 인덱스로 접근할 수 있음
        int[] nums = new int[n+1];

        // 2 번 인덱스부터
        for (int i=2; i<nums.length; i++) {

            // 1이면 이미 제외된 숫자
            if (nums[i] == 0) {
                answer++;
                for (int j = i; j<nums.length; j+=i) {
                    // i의 배수가 1이 아닐 경우만 1로 변경
                    if (nums[j] != 1) {
                        nums[j] = 1;
                    }
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Five T = new Five();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}
