package com.sort;

import java.util.ArrayList;

public class Sort {
    static int[] arr = {47, 61, 21, 94, 97, 38, 31, 63, 71, 8, 52, 54, 19, 1, 74, 77, 13, 4, 39, 30, 6, 35, 60, 25, 51, 17, 42, 36, 18, 92, 55, 29, 67, 89, 41, 90, 78, 23, 70, 88, 98, 45, 69, 72, 28, 56, 62, 75, 100, 7, 64, 57, 24, 80, 33, 86, 50, 73, 44, 32, 3};

    /**
     * 주석을 풀고 하나씩 실행 해보세요.
     * */
    public static void main(String[] args) {
        //버블정렬
        //bubbleSort();

        //선택정렬
        //selectSort();

        //삽입정렬
        //insertSort();


        //퀵정렬
        quickSort(arr, 0, arr.length-1);

        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
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
     */
    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = array[start];
        int i=start+1,j=end;

        while(i < j) { // 엇갈리면 그만 둠

            while (i < end && array[i] <= pivot) {
                // i가 end보다 작을 때까지만, array[i]가 피벗보다 작은 것을 발견하면 그만 둠
                i++;
            }
            while (j > start && array[j] >= pivot) {
                // j가 start 보다 클 때까지만, array[j]가 피벗보다 크면 그 때 그만 둠
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
        quickSort(array, i, end);
    }

}
