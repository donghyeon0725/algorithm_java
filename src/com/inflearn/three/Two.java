package com.inflearn.three;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 공통원소 구하기
 *
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로
 * 그램을 작성하세요.
 *
 *
 * ▣ 입력설명
 * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
 * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
 * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 각 집합의 원소는 1,000,000,000이하의 자연수입니다.
 *
 * ▣ 출력설명
 * 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
 *
 * ▣ 입력예제 1
 * 5
 * 1 3 9 5 2
 * 5
 * 3 2 5 7 8
 *
 * ▣ 출력예제 1
 * 2 3 5
 * */
public class Two {

    /**
     * 정렬 알고리즘은 이미 시중에 매우 빠른 알고리즘이 나와있다.
     *
     * 따라서 정렬 한 뒤에 각각 인덱스를 처음 순서부터 비교하면 시간복잡도는
     * O(a + b) 가깝게 나올 것이다.
     * */
    public static String solution(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        List<Integer> result = new ArrayList<>();
        int index_a = 0, index_b = 0;

        while (index_a < a.length && index_b < b.length) {

            if (a[index_a] > b[index_b]) {
                index_b++;
            } else if (a[index_a] < b[index_b]) {
                index_a++;
            } else {
                result.add(a[index_a]);
                index_a++;
                index_b++;
            }
        }

        // 내림 차순으로 정렬하는 방법
        // result.sort(Collections.reverseOrder());

        // 배열을 내림 차순으로 정렬할 땐 이렇게 합니다.
        // Arrays.sort(temp, Collections.reverseOrder());

        return Arrays.toString(result.toArray());
    }

    // 일반적으로 우리가 생각할 수 있는 풀이 방법 => 일일이 비교해서 공통된 요소가 있으면 따로 빼서 정렬 시간 복잡도는 O(n^2)
    public static String solution_1(int[] a, int[] b) {

        List<Integer> result = new ArrayList<>();

        for (int i=0; i<a.length; i++) {
            for (int j=0; j<b.length; j++) {

                if (a[i] == b[j]) {
                    result.add(a[i]);
                    break;
                }
            }
        }

        // 역순으로 정렬하기
        // result.sort(Collections.reverseOrder());

        Collections.sort(result);

        return Arrays.toString(result.toArray());
    }

    public static void main(String[] args) {
        int[] a = {1,3,9,5,2};
        int[] b = {3,2,5,7,8};

        System.out.println(solution(a,b));
        System.out.println(solution_1(a,b));
    }
}
