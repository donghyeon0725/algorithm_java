package com.fcamp.graph;

import com.dataType.heap.Heap;

import java.util.*;

public class Prim {

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

        // findRoot
        public int findRoot(int a) {
            if (a == parent[a]) return a;
            return parent[a] = findRoot(parent[a]);
        }

        // union
        public void union(int a, int b) {
            a = findRoot(a);
            b = findRoot(b);

            // swap
            if (rank[b] > rank[a]) {
                int temp = a;
                a = b;
                b = temp;
            }


            parent[b] = a;
            if (rank[a] == rank[b]) rank[a]++;
        }

        // find
        public boolean find(int a, int b) {
            return findRoot(a) == findRoot(b);
        }
    }


    public Integer[][] solution(int[][] graph) {
        // 결과
        List<Integer[]> result = new ArrayList<>();

        // 현재 연결된 간선 => 늘 최소 값을 우선 정렬하도록
        PriorityQueue<Integer[]> edges = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // 연결된 정점 집합
        DisjointSet set = new DisjointSet(graph.length);

        // 0 번 선 => 연결된 간선 리스트 삽입
        for (int end = 0; end < graph[0].length; end++)
            if (graph[0][end] != 0)
                edges.add(new Integer[]{graph[0][end], 0, end});


        // 간선 중에서 가장 짧은 간선
        while (!edges.isEmpty()) {
            Integer[] edge = edges.poll();


            // 연결 안되어 있는 경우
            if (!set.find(edge[1], edge[2])) {
                // 사이 간선을 result에 setting
                set.union(edge[1], edge[2]);
                result.add(edge);

                int start = edge[2];
                // 새로 발견한 정점과 연결된 노드 삽입
                for (int end=0; end<graph[start].length; end++)
                    // 새로운 정점이고, 연결된 정점이 아니면 연결 간선 리스트에 추가
                    if (graph[start][end] != 0 && !set.find(start, end))
                        edges.add(new Integer[]{graph[start][end], start, end});
            }

            // 연결 되어 있으면 => 간선 리스트 제외

        }

        return result.toArray(new Integer[][]{});
    }

    public Integer[][] solution_optimization(int[][] graph) {
        // 결과
        List<Integer[]> result = new ArrayList<>();

        // 현재 연결된 간선 => 늘 최소 값을 우선 정렬하도록
        PriorityQueue<Integer[]> vertexies = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // 방문 여부 저장 할 배열
        boolean[] visit = new boolean[graph.length];

        // 가중치, 탐색할 노드 번호, 발견한 노드 번호
        vertexies.add(new Integer[]{0, 0, 0});

        // 가중치 최소 값을 업데이트 할 배열
        Integer[] min = new Integer[graph.length];
        for (int i=0; i<min.length; i++)
            min[i] = Integer.MAX_VALUE;


        while (!vertexies.isEmpty()) {
            Integer[] vertex = vertexies.poll();

            if (visit[vertex[1]]) continue;

            // 방문
            visit[vertex[1]] = true;

            // 뽑은 배열 저장 => 첫 값은 제외
            if (vertex[0] != 0)
                result.add(vertex);

            // 주변 배열의 가중치 계산
            int start = vertex[1];
            for (int end=0; end<graph[start].length; end++) {
                // 현재 저장한 최소 가중치보다 작으면 업데이트
                if (graph[start][end] != 0 && min[end] > graph[start][end])
                    min[end] = graph[start][end];

                // 방문 전이고 간선이 존재하면 => 현재까지 발견한 가중치 최소 값으로 저장
                if (!visit[end] && graph[start][end] != 0)
                    vertexies.add(new Integer[]{min[end], end, vertex[1]});
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

        Prim prim = new Prim();
        final Integer[][] solution = prim.solution(graph);
        final Integer[][] solution_optimization = prim.solution_optimization(graph);


        for (Integer[] s : solution)
            System.out.println("길이 = " + s[0] +  ", " + (char)(65 + s[1]) + " <=> " + (char)(65 + s[2]));

        System.out.println("=========================");
        for (Integer[] s : solution_optimization)
            System.out.println("길이 = " + s[0] +  ", " + (char)(65 + s[1]) + " <=> " + (char)(65 + s[2]));
    }

}
