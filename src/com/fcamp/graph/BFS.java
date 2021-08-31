package com.fcamp.graph;

import java.util.*;

public class BFS {

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

        boolean[] visit = new boolean[edge.length];
        int[] depth = new int[edge.length];
        depth[0] = 1;
        Queue<Integer> result = new LinkedList<>();
        Queue<Integer> discover = new LinkedList<>();
        discover.add(0);


        while (!discover.isEmpty()) {
            int search = discover.poll();

            // 탐색
            result.add(search);
            visit[search] = true;

            // 탐색 노드 주위로 연결 노드 탐색 예약
            for (int i = 0; i < edge[search].length; i++) {
                if (!visit[i] && edge[search][i] == 1) {
                    discover.add(i);
                    // 깊이는 발견 노드 + 1
                    depth[i] = depth[search] + 1;
                }
            }
        }

        System.out.println(result.toString());
        System.out.println(Arrays.toString(depth));
    }

}
