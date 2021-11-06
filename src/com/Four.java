package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Four {
    public int[] solution(String s) {
        List<Integer> arr = new ArrayList<>();
        String last = "";
        int lastCount = 0;
        String[] strings = s.split("");

        for (String temp : strings) {
            if (!last.equals(temp) && !"".equals(last)) {
                arr.add(lastCount);
                lastCount = 0;
            }

            last = temp;
            lastCount += 1;
        }

        if (strings[0].equals(strings[strings.length - 1])) {
            int first = arr.get(0);
            arr.remove(0);
            arr.add(first + lastCount);
        } else {
            arr.add(lastCount);
        }


        int[] answer = new int[arr.size()];
        for (int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        Four four = new Four();
        System.out.println(Arrays.toString(four.solution("wowwow")));
    }
}
