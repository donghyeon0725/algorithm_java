package com.algorithm.disjoint;

import java.util.List;

public class Disjoint_set {
    /**
     * 각각의 인덱스가 하나의 데이터라고 보고,
     * 인덱스의 parent를 저장할 배열만 하나 생성 했다.
     * */
    static class Node {
        int[] parent;

        public Node(int n) {
            parent = new int[n];
            for (int i=0; i<n; i++) {
                parent[i] = i;
            }
        }

        /**
         * 루트 노드의 인덱스를 반환
         * */
        int find(int u) {
            if (u == parent[u]) return u;
            return find(parent[u]);
        }

        void merge(int u, int v) {
            u = find(u); v = find(v);

            // 이미   같은 노드에 속하는 경우
            if (u == v) return;
            parent[u] = v;
        }
    }

    /**
     * 합칠 때
     * 높이가 더 낮은 노드를 높은 노드 아래에 합침으로 써,
     * 트리의 높이가 과도하게 높아지는 것을 막을 수 있음
     *
     * 이것으로 높이 h인 높이의 트리를 만드려면 n개의 노드가 필요하다고 가정한다면,
     * h+1인 트리를 만드려면 2n개의 노드가 필요하다.
     * 즉, 이제 시간복잡도는 O(n)에서 O(logn)이 되었다.
     *
     * 그리고, 노드를 타고 가서 부모 노드를 찾았을 때, 해당 경로에 있는 모든 노드의 값을
     * 루트 노드를 바라보게 바꾸어 준다면 다음 find 에 필요한 시간 복잡도는 O(a(n))이 될 것
     *
     * a(n) 은 애커만 함수이다.
     * 쉽게 압축하면 n이 우리가 상상할 수 있는 대부분의 큰 수를 넣어도 4를 넘기 어렵다. 따라서
     * O(4) 정도로 바라보면 될 것 이다.
     * */
    static class Node1 {
        int[] parent;
        int[] rank;

        public Node1(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i=0; i<n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        /**
         * parent[n] = find(parent[n])
         * 이 부분을 유념해서 본다.
         *
         * 찾으려는 노드를 n 이라고 하고,
         * 부모 노드를 p라고 하면,
         * 트리에서 n 상단에 있는 모든 노드는
         * p를 바라보도록 설정한다.
         *
         * 이를 압축 최적화라고 함
         *
         * 상호 배타적 집합에서, find는 재귀 호출로 구현 되기 때문에 위와 같은 수행을 간편하게 할 수 있는 것
         ***/
        int find(int n) {
            if (n == parent[n]) return n;
            // parent[n] 노드에 최종적으로 찾은 값을 넣어줌
            return parent[n] = find(parent[n]);
        }

        void merge(int v, int u) {
            v = find(v); u = find(u);
            if (v == u) return;

            // 항상 v에 더 큰 집합의 루트 노드를 위치시킴
            if (rank[u] > rank[v]) {
                int t = v;
                v = u;
                u = t;
            }

            parent[u] = v;
            // 높이가 같을 때만 증가한다.
            if (rank[u] == rank[v]) rank[v] += 1;
        }

    }

    /**
     * 집합의 크기를 찾는 로직을 담음
     * merge 할 때, 각각의 집합의 크기를 합쳐주면 된다.
     * */
    static class Node2 {
        int[] cities;
        int[] rank;
        int[] size;

        public Node2(int n) {
            cities = new int[n];
            rank = new int[n];
            size = new int[n];
            for (int i=0; i<n; i++) {
                cities[i] = i;
                rank[i] = 1;
                size[i] = 1;
            }
        }

        // 대표 노드를 찾음
        int find(int n) {
            if (n == cities[n]) return n;
            return cities[n] = find(cities[n]);
        }

        // 같은 대표 노드를 바라보는 경우 return
        void merge(int v, int u) {
            v = find(v); u = find(u);
            if (v == u) return;

            // 항상 v에 큰값이 오도록
            if (rank[u] > rank[v]) {
                int temp = v;
                v = u;
                u = temp;
            }

            cities[u] = v;

            // 대표 노드 쪽에 사이즈를 더해줌
            size[v] += size[u];
            if (cities[v] == cities[u]) rank[v]++;
        }
    }

    static class Node3 {
        int[] cities;
        int[] rank;

        public Node3(int n) {
            cities = new int[n];
            rank = new int[n];

            for (int i=0; i<n; i++) {
                cities[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int n) {
            if (cities[n] == n) return n;
            return cities[n] = find(cities[n]);
        }

        void merge(int c1, int c2) {
            c1 = find(c1); c2 = find(c2);

            if (c1 == c2) return;

            if (rank[c2] > rank[c1]) {
                int temp = c1;
                c1 = c2;
                c2 = temp;
            }

            // 이제 c1 이 무조건 더 높은 집합임
            cities[c2] = c1;

            if (rank[c1] == rank[c2]) rank[c1]++;
        }

        boolean isRoadConnected(int c1, int c2) {
            c1 = find(c1); c2 = find(c2);
            return c1 == c2;
        }
    }

    public static void main(String[] args) {
        /**
         * 상호적 베타집합
         * */
        Node node = new Node(7);
        node.merge(1,2);
        node.merge(2,3);
        node.merge(3,4);

        System.out.println(node.find(4));
        System.out.println(node.find(6));
        System.out.println("==================");

        /**
         * 상호적 베타 집합 최적화
         */
        Node1 node1 = new Node1(7);
        node1.merge(1,2);
        node1.merge(2,3);
        node1.merge(3,4);

        System.out.println(node1.find(4));
        System.out.println(node1.find(6));
        System.out.println("==================");

        /**
         * 집합의 크기 구하기
         */
        Node2 node2 = new Node2(7);
        node2.merge(1,2);
        node2.merge(2,3);
        node2.merge(3,4);

        System.out.println(node2.size[node2.find(4)]); // 4
        System.out.println(node2.size[node2.find(6)]); // 1
        System.out.println("==================");

        /**
         * 두 도시가 연결되어 있는지
         */
        Node3 node3 = new Node3(7);
        node3.merge(1,2);
        System.out.println(node3.isRoadConnected(1,3));
    }

}
