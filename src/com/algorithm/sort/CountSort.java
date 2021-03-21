package com.algorithm.sort;

import java.util.Arrays;

public class CountSort {

    private static int[] arr = {47, 61, 21, 94, 97, 38, 31, 63, 71, 8, 52, 54, 19, 1, 74, 77, 13, 4, 39, 30, 6, 35, 60, 25, 51, 17, 42, 36, 18, 92, 55, 29, 67, 89, 41, 90, 78, 23, 70, 88, 98, 45, 69, 72, 28, 56, 62, 75, 100, 7, 64, 57, 24, 80, 33, 86, 50, 73, 44, 32, 3};

    public static void main(String[] args) {
        countSort(arr);
    }

    /**
     * 계수정렬하기
     * */
    public static void countSort(int[] arr) {
        int aaa = 0;

        Arrays.sort(arr);
        int max = arr[arr.length-1];

        int[] tempRepository = new int[max];

        // 개수 0개로 초기화
        for (int i=0; i<tempRepository.length; i++) {
            tempRepository[i] = 0;
        }

        for (int i=0; i<arr.length; i++) {
            // 자신의 저장소에 개수를 1 더해줌
            tempRepository[arr[i]-1] += 1;
        }

        // 정렬된 값을 원래 배열에 담아줌
        int a=0;
        // tempRepository 의 인덱스
        int r=0;
        while (r<max) {
            // 0보다 크면
            if (tempRepository[r] > 0) {
                // 그 크기만큼 반복해서 값을 넣어줌
                for (int t=0; t<tempRepository[r]; t++) {
                    arr[a] = (r+1);
                    a++;
                }
            }
            r++;
        }

        // 출력하기
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}