package com.backjun.one;

import java.util.Map;
import java.util.Scanner;

public class Z {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = (int) Math.pow(2, n);
        System.out.println(solution(size, 0, sc.nextInt(), sc.nextInt()));
    }

    // 전체 행을 탐색하기 때문에 시간이 오래걸린다
//    private static int count = 0;
//    private static int row;
//    private static int column;
//    public static void solution(int size, int y, int x) {
//        if (size == 1) {
//            if (row == y && column == x)
//                System.out.println(count);
//            count++;
//            return;
//        }
//
//        int len =  size / 2;
//        solution(len, y, x);
//        solution(len, y, x + len);
//        solution(len, y + len, x);
//        solution(len, y + len, x + len);
//    }

    public static int solution(int size, int root, int y, int x) {
        if (size == 1) return root;

        size = size / 2;
        if (x / size == 0 && y / size == 0) {
            return solution(size, root, y, x);
        } else if (x / size == 1 && y / size == 0) {
            return solution(size, root + (size * size), y, x - size);
        } else if (x / size == 0 && y / size == 1) {
            return solution(size, root + 2 * (size * size), y - size, x);
        } else {
            return solution(size, root + 3 * (size * size), y - size, x - size);
        }
    }
}
