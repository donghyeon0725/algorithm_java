package com.programmers.one;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43105
 */
public class Five {

    private Integer max = Integer.MIN_VALUE;

    public int solution(int[][] triangle) {
        dfs(triangle, 0, 0, 0);
        return max;
    }

    /**
     * 깊이 우선 탐색
     * <p>
     * 현재 경로로 부터 1단계 더 아래에 있는 (더 깊은) 값을 탐색
     * 현재 인덱스와 같은 값 또는 1 높은 값만 탐색
     * <p>
     * <p>
     * 시간 효율이 떨어 집니다
     */
    public void dfs(int[][] triangle, int deep, int index, int cur) {

        // 마지막 => return
        if (deep >= triangle.length) {
            if (max < cur)
                max = cur;
            return;
        }

        // 다음 탐색
        dfs(triangle, deep + 1, index, cur + triangle[deep][index]);
        dfs(triangle, deep + 1, index + 1, cur + triangle[deep][index]);
    }

    /**
     * 좌측 노드에서 내려온 경우
     * 우측 노드에서 내려온 경우
     * <p>
     * max[d][i] = max[d-1][i] + triangle[d][i]
     * max[d][i] = max[d-1][i-1] + triangle[d][i]
     * <p>
     * 이 수중에, 최대 값만 선택하면 그만 (최대가 아닌 값은 버려도 됨)
     * 현재 탐색하려는 층의 노드 개수 만큼 배열을 만들어 탐색
     */
    public int solution1(int[][] triangle) {
        int[][] max = new int[triangle.length][0];
        max[0] = new int[]{triangle[0][0]};

        // 1층 부터 탐색
        for (int d = 1; d < triangle.length; d++) {
            int[] prevMax = max[d - 1];
            int[] curMax = new int[triangle[d].length];

            for (int i = 0; i < curMax.length; i++) {
                // 좌측 끝인 경우
                if (i == 0)
                    curMax[i] = prevMax[i] + triangle[d][i];
                    // 우측 끝인 경우
                else if (i == curMax.length - 1)
                    curMax[i] = prevMax[i - 1] + triangle[d][i];
                    // 선택
                else
                    curMax[i] = Math.max(prevMax[i] + triangle[d][i], prevMax[i - 1] + triangle[d][i]);
            }

            max[d] = curMax;
        }

        int result = Integer.MIN_VALUE;
        int[] last = max[max.length - 1];

        for (int i = 0; i < last.length; i++) {
            if (result < last[i])
                result = last[i];
        }


        return result;
    }


    /**
     * 기존의 배열을 그대로 이용하는 방법
     * <p>
     * 위에서 부터 0층, 1층, 2층.. n층 이라고 할때
     * 0층은 길이 1
     * 1층은 길이 2
     * 2층은 길이 3
     * ...
     * n층은 길이 n + 1
     * <p>
     * 현재 n층을 탐색한다고 가정하고 i번 째 노드까지 합을 node[n][i]라고 하면 다음과 같이 표현 가능
     * <p>
     * <p>
     * 촤측 위 노드에서 내려온 경우  : node[n][i] = m[n-1][i-1] + node[n][i]
     * 우측 위 노드에서 내려온 경우  : node[n][i] = m[n-1][i] + node[n][i]
     * <p>
     * 최대 값을 max[n][i]이라고 하면 우측 위에서 내려온 경우와 좌측 위에서 내려온 경우 중, 최대 값만 있으면 되기 때문에 다음과 같이 표현 가능
     * <p>
     * max[n][i] = Math.max(m[n-1][i-1] + node[n][i], m[n-1][i] + node[n][i])
     * <p>
     * 다시 식을 고치면
     * max[n][i] = node[n][i] + Math.max(m[n-1][i-1], m[n-1][i])
     * <p>
     * <p>
     * 예외 상황
     * => 좌측 끝 노드 값인 경우
     * node[n][0] = node[n - 1][0]
     * => 우측 끝 노드 값인 경우 (n 층의 max 인덱스는 n)
     * node[n][n] = node[n - 1][n - 1]
     */
    public int solution2(int[][] triangle) {

        // 0층이 아닌 1층 부터 탐색
        for (int n = 1; n < triangle.length; n++) {
            // 좌측 끝 노드
            triangle[n][0] += triangle[n - 1][0];
            triangle[n][n] += triangle[n - 1][n - 1];

            // 나머지 노드
            for (int i = 1; i < triangle[n].length-1; i++)
                triangle[n][i] += Math.max(triangle[n - 1][i - 1], triangle[n - 1][i]);
        }

        return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
    }

    /**
     * 탐색한 deep 와 index 만 가지고 있고, 해당 배열의 값을 더했을 때 최대 값인지 검사
     * <p>
     * 동적 계획 법
     * 현재 탐색하려는 deep 와 index 가 동일 할 때
     */
    public static void main(String[] args) {
        int[][] trig = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        Five five = new Five();
        System.out.println(five.solution2(trig));
    }

}
