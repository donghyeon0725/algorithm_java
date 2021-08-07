package com.programmers.one;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43105
 * */
public class Five {

    private Integer max = Integer.MIN_VALUE;

    public int solution(int[][] triangle) {
        dfs(triangle, 0, 0, 0);
        return max;
    }

    /**
     * 깊이 우선 탐색
     *
     * 현재 경로로 부터 1단계 더 아래에 있는 (더 깊은) 값을 탐색
     * 현재 인덱스와 같은 값 또는 1 높은 값만 탐색
     *
     *
     * 시간 효율이 떨어 집니다
     * */
    public void dfs(int[][] triangle, int deep, int index, int cur) {

        // 마지막 => return
        if (deep >= triangle.length) {
            if (max < cur)
                max = cur;
            return;
        }

        // 다음 탐색
        dfs(triangle, deep+1, index, cur + triangle[deep][index]);
        dfs(triangle, deep+1, index+1, cur + triangle[deep][index]);
    }

    /**
     * 현재 탐색한 노드
     * triangle[d][i] = triangle[d-1][i]
     *
     * 좌측 노드에서 내려온 경우
     * 우측 노드에서 내려온 경우
     *
     * max[d][i] = max[d-1][i] + triangle[d][i]
     * max[d][i] = max[d-1][i-1] + triangle[d][i]
     *
     * 현재 탐색하려는 층의 노드 개수 만큼 배열을 만들어 탐색
     * */
    public int solution1(int[][] triangle) {
        int[][] max = new int[triangle.length][0];
        max[0] = new int[]{triangle[0][0]};

        // 1층 부터 탐색
        for (int d=1; d<triangle.length; d++) {
            int[] prevMax = max[d - 1];
            int[] curMax = new int[triangle[d].length];

            for (int i=0; i<curMax.length; i++) {
                // 좌측 끝인 경우
                if (i == 0)
                    curMax[i] = prevMax[i] + triangle[d][i];
                // 우측 끝인 경우
                else if (i == curMax.length - 1)
                    curMax[i] = prevMax[i - 1] + triangle[d][i];
                // 선택
                else
                    curMax[i] = Math.max(prevMax[i] + triangle[d][i], prevMax[i-1] + triangle[d][i]);
            }

            max[d] = curMax;
        }

        int result =  Integer.MIN_VALUE;
        int[] last = max[max.length - 1];

        for (int i=0; i<last.length; i++) {
            if (result < last[i])
                result = last[i];
        }


        return result;
    }

    /**
     * 탐색한 deep 와 index 만 가지고 있고, 해당 배열의 값을 더했을 때 최대 값인지 검사
     *
     * 동적 계획 법
     * 현재 탐색하려는 deep 와 index 가 동일 할 때
     * */
    public static void main(String[] args) {
        int[][] trig = {{7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5}};

        Five five = new Five();
        System.out.println(five.solution1(trig));
    }

}
