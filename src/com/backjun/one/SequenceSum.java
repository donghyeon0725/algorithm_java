package com.backjun.one;

import java.util.Scanner;

public class SequenceSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int l = sc.nextInt();

        int result = 0;
        int offset = 0;


        while (result != n && l < 101) {

            // N 을 L 으로 나눈 수에서 L 만큼 뺀 수 부터 탐색을 시작한다.
            int start = ((n / l) - l > 0 ? (n / l) - l : 0) + offset;
            result = l * (l + 1) / 2 + (start - 1) * l;

            // 찾은 경우
            if (result == n) {
                break;

            // result 가 n 보다 크면 더 이상 offset 이 큰 경우를 탐색할 필요가 없음
            } else if (result > n) {
                l++;
                offset = 0;
                result = 0;
                continue;
            }

            result = 0;
            offset++;
        }


        if (l > 100 || result != n) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        int start = ((n / l) - l > 0 ? (n / l) - l : 0) + offset;

        for (int i=start; i<start + l; i++) {
            sb.append(i);

            if (i != start + l - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());

    }
}
