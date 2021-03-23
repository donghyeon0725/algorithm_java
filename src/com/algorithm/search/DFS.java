package com.algorithm.search;

import com.algorithm.sort.Sort;
import org.junit.Test;

import java.util.*;

public class DFS {
    // 그래프의 인접 리스트 표현
    static List<List<Integer>> vertex;
    // 각 정점을 방문했는지
    static List<Boolean> visited;

    /**
     * 하나의 정정을 기준으로 인접한 정점을 모두 순회함
     * */
    static void visitVertex(int i) {
        // i번 index 방문
        visited.set(i, true);

        for (int n=0; n < vertex.get(i).size(); n++) {
            int nearVertex = vertex.get(i).get(n);

            // 방문하지 않았다면 방문처리
            if (!visited.get(nearVertex)) visitVertex(nearVertex);
        }
    }

    /**
     * 모든 정점을 순회하는 로직
     * 간선이 모두 이어져 있는지 모르기 때문에 직접 for문으로 vertex 전체를 한번 돌려줘야함
     * */
    static void visitVertexAll() {
        for (int i=0; i<vertex.size(); i++) {
            //아직 방문하지 않은 간선이면 방문한다.
            if (!visited.get(i)) visitVertex(i);
        }
    }

    /**
     * 이미지 : ./img/DFS.jpg
     *
     * 필요한 값들을 초기화 해준다
     * */
    static void init() {
        List<Integer> list_0 = new ArrayList<>();
        List<Integer> list_1 = new ArrayList<>();
        List<Integer> list_2 = new ArrayList<>();
        List<Integer> list_3 = new ArrayList<>();
        List<Integer> list_4 = new ArrayList<>();
        List<Integer> list_5 = new ArrayList<>();
        List<Integer> list_6 = new ArrayList<>();
        List<Integer> list_7 = new ArrayList<>();
        List<Integer> list_8 = new ArrayList<>();
        List<Integer> list_9 = new ArrayList<>();

        list_0.add(1);
        list_0.add(9);

        list_1.add(0);
        list_1.add(2);
        list_1.add(3);
        list_1.add(5);
        list_1.add(7);

        list_2.add(1);
        list_2.add(3);
        list_2.add(4);
        list_2.add(5);

        list_3.add(1);
        list_3.add(2);

        list_4.add(2);

        list_5.add(1);
        list_5.add(2);
        list_5.add(6);

        list_6.add(5);

        list_7.add(1);
        list_7.add(8);
        list_7.add(9);

        list_8.add(7);

        list_9.add(7);
        list_9.add(0);

        vertex = new ArrayList<>();
        visited = new ArrayList<>();

        vertex.add(list_0);
        vertex.add(list_1);
        vertex.add(list_2);
        vertex.add(list_3);
        vertex.add(list_4);
        vertex.add(list_5);
        vertex.add(list_6);
        vertex.add(list_7);
        vertex.add(list_8);
        vertex.add(list_9);

        // 모든 정점을 초기화 한다.
        for(int i=0; i<vertex.size(); i++) {
            visited.add(false);
        }

    }

    /**
     * 예제 : 두 정점이 서로 연결 되어 있는지 확인하는 방법
     *
     * 1. visitVertex(하나의 정점에 해당하는 인덱스);
     * 2. visited 의 값을 살핀다.
     * 3. 연결 되어 있다면 해당 노드의 boolean 값이 true
     * */
    static void isTwoVertexConnected() {
        init();

        visitVertex(4);

        for (int i=0; i<vertex.size(); i++) {
            System.out.println(visited.get(i));
        }
    }


    /**
     * 예제 : 연결된 부분집합의 개수 세기
     *
     * 이미지 : ./img/DFS_component.jpg
     * 위 사진 처럼 끊긴 정점의 집합을 컴포넌트 또는 요소라고 부름
     *
     * 연결된 부분집합의 개수는 컴포넌트의 개수를 세는 문제와 같다.
     * visitVertex() 를 수행하면, 인접한 모든 정점은 방문 상태가 되기 때문에
     * visitVertexAll() 에서 visitVertex가 호출되는 회수가 곧, 부분 집합의 개수이다.
     *
     * 1. visitVertexAll()
     * 2. 호출되는 visitVertex 회수를 센다.
     * */
    static void countSubset() {
        init();

        int setCount = 0;
        // 방문 상태를 확인 후에 모든 정점에 방문을 시도한다.
        for(int i=0; i<vertex.size(); i++) {

            if (!visited.get(i)) {
                setCount++;
                visitVertex(i);
            }
        }

        System.out.println(setCount);
    }

    /**
     * 위상 정렬
     *
     * 이미지 : ./img/DAG_sample.jpg
     *
     * 1. DAG (Directed Acyclic Graph : 단방향에 사이클이 없는 간선만 존재하는 그래프) 에서만 가능
     * 2. 어떤 정점에서 시작하고, 어떤 순서로 정점을 방문해야 DAG의 조건을 만족한 채, 수행할 수 있는지 알려주는 알고리즘
     * */
    private static List<List<Integer>> DAGVertex;
    private static List<Boolean> DAGVisited;
    private static Queue<Integer> queue = new LinkedList<>();;
    private static Stack stack = new Stack<>();

