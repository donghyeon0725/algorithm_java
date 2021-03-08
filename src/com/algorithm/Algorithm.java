package com.algorithm;

public class Algorithm {

    public static void main(String[] args) {
        long aTime = 0;
        long bTime = 0;
        int result = 0;

        aTime = System.currentTimeMillis();
        result = sum_all_1(100000000);
        bTime = System.currentTimeMillis();
        System.out.println(bTime - aTime);

        aTime = System.currentTimeMillis();
        result = sum_all_2(100000000);
        bTime = System.currentTimeMillis();
        System.out.println(bTime - aTime);
    }

    /**
     1부터 n까지의 합 1 => O(n)
    */
    public static int sum_all_1(int n) { // 0.095 초
        int result = 0;
        for (int i=1; i<=n; i++) {
            result += i;
        }
        return result;
    }

    /**
     1부터 n까지의 합 2 => O(1)
     같은 문제 인데도, 알고리즘에 따라 시간복잡도가 다름
     */
    public static int sum_all_2(int n) {
        return n*(n+1)/2;
    } // 0.00000000001 초
}
