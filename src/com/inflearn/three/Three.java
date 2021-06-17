package com.inflearn.three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 최대 매출
 *
 * 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속
 * 된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
 * 12 15 11 20 25 10 20 19 13 15
 * 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
 * 여러분이 현수를 도와주세요.
 *
 *
 * ▣ 입력설명
 * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 *
 * ▣ 출력설명
 * 첫 줄에 최대 매출액을 출력합니다.
 *
 * ▣ 입력예제 1
 * 10 3
 * 12 15 11 20 25 10 20 19 13 15
 *
 * ▣ 출력예제 1
 * 56
 * */
public class Three {

    /**
     * 일반적으로 푸는 방법
     *
     * 시간 복잡도는 주어진 입력(arr)의 길이가 n이라고 할 때
     * O ( n ) 입니다.
     *
     * 한편
     * 이 문제에서 만약, 구간 평균 등등을 이용하기 위해 구간 합에 자주 접근해야할 수록
     * 여러번 계산 해야하기 때문에 비효율적인 문제가 있습니다.
     *
     * 따라서 부분합을 계산한 배열을 미리 만들어 놓는 방법이 있습니다.
     * 예를 들어서
     *
     * i        0  1   2   3   4   5   6   7   8
     * scores  100 97  86  79  66  52  49  42  31 의 배열이 있다면
     * sum     100 197 283 362 428 480 529 571 602 이런식으로 부분 합을 미리 계산해두면
     *
     * 66[6]점 ~ 49[4]점 구간의 합계 점수를 구하고 싶을 때는 sum[6] - sum[4-1] =  529 - 362 = 167 이 된다.
     *
     * 이는 특정 구간의 합을 O(1) 시간복잡도로 접근 할 수 있게 해준다.
     *
     * 부분 합계를 구할 때도, 부분합을 계속 구할 것이 아니라, 이전에 구해놓은 값에 새로운 값을 더하는 방식으로 해서 최적화를 한다.
     *
     * */
    public static int solution(int[] arr, int k) {

        List<Integer> result = new ArrayList<>();

        for (int i=0; i<arr.length + 1 - k; i++) {
            result.add(arr[i] + arr[i+1] + arr[i+2]);
        }

        return result.stream().max((a, b) -> {
            if (a > b) return 1;
            else if (a < b) return -1;
            else return 0;
        }).get();
    }

    // 최적화 한 풀이 방법
    private static int[] input = {12,15,11,20,25,10,20,19,13,15};
    private static int[] sum = new int[input.length];
    static {
        int value = 0;

        for (int i=0; i<input.length; i++) {
            value += input[i];
            sum[i] = value;
        }
    }

    public static int solution_1(int k) {
        List<Integer> result = new ArrayList<>();

        for (int i=0; i<input.length - k; i++) {
            result.add(sum[i + k] - sum[i]);
        }

        return result.stream().max((a, b) -> {
            if (a > b) return 1;
            else if (a < b) return -1;
            else return 0;
        }).get();
    }

    public static void main(String[] args) {
        int[] input = {12,15,11,20,25,10,20,19,13,15};
        System.out.println(solution(input, 3));
        System.out.println(solution_1( 3));

    }
}
