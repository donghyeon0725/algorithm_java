package com.algorithm.sort;

public class QuickSort {
    static int[] arr = {47, 61, 21, 94, 97, 38, 31, 63, 71, 8, 52, 54, 19, 1, 74, 77, 13, 4, 39, 30, 6, 35, 60, 25, 51, 17, 42, 36, 18, 92, 55, 29, 67, 89, 41, 90, 78, 23, 70, 88, 98, 45, 69, 72, 28, 56, 62, 75, 100, 7, 64, 57, 24, 80, 33, 86, 50, 73, 44, 32, 3};

    public static void main(String[] args) {
        quickSort(arr, 0, arr.length-1);

        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 퀵정렬
     *
     * 1 2 3 4 5 6 7 8 9 10
     * 선택 정렬일 때 : O(N^2) => 100
     *
     * 퀵정렬은 분할 해서 하므로
     * 1 2 3 4 5 => 5 * 5 = 25
     * 6 7 8 9 10 => 5 * 5 = 25
     *
     * 쪼갤수록 더더욱 적어지기 때문에 빅-오 수치가 Log로 나옴 (나누어서 한다는 특성)
     * 깔끔한 구현을 위해서 재귀함수를 호출하는 경우가 많음
     *
     * 시간 복잡도는 O(n*logn)
     */
    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = array[start];
        int i=start+1,j=end;

        while(i <= j) { // 엇갈리면 그만 둠

            while (i <= end && array[i] <= pivot) {
                // i가 end보다 작을 때까지만, array[i]가 피벗보다 큰은 것을 발견하면 그만 둠
                i++;
            }
            while (j > start && array[j] >= pivot) {
                // j가 start 보다 클 때까지만, array[j]가 피벗보다 작은면 그 때 그만 둠
                j--;
            }

            if (i < j) { // 만약에 둘이 엇갈리지 않았다면
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            } else {
                // 엇갈린 경우
                int temp = array[start];
                array[start] = array[j];
                array[j] = temp;
            }
        }
        quickSort(array, start, j-1);
        quickSort(array, j + 1, end);
    }
}
