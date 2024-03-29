package com.fcamp.graph;

import java.util.Arrays;

public class DisjoinSet {

    static class JointSet {
        private int[] parent;
        private int[] rank;
        private int[] size;

        // 초기화
        public JointSet(int len) {
            parent = new int[len];
            rank = new int[len];
            size = new int[len];


            for (int i=0; i<parent.length; i++)
                parent[i] = i;
            for (int i=0; i<rank.length; i++)
                rank[i] = 1;
            for (int i=0; i<size.length; i++)
                size[i] = 1;
        }


        // union
        public void union(int a, int b) {

            // 기존 값 그대로 사용하는 스킬
            a = findRoot(a);
            b = findRoot(b);

            if (a == b) return;

            // a 에 높은 랭크가 오도록 정렬
            if (rank[b] > rank[a]) {
                int temp = a;
                a = b;
                b = temp;
            }

            // 더 낮은 높은 랭크가 root
            parent[b] = a;
            size[a] += size[b];

            if (rank[a] == rank[b])
                rank[a]++;
        }

        // 이 부분을 재귀 함수로도 만들 수 있음
        public boolean findWithWhile(int a, int b) {
            while (a != parent[a]) a = parent[a];
            while (b != parent[b]) b = parent[b];

            return a == b;
        }

        public boolean findWithRecursive(int a, int b) {
            return findRoot(a) == findRoot(b);
        }

        // 부모 노드를 찾아오는 메소드
        public int findRoot(int n) {
            if (n == parent[n]) return n;
            return parent[n] = findRoot(parent[n]);
        }

        public int getMaxSize() {
            return Arrays.stream(size).max().getAsInt();
        }


    }

    public static void main(String[] args) {
        JointSet set = new JointSet(7);
        set.union(1, 2);
        set.union(2, 3);
        set.union(3, 4);

        System.out.println(set.findWithWhile(1, 4));
        System.out.println(set.findWithWhile(1, 5));
        System.out.println(set.findWithRecursive(1, 4));
        System.out.println(set.findWithRecursive(1, 5));

        System.out.println(set.getMaxSize());
    }
}