    static void DAGInit() {
        List<Integer> list_1 = new ArrayList<>();
        List<Integer> list_2 = new ArrayList<>();
        List<Integer> list_3 = new ArrayList<>();
        List<Integer> list_4 = new ArrayList<>();
        List<Integer> list_5 = new ArrayList<>();
        List<Integer> list_6 = new ArrayList<>();
        List<Integer> list_7 = new ArrayList<>();
        List<Integer> list_8 = new ArrayList<>();
        List<Integer> list_9 = new ArrayList<>();
        List<Integer> list_10 = new ArrayList<>();

        list_1.add(1);

        list_2.add(2);

        list_3.add(3);

        list_4.add(4);

        // list_5

        list_6.add(6);
        list_6.add(7);
        list_6.add(8);

        list_7.add(0);

        list_8.add(1);

        list_9.add(3);

        list_10.add(2);

        DAGVertex = new ArrayList<>();
        DAGVisited = new ArrayList<>();

        DAGVertex.add(list_1);
        DAGVertex.add(list_2);
        DAGVertex.add(list_3);
        DAGVertex.add(list_4);
        DAGVertex.add(list_5);
        DAGVertex.add(list_6);
        DAGVertex.add(list_7);
        DAGVertex.add(list_8);
        DAGVertex.add(list_9);
        DAGVertex.add(list_10);

        // 모든 정점을 초기화 한다.
        for(int i=0; i<DAGVertex.size(); i++) {
            DAGVisited.add(false);
        }
    }

    /**
     * 스택을 이용한 위상 정렬
     *
     * 방법 1.
     *      ** 간선이 하나도 없는 것 부터 찾아서 지워가는 방법
     *
     *      1. 간선이 하나도 없는 정점부터 찾는다.
     *      2. 스택에 넣고 해당 정점을 지운다.
     *      3. 1,2 과정을 반복한다.
     *      4. 과정이 모두 끝나면 스택의 자료를 순서대로 꺼낸다.
     * */
    static void topologicalSortWithStack() {
        DAGInit();

        for (int i=0; i<DAGVertex.size(); i++) {

            // 간선이 하나도 없는 정점을 찾아 제거 처리
            for (int j=0; j<DAGVertex.size(); j++) {
                // 아직 방문전(제거 전) 인데 크기가 0이다 => 간선이 없는 정점이다.
                if (!DAGVisited.get(j) && DAGVertex.get(j).size() == 0) {
                    stack.add(j);
                    // 해당 정점 제거 처리 (방문처리)
                    DAGVisited.set(j, true);
                    removeDAGVertex(j);
                }
            }
        }

        // 스택의 값을 꺼낸다.
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 정점을 지운다.
     * */
    static void removeDAGVertex(int idx) {
        // idx 를 바라보는 부모 정점에서 해당 값 제거
        for(int i=0; i<DAGVertex.size(); i++) {
            // 제거된 정점 방향으로 간선을 가진 정점
            for (int j=0; j<DAGVertex.get(i).size(); j++) {
                if (DAGVertex.get(i).get(j) == idx) {
                    DAGVertex.get(i).remove(j);
                }
            }
        }
    }

    /**
     * 큐를 이용한 위상 정렬
     *
     * 방법 2.
     *      ** 깊이 우선 탐색을 이용하는 방법
     *
     *      1. 모든 정점에 대해서 깊이 우선 탐색을 수행한다. visitVertexAll
     *      2. 정점을 방문할 때 마다, 해당 정점을 기록하는 방법, 즉 여기서는 visitVertex 가 한번 끝날 때 마다(visit이 true 처리 되는 순간) 정점을 큐에 쌓는다.
     *      3. 큐에 있는 순서대로 값을 꺼내면 종료 역순으로 값을 꺼내는 것과 마찬가지(먼저 끝난 것이 먼저 나옴)
     *
     *      주의 할 점은 이 과정이 종료될 시점*****에 기록을 쌓아야 한다는 점이다.
     * */
    static void visitDAGVertexAll() {
        DAGInit();

        for (int i=0; i<DAGVertex.size(); i++) {
            if (!DAGVisited.get(i))
                visitDAGVertex(i);
        }

        System.out.println("===============");
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    /**
     * 핵심은 종료할 시점에 찾는 것이다.
     * */
    static void visitDAGVertex(int idx) {
        DAGVisited.set(idx, true);

        //방문 처리가 안되어 있으면 재귀 호출
        for (int i=0; i<DAGVertex.get(idx).size(); i++) {
            int nextVertex = DAGVertex.get(idx).get(i);
            if (!DAGVisited.get(nextVertex))
                visitDAGVertex(nextVertex);
        }

        // 가장 일찍 종료 ( != 찾은 정점)된 정점 탐색 순으로 queue에 넣는다.
        queue.add(idx);
    }



}
