package com.backjun.one;

import java.util.*;

public class FriendNetwork {

    static class DisjoinSet {
        private int[] parent;
        private int[] size;
        private int[] rank;

        public DisjoinSet(int len) {
            this.parent = new int[len];
            this.size = new int[len];
            this.rank = new int[len];

            Arrays.fill(size, 1);
            for (int i=0; i<len; i++) parent[i] = i;
        }


        // findRoot
        public int findRoot(int t) {
            if (parent[t] == t) return t;
            return parent[t] = findRoot(parent[t]);
        }

        // union
        public void union(int a, int b) {
            int ra = findRoot(a);
            int rb = findRoot(b);

            if (ra == rb) return;

            // swap
            if (rank[ra] < rank[rb]) {
                int temp = ra;
                ra = rb;
                rb = temp;
            }

            parent[rb] = ra;
            size[ra] = size[ra] + size[rb];
            if (rank[ra] == rank[rb]) rank[ra]++;
        }

        public int getMaxOf(int t) {
            t = findRoot(t);
            return size[t];
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        while (test-- > 0) {

            Map<String, Integer> map = new HashMap<>();
            int index = 0;
            int len = sc.nextInt();
            DisjoinSet disjoinSet = new DisjoinSet(len * 2);

            for (int i=0; i<len; i++) {
                String from = sc.next();
                String to = sc.next();

                if (!map.containsKey(from)) map.put(from, index++);
                if (!map.containsKey(to)) map.put(to, index++);
                disjoinSet.union(map.get(from), map.get(to));

                System.out.println(disjoinSet.getMaxOf(map.get(from)));
            }
        }
    }
}
