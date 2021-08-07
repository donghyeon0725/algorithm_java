package com.programmers.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43236
 * */
public class Three {
    /**
     * 바위 위치를 거리로 정렬을 한 뒤,
     * 바위 사이 거리를 모은 배열을 구하고
     * 그 사이 거리가 가장 짧은 것 부터 순서대로 바위를 제거하는 방법
     * 좌측과 우측의 바위중에 더 짧은 거리에 있는 바위와 합치기로 결정
     * */
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        List<Integer> dis = new ArrayList<>();

        dis.add(rocks[0] );
        for (int i=1; i<rocks.length; i++) {
            dis.add(rocks[i] - rocks[i - 1]);
        }
        dis.add(distance - rocks[rocks.length - 1]);

        int index = 0;
        int min = Integer.MAX_VALUE;

        for (int i=0; i<n; i++) {
            for (int j=0; j<dis.size(); j++) {
                if (min > dis.get(j)) {
                    min = dis.get(j);
                    index = j;
                }
            }

            // 최소 거리 구함
            if (index == 0) {
                int t = dis.get(1);
                dis.remove(1);
                dis.set(0, dis.get(0) + t);
            }
            else if (index == dis.size() - 1) {
                int t = dis.get(dis.size() - 1);
                dis.remove(dis.size() - 1);
                dis.set(dis.size() - 1, dis.get(dis.size()) + t);
            }
            else {
                int l = dis.get(index - 1);
                int r = dis.get(index + 1);

                if (l > r) {
                    // 우측 것과 더함
                    dis.remove(index + 1);
                    dis.set(index, dis.get(index) + r);
                } else {
                    int t = dis.get(index);
                    dis.remove(index);
                    dis.set(index - 1, t + l);
                }
            }

            min = Integer.MAX_VALUE;
        }

        return dis.stream().sorted().collect(Collectors.toList()).get(0);
    }

    /**
     * 이 문제의 distance 는 1,000,000,000 으로 매우 크기 때문에 이분 탐색을 진행해야 합니다.
     * 돌 사이 최소 거리는 0 보다 크고 distance 보다 작아야 하는데 이 거리를 T로 기준을 잡고,
     * 이 거리보다 사이거리가 가까운 돌이 있다면 제거한다.
     *
     * 이렇게 제거한 돌을 모두 모았을 때 n 보다 많다면 더 짧은 거리 T를 기준으로 탐색해봐야 하고,
     * n보다 적다면 사이 간격을 더 키워도 됩니다.
     * 이 때 거리를 구하는 기준을 이분 탐색으로 정해야 합니다.
     *
     * 탐색해야할 기준 거리를 T 라고 하고 제거한 돌의 개수를 R, 거리를 D라고 할 때 다음과 같이 탐색할 수 있습니다.
     *
     * T    R     D     n
     * 50   10   100    4   => 너무 많은 돌을 제거 했다. 더 짧은 거리 ((100 + 0) / 2) = 50 로 탐색
     * 25   6    100    4   => 아직 제거한 돌이 너무 많다. 더 짧은 거리 ((50 + 0) / 2) = 12.5 (12) 로 탐색
     * 12   2    100    4   => 제거할 수 있는 돌이 더 있다. 즉, 더 큰 거리인 ((25 + 12) / 2)  = 18.5 (18) 로 탐색
     *
     * 탐색을 멈추는 기준은 R = n 을 만족하는 값중 가장 큰 값을 선택
     * */
    public int solution1(int distance, int[] rocks, int n) {
        int result = 0;
        Arrays.sort(rocks);
        int[] rockList = new int[rocks.length + 2];

        rockList[0] = 0;
        for (int i = 0; i<rocks.length; i++) {
            rockList[i + 1] = rocks[i];
        }
        rockList[rockList.length - 1] = distance;

        int l = 0;
        int r = distance;

        while (l <= r) {
            int T = (l + r) / 2;
            int R = 0;
            // 이전 돌의 인덱스
            int i = 0;
            // 돌 제거하기 시작
            for (int j=1; j<rockList.length; j++) {


                // 2, 11, 14, 17, 21
                // 거리가 짧으면 돌 제거, 인덱스는 그대로
                if (rockList[j] - rockList[i] < T) {
                    R++;
                } else {
                    i = j;
                }
                // 마지막 돌부터 distance 까지 거리가 T 보다 짧으면 마지막 돌을 제거하는 것으로 결정
            }

            // 제거한 돌이 더 많으면 짧은 거리에서 찾아보기
            if (R > n) {
                r = T - 1;
            } else {
                // 제거한 돌이 더 적거나 같으면
                result = T;
                l = T + 1;
            }
        }

        return result;
    }


    public static void main(String[] args) {

        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
//        4 4 3 5
        int n = 2;


        Three three = new Three();
        System.out.println(three.solution1(distance, rocks, n));
    }
}
