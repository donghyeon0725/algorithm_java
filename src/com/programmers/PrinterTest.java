package com.programmers;

import java.util.*;

public class PrinterTest {
    public static void main(String[] args) {
        PrinterTest printer = new PrinterTest();
//        int[] priorities = {2, 1, 3, 2};
        int[] priorities = {1, 1, 9, 1, 1, 1};
        System.out.println(printer.solution(priorities, 0));
    }


    public int solution(int[] priorities, int location) {
        Queue<Document> queue = new LinkedList<>();

        int targetCursor = location;
        int count = 0;
        int size = priorities.length - 1;

        for (int id = 0; id < priorities.length; id++) {
            queue.add(new Document(id, priorities[id]));
        }
        Arrays.sort(priorities);

        while (!queue.isEmpty()) {
            Document document = queue.poll();

            if (document.getPriority().equals(priorities[size - count])) {
                count++;

                if (targetCursor == 0)
                    break;

                targetCursor--;
            } else {
                queue.add(document);
                targetCursor--;

                if (targetCursor < 0) {
                    targetCursor = queue.size() - 1;
                }
            }
        }
        return count;
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
