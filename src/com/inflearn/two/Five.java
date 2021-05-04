package com.inflearn.two;

import java.util.Scanner;

/**
 * 에라토스테네스 채
 *
 * 소수(에라토스테네스 체)
 *
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 * 제한시간은 1초입니다.
 *
 *
 * ▣ 입력설명
 * 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
 *
 * ▣ 출력설명
 * 첫 줄에 소수의 개수를 출력합니다.
 *
 * ▣ 입력예제 1
 * 20
 *
 * ▣ 출력예제 1
 * 8
 * */
public class Five {
    public int solution(int n) {
        int count = 0;

        // n+1 크기 만큼 생성 1부터 n까지의 인덱스로 접근할 수 있음
        int[] nums = new int[n+1];

        // 2 번 인덱스부터
        for (int i=2; i<nums.length; i++) {

            // 1이면 이미 제외된 숫자
            if (nums[i] == 0) {
                count++;
                for (int j = i; j<nums.length; j+=i) {
                    // i의 배수가 1이 아닐 경우만 1로 변경
                    if (nums[j] != 1) {
                        nums[j] = 1;
                    }
                }
            }
        }


        return count;
    }

    public static void main(String[] args) {
        Five T = new Five();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}
