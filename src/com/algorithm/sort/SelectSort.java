package com.algorithm.sort;

public class SelectSort {
    static int[] arr = {47, 61, 21, 94, 97, 38, 31, 63, 71, 8, 52, 54, 19, 1, 74, 77, 13, 4, 39, 30, 6, 35, 60, 25, 51, 17, 42, 36, 18, 92, 55, 29, 67, 89, 41, 90, 78, 23, 70, 88, 98, 45, 69, 72, 28, 56, 62, 75, 100, 7, 64, 57, 24, 80, 33, 86, 50, 73, 44, 32, 3};

    public static void main(String[] args) {
        selectSort();
    }

    /**
     * 선택 정렬
     * 계속 반복해서 리스트를 훑으면서 가장 작은 값을 하나 결정하고 그것을 앞에서 부터 정렬해 넣는 방법
     *
     * 장점 : 메모리가 제한적일 때 성능상의 이점을 가져갈 수 있다.
     * 단점 : 시간복잡도가 O(n^2)으로 좋지 못하나 모든 경우에서 버블 정렬보다는 성능이 좋다.
     *
     * 시간 복잡도 : n * (n-1) / 2 => O(n^2)
     * */
    public static void selectSort() {
        int size = arr.length;

        int min;
        int index = 0;
        for (int i=0; i<size-1; i++) {
            min = Integer.MAX_VALUE;
            /* 최소값을 찾는다. */
            for (int j=i; j<size; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }

            int n = arr[i];
            arr[i] = arr[index];
            arr[index] = n;
        }


        for (int i=0; i<size; i++) {
            System.out.println(arr[i]);
        }
    }
}
