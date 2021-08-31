package com.fcamp.grady;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Coin {

    public static void main(String[] args) {
        Map<Integer, Integer> count = new HashMap<>();
        Integer[] coins = {1, 50, 100, 500};
        int target = 4720;
        int total = 0;

        // 역순 정렬
        Arrays.sort(coins, Collections.reverseOrder());

        while (true) {
            if (target == 0)
                break;

            if (target >= coins[0]) {
                target -= coins[0];

                total++;
                count.put(coins[0], count.getOrDefault(coins[0], 0) + 1);
            } else
                coins = Arrays.copyOfRange(coins, 1, coins.length);
        }


        System.out.println(count.toString());
        System.out.println(total);
    }
}
