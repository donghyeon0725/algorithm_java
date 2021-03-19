package com.dataType.flo;

public class FloatTest {

    public static void main(String[] args) {
        double a = ((double)1/10)*(double)3;
        double b = ((double)3/10);

        System.out.println(doubleSum());                        // 100.09999999999859
        System.out.println(isTheDoublePerfectlySame(a, b));     // false
        System.out.println(isTheDoublePerfectlySimilar(a, b));  // true
        System.out.println(isTheDoubleSameWithGap(a, b));       // true
        System.out.println(permitGap(a, b));                    // 1.850371707708594E-16
    }

    /**
     * 두 수가 완전히 같은지 비교
     * */
    public static boolean isTheDoublePerfectlySame(double a, double b) {
        return a == b; // false
    }

    /**
     * 두 수가 완전히 같은지 비교
     * 일정 크기 차이 이하일 때
     * */
    public static boolean isTheDoublePerfectlySimilar(double a, double b) {
        return a - b < 1e-10; // true
    }

    /**
     * 두 수가 완전히 같은지 비교
     * 일정 크기 차이 이하일 때 2
     * */
    public static boolean isTheDoubleSameWithGap(double a, double b) {
        return Math.abs(a - b) < permitGap(a, b); // true
    }


    /**
     * 실수를 여러번 더하면 원하는 값과는 차이가 있음
     * */
    public static double doubleSum() {
        double num = 0.1;

        for(int i = 0; i < 1000; i++) {

            num += 0.1;

        }

        return num; //100.09999999999859
    }

    public static int isTheDoubleSame(double a, double b) {
        if ( a-b < permitGap(a, b)) {
            return 0;
        }

        if (a > b) return 1;
        else return -1;
    }

    /**
     * 오차 허용 범위 구하기
     * */
    public static double permitGap(double a, double b) {
        return Math.abs(a-b) / Math.max(a, b); // 1.850371707708594E-16
    }



}

