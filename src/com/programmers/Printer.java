package com.programmers;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42587?language=java
 *
 * PriorityQueue 는 매번 정렬이 들어가서 느릴 수 밖에 없게 됨.
 * priorities 를 한번 정렬하고 최대 값의 커서 위치를 기억해두고 있으면, 굳이 PriorityQueue 를 사용할 필요가 없음
 * */
public class Printer {
    public static void main(String[] args) {
        Printer printer = new Printer();
//        int[] priorities = {2, 1, 3, 2};
        int[] priorities = {1, 1, 9, 1, 1, 1};
        System.out.println(printer.solution(priorities, 0));
    }


    public int solution(int[] priorities, int location) {
        Queue<Document> queue = new LinkedList<>();
        PriorityQueue<Integer> maxPriority = new PriorityQueue(Comparator.comparingInt(p -> (int) p).reversed());
        int result = 0;

        for (int id = 0; id < priorities.length; id++) {
            Document document = new Document(id, priorities[id]);
            queue.add(document);
            maxPriority.add(document.getPriority());
        }

        while(!maxPriority.isEmpty()) {
            Integer max = maxPriority.poll();

            Document document = null;
            while (!(document = queue.poll()).getPriority().equals(max)) {
                queue.add(document);
            }

            result++;

            if (document.getId().equals(location)) {
                return result;
            }
        }

        return result;
    }

    public static class Document {
        private Integer id;
        private Integer priority;

        public Document(Integer id, Integer priority) {
            this.id = id;
            this.priority = priority;
        }

        public Integer getId() {
            return id;
        }

        public Integer getPriority() {
            return priority;
        }
    }
}
