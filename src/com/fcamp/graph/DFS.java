package com.fcamp.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        int[][] edge = {
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        };

        Queue<Integer> result = new LinkedList<>();
        boolean[] visit = new boolean[edge.length];
        // 최근에 발견한 것 먼저
        Stack<Integer> discover = new Stack<>();
        discover.add(0);

        while (!discover.isEmpty()) {
            int search = discover.pop();

            // 탐색
            result.add(search);
            visit[search] = true;

            // 탐색 노드 주위로 연결 노드 탐색 예약
            for (int i = edge[search].length - 1; i >= 0 ; i--) {
                if (!visit[i] && edge[search][i] == 1) {
                    discover.add(i);
                }
            }

        }

        System.out.println(result.toString());
    }
}
