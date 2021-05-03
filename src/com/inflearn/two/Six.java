package com.inflearn.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 뒤집은 소수
 *
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하
 * 는 프로그램을 작성하세요. 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출
 * 력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다. 첫 자리부터의 연속된 0은 무시한다.
 *
 *
 * ▣ 입력설명
 * 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
 * 각 자연수의 크기는 100,000를 넘지 않는다.
 *
 * ▣ 출력설명
 * 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
 *
 * ▣ 입력예제 1
 * 9
 * 32 55 62 20 250 370 200 30 100
 *
 * ▣ 출력예제 1
 * 23 2 73 2 3
 * */
public class Six {

    // 기본 0으로 초기화 되어 있다. 0은 아직 탐색 전, 1은 소수가 아님(탐색은 마침). 2는 소수
    private static int[] arr = new int[1001];

    // 인스턴스를 초기화 하고 싶을 때는 그냥 괄호 열면 되지만, static 필드를 초기화 하고 싶은 경우에는 static 키워드를 사용해야 한다.
    static {
        // 1은 소수가 아님
        arr[1] = 1;
        // 2는 소수
        arr[2] = 2;


        int total = 1000;
        // 3부터 탐색 => 2는 이미 소수인 것을 안다.
        for (int i=3; i<=total; i++) {

            // 지금 탐색하려는 대상이 아직 0 이면 소수임 => 체에 걸러지지 않은 값임
            if (arr[i] == 0) {
                arr[i] = 2;
            }

            // 배수 모두 1로 만듬
            for (int target = i; target<=total; target += i) {
                // 탐색 전인 것만 탐색 => 소수의 2배수 3배수... 배수인 값은 전부 소수가 아님. 예를 들어 2는 소수이나 4는 소수가 아님
                if (arr[target] == 0) {
                    arr[target] = 1;
                }
            }
        }

    }

    public static String solution(int[] a) {
        List<Integer> result = new ArrayList<>();

        for (int t : a) {

            int target = 0;
            // 수를 역순으로 뒤집는 기술
            while (t > 0) {
                // 뒤집으려는 수의, 10으로 나눈 나머지를 계속 더하는 방법
                target = target * 10 + t % 10;
                // 뒤집으려는 수의 1의자리 수 제거
                t = t / 10;
            }

            if (isPrimeNumber(target)) {
                result.add(target);
            }

        }


        return Arrays.toString(result.toArray());
    }

    // 소수인지 판별
    public static boolean isPrimeNumber(int t) {
        if (arr[t] == 2) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        int[] input = {32,55,62,20,250,370,200,30,100};
        System.out.println(solution(input));
    }
}
