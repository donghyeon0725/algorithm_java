package com.algorithm.sort;

public class MergeSort {
    private static int[] arr = {47, 61, 21, 94, 97, 38, 31, 63, 71, 8, 52, 54, 19, 1, 74, 77, 13, 4, 39, 30, 6, 35, 60, 25, 51, 17, 42, 36, 18, 92, 55, 29, 67, 89, 41, 90, 78, 23, 70, 88, 98, 45, 69, 72, 28, 56, 62, 75, 100, 7, 64, 57, 24, 80, 33, 86, 50, 73, 44, 32, 3};
    private static int[] temp = new int[arr.length];

    /**
     * 임의의 크기를 잡아서, 절반으로 나눈 뒤에 그것을 정렬한다.
     * */
    public static void merge(int[] arr, int start, int end) {
        // 시작점
        int l = start;
        // 중간 지점
        int m = ( start + end ) / 2;
        // 우측 배열의 시작점
        int r = m + 1;
        // 임의의 배열 temp를 가리킬 인덱스
        int t = start;

        // 좌측의 인덱스가 중간을 넘지 않을 때까지만, 우측의 인덱스가 끝을 넘지 않을 떼까지만
        while (l <= m && r <= end) {
            // 작은 값을 우선적으로
            if (arr[l] < arr[r]) {
                temp[t] = arr[l];
                l++;
            } else {
                temp[t] = arr[r];
                r++;
            }
            t++;
        }

        // 배열의 남은 값은 이미 정렬이 된 상태의 값이다. 해당 값을 담는다.
        // 이미 끝난 인덱스 반대편의 것을 정렬
        if (l > m) {
            for (int i=r; i<=end; i++) {
                temp[t] = arr[i];
                t++;
            }
        } else {
            for (int i=l; i<=m; i++) {
                temp[t] = arr[i];
                t++;
            }
        }


        //원래 있던 배열에 정렬
        for (int i=start; i<=end; i++) {
            arr[i] = temp[i];
        }
    }

    /**
     * 받은 정렬의 좌측과 우측을 재귀호출로 정렬하도록 하고, 자기 자신의 것도 최종 정렬한다.
     * */
    public static void mergeSort(int[] arr, int s, int e) {

        if ( s < e ) {
            int middle = ( s + e ) / 2;
            mergeSort(arr, s, middle);
            mergeSort(arr, middle+1, e);
            merge(arr, s, e);
        }
    }

    public static void main(String[] args) {
        mergeSort(arr, 0, arr.length-1);

        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
