package com.inflearn.two;

import java.util.Scanner;

/**
 * 에라토스 채
 * */
public class Five {
    public int solution(int n) {
        int answer = 0;

        int[] nums = new int[n+1];

        for (int i=2; i<nums.length; i++) {

            if (nums[i] == 0) {
                answer++;
                for (int j = i; j<nums.length; j+=i) {
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
