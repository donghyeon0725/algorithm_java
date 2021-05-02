package com.inflearn.one;

import java.util.Arrays;

/**
 * 가장 짧은 문자거리
 *
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출
 * 력하는 프로그램을 작성하세요.
 *
 *
 * ▣ 입력설명
 * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 * 문자열의 길이는 100을 넘지 않는다.
 *
 * ▣ 출력설명
 * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 *
 * ▣ 입력예제 1
 * teachermode e
 *
 * ▣ 출력예제 1
 * 1 0 1 2 1 0 1 2 2 1 0
 * */
public class Ten {
    public static int[] solution(String str, char target) {
        char[] arr = str.toCharArray();

        int distance = 1000;

        int[] distance_arr_1 = new int[arr.length];

        for (int i=0; i<arr.length; i++) {
            if (arr[i] == target) {
                distance = 0;
            } else {
                distance++;
            }

            distance_arr_1[i] = distance;
        }

        str = new StringBuilder(str).reverse().toString();
        arr  = str.toCharArray();
        int[] distance_arr_2 = new int[arr.length];

        for (int i=0; i<arr.length; i++) {

            if (arr[i] == target) {
                distance = 0;
            } else {
                distance++;
            }

            distance_arr_2[i] = distance;
        }

        for (int i=0; i<arr.length; i++) {
            distance_arr_1[i] = Math.min(distance_arr_1[i], distance_arr_2[(arr.length - 1) - i]);
        }

        return distance_arr_1;
    }

    // 위 방법을 개선
    public static int[] solution_1(String str, char target) {
        int distance = 1000;

        int[] distance_arr_1 = new int[str.length()];
        int[] distance_arr_2 = new int[str.length()];

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == target) {
                distance = 0;
            } else {
                distance++;
            }

            distance_arr_1[i] = distance;
        }

        distance = 1000;
        str = new StringBuilder(str).reverse().toString();

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == target) {
                distance = 0;
            } else {
                distance++;
            }

            distance_arr_2[i] = distance;
        }


        for (int i=0; i<distance_arr_1.length; i++) {
            distance_arr_1[i] = Math.min(distance_arr_1[i], distance_arr_2[ (str.length()-1) - i]);
        }

        return distance_arr_1;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("teachermode", 'e')));
        System.out.println(Arrays.toString(solution_1("teachermode", 'e')));

    }
}
