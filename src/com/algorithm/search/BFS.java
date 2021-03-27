package com.algorithm.search;

import java.util.*;
import java.util.stream.Collectors;

public class BFS {

    // 그래프의 인접 리스트 표현
    static List<List<Integer>> graph;
    // 각 정점의 방문 여부
    static List<Boolean> discovered = new ArrayList<>();
    // 방문할 정점을 저장하는 큐
    static Queue<Integer> queue = new LinkedList();

    // start 에서 시작해, 그래프를 너비 우선 탐색하고 강 정점의 방문 순서를 반환한다.
    static List<Integer> search(int start) {
        // 정점의 방문 순서
        List<Integer> order = new ArrayList<>();

        discovered.set(start, true);
        queue.add(start);

        while (!queue.isEmpty()) {
            int here = queue.poll();
            // 방문한 정점을 담는다.
            order.add(here);

            // 인접한 리스트를 가져와 살핀다.
            for (int i=0; i<graph.get(here).size(); i++) {
                int there = graph.get(here).get(i);

                // 발견 되지 않은 곳이면 탐색할 목록에 넣고 발견 처리를 한다.
                if (!discovered.get(there)) {
                    queue.add(there);
                    discovered.set(there, true);
                }
            }

        }

        return order;
    }

    static void init() {
        graph = new ArrayList<>();

        List<Integer> list_0 = new ArrayList<>();
        List<Integer> list_1 = new ArrayList<>();
        List<Integer> list_2 = new ArrayList<>();
        List<Integer> list_3 = new ArrayList<>();
        List<Integer> list_4 = new ArrayList<>();
        List<Integer> list_5 = new ArrayList<>();
        List<Integer> list_6 = new ArrayList<>();
        List<Integer> list_7 = new ArrayList<>();
        List<Integer> list_8 = new ArrayList<>();

        list_0.add(1);
        list_0.add(2);
        list_0.add(3);
        list_0.add(4);

        list_1.add(0);
        list_1.add(2);
        list_1.add(6);

        list_2.add(0);
        list_2.add(1);
        list_2.add(7);

        list_3.add(0);
        list_3.add(5);

        list_4.add(0);

        list_5.add(3);
        list_5.add(6);

        list_6.add(1);
        list_6.add(5);
        list_6.add(7);

        list_7.add(2);
        list_7.add(6);
        list_7.add(8);

        list_8.add(7);


        graph.add(list_0);
        graph.add(list_1);
        graph.add(list_2);
        graph.add(list_3);
        graph.add(list_4);
        graph.add(list_5);
        graph.add(list_6);
        graph.add(list_7);
        graph.add(list_8);

        for (int i=0; i<9; i++) {
            discovered.add(false);
        }
    }

    public static void main(String[] args) {
        init();
        List<Integer> list = searchPath(0);
        list.forEach(System.out::println);
    }

    // start에서 시작해 그래프를 너비 우선 탐색하고 시작점부터 각 정점까지의 최단 거리와 너비 우선 탐색 스패님 트리를 계산한다.
    // distance[i]=start 부터 i 까지 최단거리
    // parent[i] = 너비 우선 탐색 스패닝 트리에서 i의 부모의 번호, 루트인 경우 자신의 번호
    static List<Integer> searchPath(int start) {
        // 발견하지 못했을 경우 -1, 발견한 경우 0보다 큰 값을 가짐. 이때 각 숫자는, 몇번 너비 우선 탐색을 수행했는가 이다
        List<Integer> distance = new ArrayList<>();
        // parent 는 이어지는 경로를 찾기 위해서, 발견한 정점과 이어진 정점이 어떤 정점이었는지를 기억하기 위함이다.
        List<Integer> parent = new ArrayList<>();

        for (int i=0; i<graph.size(); i++) {
            distance.add(-1);
            // ArrayList에도 index가 있어서, 배열 범위 바깥의 인덱스에 접근하려고 하면 에러가 난다.
            // 따라서, 미리 값을 세팅해주어야 한다.
            parent.add(-1);
        }

        // 방문할 정점 목록을
        // queue
        distance.set(start, 0);
        parent.set(start, start);
        queue.add(start);

        while(!queue.isEmpty()) {
            int here = queue.poll();

            // here의 모든 인접한 정점을 검사
            for (int i=0; i<graph.get(here).size(); i++) {
                int there = graph.get(here).get(i);

                // 아직 찾은 경로가 아니면
                if (distance.get(there) == -1) {
                    queue.add(there);
                    // 깊이를 저장
                    distance.set(there, distance.get(here) + 1);
                    // 인접한 정점의 관계를 저장
                    // there 의 부모는 here 임에 주의해야함.
                    // 자식 정점(나중에 찾은 정점)은 같은 부모 정점을 가질수 없는 이유는, 한번 발견 된 후에는 다시 발견 될 수 없기 때문이다.
                    parent.set(there, here);
                }
            }
        }

        return shortestPath(8, parent);
    }

    /**
     * 위에서 찾은 부모 관계를 기반으로 최단 경로를 찾는다.
     * */
    static List<Integer> shortestPath(int v, List<Integer> parent) {
        List<Integer> path = new ArrayList<>();

        // 정점에서 꺼낸 부모 값과 스스로의 값이 같으면, 루트이다. => 탐색 종료
        while(parent.get(v) != v) {
            v = parent.get(v);
            path.add(v);
        }

        path.sort(Collections.reverseOrder());
        return path;
    }
}
