package com.programmers.one;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 * */
public class Seven {

    public int solution(String begin, String target, String[] words) {

        List<String> wordList = new ArrayList(Arrays.asList(words));

        if (!wordList.contains(target))
            return 0;

        String[] newWords = new String[words.length + 1];
        newWords[0] = begin;
        int end = 0;
        for (int i=0; i<words.length; i++) {
            newWords[i + 1] = words[i];
            if (words[i].equals(target)) {
                end = i + 1;
            }
        }


        // 시작 단어와 간선이 있는지 확인
        List<LinkedList<Integer>> graph = new ArrayList<>();
        for (int i=0; i<newWords.length; i++) {
            graph.add(new LinkedList());
        }

        // 단어와 차이가 오직 1개이면 간선이 있음
        for (int i=0; i<newWords.length; i++)
            for (int j=0; j<newWords.length; j++) {
                 if (isThereAnyRoad(newWords[i], newWords[j]))
                    graph.get(i).add(j);
            }


        boolean[] isDiscover = new boolean[newWords.length];
        isDiscover[0] = true;
        Queue<Integer> searchList = new LinkedList<>();
        searchList.add(0);

        int[] depth = new int[newWords.length];
        int[] parent = new int[newWords.length];

        while (!searchList.isEmpty()) {

            int searched = searchList.poll();

            LinkedList<Integer> g = graph.get(searched);


            for (int i=0; i<g.size(); i++) {
                int discovered = g.get(i);

                if (!isDiscover[discovered]) {
                    isDiscover[discovered] = true;
                    searchList.add(discovered);
                    parent[discovered] = searched;
                    depth[discovered] = depth[searched] + 1;
                }
            }

        }

        return depth[end];
    }


    public boolean isThereAnyRoad(String begin, String target) {
        int deff = 0;

        for (int i=0; i<begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i))
                deff++;
        }

        return deff == 1;
    }


    /**
     * 너비 우선 탐색 시작
     *
     * 시작 문자열을 기준으로 변환할 수 있는 모든 문자열을 찾고
     * 탐색해서, 가장 처음 target 으로 변환된 경로를 찾으면 된다.
     * */
    public int solution1(String begin, String target, String[] words) {

        int result = 0;

        boolean[] visit = new boolean[words.length];

        Queue<Node> searchList = new LinkedList<>();
        searchList.add(new Node(begin, 0));

        while (!searchList.isEmpty()) {

            Node searched = searchList.poll();

            if (searched.getStr().equals(target)) {
                result = searched.getDepth();
                break;
            }

            for (int i=0; i<words.length; i++)
                if (!visit[i] && searched.isThereEdge(words[i])) {
                    visit[i] = true;
                    searchList.add(new Node(words[i], searched.getDepth() + 1));
                }

        }

        return result;
    }

    static class Node {
        private String str;
        private int depth;

        public Node(String str, int depth) {
            this.str = str;
            this.depth = depth;
        }

        public String getStr() {
            return str;
        }

        public int getDepth() {
            return depth;
        }

        public boolean isThereEdge(String target) {
            int deff = 0;

            for (int i=0; i<str.length(); i++) {
                if (str.charAt(i) != target.charAt(i))
                    deff++;
            }

            return deff == 1;
        }
    }



    public static void main(String[] args) {
        Seven seven = new Seven();

        String begin = "hit";
        String target = "cog";

        String[] words = {"hot", "dot", "dog", "lot", "log"};

        System.out.println("seven = " + seven.solution1(begin, target, words));
    }
}
