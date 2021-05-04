package com.inflearn.two;

import java.util.Scanner;

/**
 * 피보나치 수열
 *
 * 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는
 * 수열이다.
 *
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면
 * 된다.
 *
 *
 * ▣ 입력설명
 * 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
 *
 * ▣ 출력설명
 * 첫 줄에 피보나치 수열을 출력합니다.
 *
 * ▣ 입력예제 1
 * 10
 *
 * ▣ 출력예제 1
 * 1 1 2 3 5 8 13 21 34 55
 * */
public class Four {

    /**
     * 배열을 사용한 방법
     * */
    public int solution_1(int n) {
        int answer = 0;

        int[] nums = new int[n];

        // 첫 두 수는 값을 채워 넣는다. ( n > 2)
        nums[0] = 1;
        nums[1] = 1;

        // 피보나치 수열을 만든다.
        for (int i=2; i<n; i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }

        // 피보나치 수열을 출력한다.
        for (int i=0; i<n; i++) {
            if (i < n-1) {
                System.out.print(nums[i] + " ");
            } else {
                System.out.print(nums[i]);
            }
        }

        return answer;
    }


    /**
     * 바로 출력하는 방법
     * */
    public void solution(int n) {
        int answer = 0;

        int b1 = 1;
        int b2 = 1;

        // 첫 두개의 숫자를 먼저 출력한다.
        System.out.print(1 + " " + 1 + " ");

        // n보다 2 작은 값(기본값 제외)까지 반복
        for (int i=0; i<n-2; i++) {
            int temp = b2;
            b2 += b1;
            b1 = temp;

            // 마지막 출력의 경우 공백 없이 출력이 되어야 함
            if (i < n-3) {
                System.out.print(b2 + " ");
            } else {
                System.out.print(b2);
            }
        }
    }

    public static void main(String[] args) {
        Four T = new Four();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        T.solution(n);
    }
}
