package com.inflearn.one;

import java.util.Arrays;

/**
 * 단어 뒤집기
 *
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 *
 *
 * ▣ 입력설명
 * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
 * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되
 * 어 있습니다.
 *
 *
 * ▣ 출력설명
 * N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
 *
 * ▣ 입력예제 1
 * 3
 * good
 * Time
 * Big
 *
 *
 * ▣ 출력예제 1
 * doog
 * emiT
 * giB
 *
 * */
public class Four {

    public static String solution(String str) {
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i=arr.length-1; i>=0; i--) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    public static String solution_1(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String solution_2(String str) {
        char[] arr = str.toCharArray();

        int left = 0, right = arr.length-1;

        // 좌우에서 양 끝 배열 값을 교체
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        String[] arr = {"good", "Time", "Big"};

        for (String s : arr) {
            System.out.println(solution(s));
            System.out.println(solution_1(s));
            System.out.println(solution_2(s));
        }

    }
}
