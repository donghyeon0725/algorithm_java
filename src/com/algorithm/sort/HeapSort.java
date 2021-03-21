package com.algorithm.sort;

public class HeapSort {
    static int[] arr = {47, 61, 21, 94, 97, 38, 31, 63, 71, 8, 52, 54, 19, 1, 74, 77, 13, 4, 39, 30, 6, 35, 60, 25, 51, 17, 42, 36, 18, 92, 55, 29, 67, 89, 41, 90, 78, 23, 70, 88, 98, 45, 69, 72, 28, 56, 62, 75, 100, 7, 64, 57, 24, 80, 33, 86, 50, 73, 44, 32, 3};

    /**
     * 트리구조를 만든다.
     * */
    public static void makeHeap(int[] arr, int end) {
        for (int i=0; i<=end; i++) {
            // 하나의 idx 를 기준으로 잡는다.
            int idx = i;

            // 자식노드가 더 큰 경우 교체
            while (arr[(idx - 1) / 2] < arr[idx]) {
                int temp = arr[idx];
                arr[idx] = arr[(idx - 1) / 2];
                arr[(idx - 1) / 2] = temp;

                // 인덱스를 부모 노드를 가리키도록 변경
                idx = (idx - 1) / 2;
            }
        }
    }

    /**
     * 최상단의 노드를 heapify 한다.
     * */
    public static void sort() {
        makeHeap(arr, arr.length-1);

        for (int i=arr.length-1; i>=0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 하나 작은 개수만큼만 다시 힙 구조로 만들어야 한다! 이 점 주의하자.
            makeHeap(arr, i-1);
        }
    }


    public static void main(String[] args) {
        sort();

        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
