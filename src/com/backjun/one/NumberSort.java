package com.backjun.one;

import java.util.Arrays;
import java.util.Scanner;

public class NumberSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int[] arr = new int[len];



        for (int i=0; i<len; i++) {
            arr[i] = sc.nextInt();
        }

        int[] temp = {47, 61, 21, 94, 97, 38, 31, 63, 71, 8, 52, 54, 19, 1, 74, 77, 13, 4, 39, 30, 6, 35, 60, 25, 51, 17, 42, 36, 18, 92, 55, 29, 67, 89, 41, 90, 78, 23, 70, 88, 98, 45, 69, 72, 28, 56, 62, 75, 100, 7, 64, 57, 24, 80, 33, 86, 50, 73, 44, 32, 3};
        mergeSort(temp, 0, temp.length - 1);
        System.out.println(Arrays.toString(temp));
    }

    public static void bubble(int[] arr) {

        for (int i=0; i<arr.length - 1; i++) {
            for (int j=i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        // 피벗을 기준으로 양쪽 정렬
        int left = start + 1;
        int right = end;
        int pivot = arr[start];

        // 2칸짜리 배열을 정렬할 때, left 와 right 의 차이는 0이 됩니다.
        // 2칸 크기로 범위가 줄어들었을 때, 해당 배열 또한 정렬할 수 있도록 left < right 이 아니라, left <= right
        while (left <= right) {

            // 같은 값은 일정하게 한쪽 위치로 정렬해야함 && left 는 end 와 같은 값을 포함 합니다. 만약 end 보다 크면, 범위를 벗어납니다.
            while (left <= end && arr[left] <= pivot ) {
                left++;
            }

            // start 는 피벗이기 때문에 포함하면 안됨.
            // 피벗과 크기가 같은 값은, 한쪽 방향으로 정렬하기 위해서 포함합니다. arr[right] > pivot 에서 arr[right] >= pivot 이 아닌 이유
            while (right > start && arr[right] > pivot) {
                right--;
            }

            // 엇갈리지 않았으면
            // left 와 right 가 같은 경우도 엇갈린 경우에 포함합니다.
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            } else {
                // right 위치에 피벗 => right 의 위치가 정렬된 왼쪽 값의 가장 마지막 위치이다. (left 는 우측 정렬 범위에 들어감)
                int temp = arr[start];
                arr[start] = arr[right];
                arr[right] = temp;
            }
        }

        // 피벗을 기준으로 양쪽을 다시 쿽솔트
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

    public static void merge(int[] arr, int start, int end) {

        int left = start;
        int right = (start + end) / 2 + 1;
        int[] temp = new int[end - start + 1];
        int index = 0;


        while (left <= (start + end) / 2 && right <= end)
            if (arr[left] > arr[right])
                temp[index++] = arr[right++];
            else
                temp[index++] = arr[left++];


        while (left <= (start + end) / 2)
            temp[index++] = arr[left++];

        while (right <= end)
            temp[index++] = arr[right++];

        index = 0;
        for (int i=start; i<=end; i++)
            arr[i] = temp[index++];
    }

    // 계속 범위를 쪼갠 뒤, 정렬
    public static void mergeSort(int[] arr, int start, int end) {

        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, start, end);
        }
    }
}
