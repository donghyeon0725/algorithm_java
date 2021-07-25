package com.programmers.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @See https://programmers.co.kr/learn/courses/30/lessons/42586?language=java
 *
 * */
public class One {

    /**
     * 모든 작업 물에 스피드를 더한다.
     * 가장 처음의 기능이 100가 되어 개발이 되면
     * 다음 progresses를 찾아서 개발이 진행 되지 않은 기능이 있을 때까지
     * 모든 progresses 를 찾는다.
     * 개수를 result에 담고, progress를 제거한 뒤에, 같은 일을 반복한다.
     * */
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        while (progresses.length > 0) {
            for (int i=0; i<progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            // 기능이 완료 되었으면 다음 완료된 기능까지 찾음
            if (progresses[0] >= 100) {
                int complete = 0;
                while (progresses.length > 0 && progresses[0]>=100) {
                    progresses = Arrays.copyOfRange(progresses, 1, progresses.length);
                    speeds = Arrays.copyOfRange(speeds, 1, speeds.length);
                    complete++;
                }

                list.add(complete);
            }
        }

        return list.stream().mapToInt(s -> (int)s).toArray();
    }

    /**
     * 첫 기능이 100 가 되는 날이 며칠인지 구한 다음
     * 해당 일자를 이용해서, 다음 기능이 완성 되었는지 계속 구해 나아간다.
     *
     * 그리고, 완성 안된 기능이 있다면 또 100가 될때까지 날짜를 더해가다가 끝나면
     * 과정도 끝냄
     * */
    public static int[] solution1(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        while (progresses.length > 0) {
            for (int i=0; i<progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            // 기능이 완료 되었으면 다음 완료된 기능까지 찾음
            if (progresses[0] >= 100) {
                int complete = 0;
                while (progresses.length > 0 && progresses[0]>=100) {
                    progresses = Arrays.copyOfRange(progresses, 1, progresses.length);
                    speeds = Arrays.copyOfRange(speeds, 1, speeds.length);
                    complete++;
                }

                list.add(complete);
            }
        }

        return list.stream().mapToInt(s -> (int)s).toArray();
    }


    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] result = solution(progresses, speeds);


        for(int i : result)
            System.out.println(i);
    }
}
