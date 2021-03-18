package com.algorithm.sort;

public class BubbleSort {
    static int[] arr = {47, 61, 21, 94, 97, 38, 31, 63, 71, 8, 52, 54, 19, 1, 74, 77, 13, 4, 39, 30, 6, 35, 60, 25, 51, 17, 42, 36, 18, 92, 55, 29, 67, 89, 41, 90, 78, 23, 70, 88, 98, 45, 69, 72, 28, 56, 62, 75, 100, 7, 64, 57, 24, 80, 33, 86, 50, 73, 44, 32, 3};

    public static void main(String[] args) {
        bubbleSort();
    }

    /**
     * 버블 정렬
     * 인접한 두 값을 비교해서 변경해 가며 정렬하는 방법
     *
     * 장점 : 구현이 쉽다.
     * 단점 : O(n^2) 으로 느린 알고리즘인데다가, 값의 변경이 많아서 느리다. 선택 정렬보다 더 느리다.
     *
     * 시간 복잡도 : n * (n-1) / 2 => O(n)
     * */
    public static void bubbleSort() {
        int size = arr.length;

        for (int i=1; i<size; i++) {
            for (int j=0; j<size - i; j++) {
                if ( arr[j] > arr[j+1] ) {
                    int n = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = n;
                }
            }
        }

        for (int i=0; i<size; i++) {
            System.out.println(arr[i]);
        }
    }
}
