package com.fcamp.grady;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bag {
    public static void main(String[] args) {
        int capacity = 30;
        int worth = 0;
        Integer[][] all = {{20, 10}, {15, 12}, {10,10}, {25, 8}, {30, 5}};

        // 정렬은 1일 경우 앞에 나온 수가 되로 간다는 점만 기억하기
        Queue<Integer[]> goodsQueue = Arrays.stream(all).sorted((s1, s2) -> {
            if (s1[1] / (double) s1[0] - s2[1] / (double) s2[0] > 0)
                return -1;
            else
                return 1;
        }).collect(Collectors.toCollection(LinkedList::new));

        goodsQueue.forEach(s -> System.out.println(Arrays.toString(s)));

        while (true) {
            final Integer[] goods = goodsQueue.poll();
            if (capacity > goods[0]) {
                capacity -= goods[0];
                worth += goods[1];
            } else {
                // 남은 무게만큼
                int rest =  (int)(capacity / (double) goods[0] * 100);
                capacity = 0;
                worth += goods[1] * rest / 100;
                break;
            }
        }



        System.out.println(worth);

        // round 반올림
        // floor 내림
        // ceil 올림
    }
}
