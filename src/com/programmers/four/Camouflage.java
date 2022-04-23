package com.programmers.four;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Camouflage {
    public int solution (String[][] clothes) {

        Map<String, Integer> closet = new HashMap<>();


        for (String[] c : clothes) {
            closet.put(c[1], closet.getOrDefault(c[1], 0) + 1);
        }

        int result = 1;

        for (Map.Entry<String, Integer> entry : closet.entrySet()) {
            result *= (entry.getValue() + 1);
        }
        return result - 1;
    }

    public static void main(String[] args) {
        Camouflage camouflage = new Camouflage();

        String[][] cloths = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(camouflage.solution(cloths));
    }
}
