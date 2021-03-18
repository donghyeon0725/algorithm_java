package com.algorithm.sort;

public class InsertSort {
    static int[] arr = {47, 61, 21, 94, 97, 38, 31, 63, 71, 8, 52, 54, 19, 1, 74, 77, 13, 4, 39, 30, 6, 35, 60, 25, 51, 17, 42, 36, 18, 92, 55, 29, 67, 89, 41, 90, 78, 23, 70, 88, 98, 45, 69, 72, 28, 56, 62, 75, 100, 7, 64, 57, 24, 80, 33, 86, 50, 73, 44, 32, 3};

    public static void main(String[] args) {
        insertSort();
    }

    /**
     * 삽입정렬
     * 정렬하는 범위를 넓혀 가면서 정렬한다. 범위에 들어온 새로운 값을 뒤에서 부터 비교해가며 값을 뒤로 밀어내고, 제자리에 찾아가는 방법이다.
     *
     * 삽입 정렬(揷入整列, insertion sort)은 자료 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여, 자신의 위치를 찾아 삽입함으로써 정렬을 완성하는 알고리즘이다.
     *
     * 장점 : 거의 정렬이 되어있는 값을 정렬할 때 상당히 빠르다. (일부 값만을 정렬하므로)
     * 단점 : 배열이 길어질수록 효율이 떨어진다
     * 시간 복잡도 : n * (n-1) / 2 => O(n)
     * */
    public static void insertSort() {
        int size = arr.length;

        for (int i=0; i<size; i++) {
            //새로 들어온 값
            int index = i;

            while ( (index > 0) && (arr[index - 1] > arr[index]) ) {
                int n = arr[index];
                arr[index] = arr[index-1];
                arr[index-1] = n;
                index--;
            }
        }

        for (int i=0; i<size; i++) {
            System.out.println(arr[i]);
        }
    }
}
