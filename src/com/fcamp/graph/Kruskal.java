package com.fcamp.graph;

import java.util.*;
import java.util.stream.Collectors;

public class Kruskal {
    static class DisjointSet {
        private int[] parent;
        private int[] rank;

        // 초기화
        public DisjointSet(int size) {
            this.parent = new int[size];
            this.rank = new int[size];

            for (int i=0; i<parent.length; i++)
                parent[i] = i;
        }

        // union
        public void union(int a, int b) {
            a = findParent(a);
            b = findParent(b);

            if (a == b) return;

            // a 에 높은 랭크가 오도록 정렬
            if (rank[b] > rank[a]) {
                int temp = a;
                a = b;
                b = temp;
            }

            // 더 낮은 높은 랭크가 root
            parent[b] = a;
            if (rank[a] == rank[b])
                rank[a]++;
        }

        // find
        public boolean find(int a, int b) {
            return findParent(a) == findParent(b);
        }

        // getParent
        public int findParent(int a) {
            if (parent[a] == a) return a;
            return parent[a] = findParent(parent[a]);
        }
    }

    public Integer[][] solution(int[][] graph) {
        List<Integer[]> result = new ArrayList<>();
        Queue<Integer[]> edges = new LinkedList<>();
        // 그래프 변환
        for (int start = 0; start < graph.length; start++) {
            for (int end = 0;  end <= start; end++) {
                if (graph[start][end] != 0)
                    edges.add(new Integer[]{graph[start][end], start, end});
            }
        }

        // 간선을 기준으로 정렬한다.
        edges = edges.stream().sorted((a, b) -> a[0] - b[0]).collect(Collectors.toCollection(LinkedList::new));

        // 사이클 여부 확인용 set
        DisjointSet set = new DisjointSet(edges.size());

        while (!edges.isEmpty()) {
            Integer[] edge = edges.poll();

            // 이어도 사이클을 이루지 않음
            if (!set.find(edge[1], edge[2])) {
                result.add(edge);
                set.union(edge[1], edge[2]);
            }
        }

        return result.toArray(new Integer[][]{});
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 7, 0, 5, 0, 0, 0},
                {7, 0, 8, 9, 7, 0, 0},
                {0, 8, 0, 0, 5, 0, 0},
                {5, 9, 0, 0, 7, 6, 0},
                {0, 7, 5, 7, 0, 8, 9},
                {0, 0, 0, 6, 8, 0, 11},
                {0, 0, 0, 0, 9, 11, 0}
        };

        Kruskal kruskal = new Kruskal();
        final Integer[][] solution = kruskal.solution(graph);


        for (Integer[] s : solution)
            System.out.println("길이 = " + s[0] +  ", " + (char)(65 + s[1]) + " <=> " + (char)(65 + s[2]));
    }
}
