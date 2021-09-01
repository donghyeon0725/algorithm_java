package com.fcamp.graph;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        Integer[][] graph_arr = {
                {0, 8, 1, 2, 0, 0},
                {0, 0, 5, 0, 0, 0},
                {0, 5, 0, 2, 0, 0},
                {0, 0, 0, 0, 3, 5},
                {0, 0, 0, 0, 0, 1},
                {5, 0, 0, 0, 0, 0}
        };

        List<Integer[]>[] graph_list = new List[6];
        for (int i=0; i<graph_list.length; i++)
            graph_list[i] = new LinkedList();

        graph_list[0].add(new Integer[]{1, 8});
        graph_list[0].add(new Integer[]{2, 1});
        graph_list[0].add(new Integer[]{3, 2});
        graph_list[1].add(new Integer[]{2, 5});
        graph_list[2].add(new Integer[]{1, 5});
        graph_list[2].add(new Integer[]{3, 2});
        graph_list[3].add(new Integer[]{4, 3});
        graph_list[3].add(new Integer[]{4, 5});
        graph_list[4].add(new Integer[]{5, 1});
        graph_list[5].add(new Integer[]{0, 5});


        System.out.println(Arrays.toString(Dijkstra.solution1(graph_arr, 0)));
        System.out.println(Arrays.toString(Dijkstra.solution2(graph_list, 0)));

    }

    // 인접 행렬 방식으로 풀이
    public static Integer[] solution1(Integer[][] graph, Integer start) {
        PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new Integer[]{start, 0});
        Integer[] min = new Integer[graph.length];

        for (int i=0; i < min.length; i++) {
            if (i == start)
                min[i] = 0;
            else
                min[i] = Integer.MAX_VALUE;
        }

        while (!queue.isEmpty()) {
            // 노드 탐색
            Integer[] search = queue.poll();


            // 탐색하려는 노드의 최소 거리 값이 현재 발견한 거리 값보다 크면 무시
            if (search[1] > min[search[0]])
                continue;

            // 인접 노드의 값이 배열 값보다 작으면 업데이트
            for (int i=0; i<graph[search[0]].length; i++) {
                // 간선이 있는 노드와 거리 찾음
                Integer weight = graph[search[0]][i];

                if (weight > 0) {
                    Integer newLength = min[search[0]] + weight;
                    Integer existLength = min[i];
                    // 부모 까지의 거리 + weight 와 현재 탐색하려는 노드까지 발견된 최소 값 중, 더 작은 값
                    if (newLength < existLength) {
                        min[i] = newLength;
                        queue.add(new Integer[]{i, newLength});
                    }
                }
            }
        }

        return min;
    }

    // 인접 리스트 방식으로 풀이
    public static Integer[] solution2(List<Integer[]>[] graph, Integer start) {
        PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new Integer[]{start, 0});
        Integer[] min = new Integer[graph.length];

        for (int i=0; i < min.length; i++) {
            if (i == start)
                min[i] = 0;
            else
                min[i] = Integer.MAX_VALUE;
        }

        while (!queue.isEmpty()) {
            Integer[] search = queue.poll();

            if (search[1] > min[search[0]])
                continue;

            // 인접 노드 탐색
            for (int i=0; i<graph[search[0]].size(); i++) {
                Integer[] vertex = graph[search[0]].get(i);

                Integer oldLen = min[vertex[0]];
                Integer newLen = vertex[1] + min[search[0]];

                if (newLen < oldLen) {
                    min[vertex[0]] = newLen;
                    queue.add(new Integer[]{vertex[0], newLen});
                }
            }
        }

        return min;
    }
}
