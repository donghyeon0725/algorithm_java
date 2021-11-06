package com;

import java.util.Arrays;

public class Five {
    public int[][] solution(int rows, int columns) {

        int[][] arr = new int[rows][columns];
        int r = 0, c = 0, now = 1;
        int min = rows > columns ? columns : rows;
        int max = rows > columns ? rows : columns;

        if (max % min == 0) {
            arr[r][c++] = now++;

            while (!(r == 0 && c == 0)) {
                if (now % 2 == 0) {
                    arr[r++][c] = now++;
                } else {
                    arr[r][c++] = now++;
                }

                r = r % rows;
                c = c % columns;
            }

            return arr;
        }

        // 반복 되지 않는 경우
        arr[r][c++] = now++;

        while (atLeastOneZero(arr)) {
            if (now % 2 == 0) {
                arr[r++][c] = now++;
            } else {
                arr[r][c++] = now++;
            }

            r = r % rows;
            c = c % columns;
        }

        return arr;
    }

    public boolean atLeastOneZero(int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                if (arr[i][j] == 0)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Five five = new Five();
        int row = 3, columns = 4;

        int[][] result = five.solution(row, columns);

        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
