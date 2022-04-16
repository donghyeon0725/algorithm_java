package com.programmers.four;

import java.util.HashMap;
import java.util.Map;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 * */
public class Marathon {
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap(participant.length);

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, Integer.valueOf(0)) + 1);
        }

        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }


        Integer one = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (one.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        Marathon marathon = new Marathon();
        System.out.println(marathon.solution(participant, completion));;
    }
}
