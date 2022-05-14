package com.programmers.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionDevelop {
    public int[] solution(int[] progresses, int[] speeds) {

        int index = 0;
        int capacity = progresses.length;
        List<Integer> result = new ArrayList<>();

        while (index < capacity) {


            for (int i=index; i<progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            int count = 0;

            if (progresses[index] >= 100) {
                for (int i=index; i<progresses.length; i++) {
                    if (progresses[i] >= 100) {
                        count++;
                        index++;
                    } else {
                        break;
                    }
                }
            }

            if (count > 0) {
                result.add(count);
            }
        }

        return result.stream().mapToInt(s -> s).toArray();
    }

    public int[] solution2(int[] progresses, int[] speeds) {
        int index = 0, day = 0;
        List<Integer> result = new ArrayList<>();

        while (index < progresses.length) {
            day++;
            int count = 0;

            for (int i=index; i<progresses.length; i++) {
                if (progresses[i] + speeds[i] * day >= 100) {
                    count++;
                    index++;
                } else {
                    break;
                }
            }
            if (count > 0)
                result.add(count);
        }

        return result.stream().mapToInt(s -> s).toArray();
    }

    public static void main(String[] args) {
        FunctionDevelop develop = new FunctionDevelop();
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(develop.solution2(progresses, speeds)));
    }
}
