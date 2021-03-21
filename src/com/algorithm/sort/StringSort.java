package com.algorithm.sort;

public class StringSort {
    private static String[] str_arr = {"서준","예준","도윤","시우","주원","하준","지호","지후","준서","준우","현우","도현","지훈","건우","우진","선우","서진","민재","현준","연우","유준","정우","승우","승현","시윤","준혁","은우","지환","승민","지우","유찬","윤우","민성","준영","시후","진우"};

    public static void main(String[] args) {
        StringSort(str_arr, 0, str_arr.length-1);
        for (int i=0; i<str_arr.length; i++) {
            System.out.println(str_arr[i]);
        }
    }
    /**
     * 퀵 정렬로 정렬하기
     * */
    public static void StringSort(String[] arr, int start, int end) {
        /* 배열의 크기가 1이 되는 경우는 정렬하지 않도록 주의해야함. 만약 1인 경우를 포함하면 stackoverflow 에러가 남. */
        if (start >= end) {
            return;
        }

        String pivot = arr[start];

        int l = start+1;
        int r = end;

        // 피벗값이 제자리를 찾을 때까지 반복
        while (l < r) {
            while (l < end && arr[l].compareTo(pivot) < 0) {
                l++;
            }

            while (r > start && arr[r].compareTo(pivot) > 0) {
                r--;
            }

            // 엇갈리지 않은경우
            if (l < r) {
                String temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            } else {
                // 엇갈린 경우.
                // left를 기준으로 잡으면 안됨. 왜냐하면 마지막 크기가 2인 배열을 정렬할 때, l이 이동하지 않았을 수 있기 때문에 right 값과 비교해서 바꿔줘야 모든 배열이 정리가 됨
                String temp = arr[r];
                arr[r] = arr[start];
                arr[start] = temp;
            }
        }
        // 엇갈린 경우 while 문을 빠져나옴으로 여기에 넣을 수 있도록
        StringSort(arr, start, r-1);
        StringSort(arr, l, end);
    }


}
