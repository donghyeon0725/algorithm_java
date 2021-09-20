package com.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HateSameNumber {
    public int[] solution(int[] arr) {
        int last = arr[0];
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i=1; i<arr.length; i++) {
            if (last != arr[i]) {
                list.add(arr[i]);
            }
            last = arr[i];
        }

        return list.stream().mapToInt(s -> s.intValue()).toArray();
    }
}
