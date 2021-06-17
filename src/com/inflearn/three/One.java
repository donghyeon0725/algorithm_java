package com.inflearn.three;

import java.util.Arrays;

/**
 * 두 배열 합치기
 *
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램
 * 을 작성하세요.
 *
 *
 * ▣ 입력설명
 * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 *
 * ▣ 출력설명
 * 오름차순으로 정렬된 배열을 출력합니다.
 *
 * ▣ 입력예제 1
 * 3
 * 1 3 5
 * 5
 * 2 3 6 7 9
 *
 * ▣ 출력예제 1
 * 1 2 3 3 5 6 7 9
 *
 *
 * 병합 정렬의 기본 방식
 * */
public class One {
    public static String solution(int[] a, int[] b) {
        // 인덱스를 두고
        int index = 0, index_a = 0, index_b = 0;
        int[] result = new int[a.length + b.length];

        while (index_a < a.length && index_b < b.length) {
            // 양 쪽에서 더 작은 거 먼저 배열에 쌓기
            if (a[index_a] > b[index_b]) {
                result[index++] = b[index_b++];
            } else {
                result[index++] = a[index_a++];
            }
        }

        // 남은 거 크기만큼 채워주기
        if (index_a < a.length) {
            while (index < result.length) {
                result[index++] = a[index_a++];
            }
        } else if (index_b < b.length) {
            while (index < result.length) {
                result[index++] = b[index_b++];
            }
        }

        return Arrays.toString(result);
    }


    public static void main(String[] args) {
        int[] a = {1,3,5};
        int[] b = {2,3,6,7,9};

        System.out.println(solution(a,b));
    }
}
