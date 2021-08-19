package com.programmers.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Eight {


    public String solution(int n, int k, String[] cmd) {

        Memory memory = new Memory(k);
        int size = n;

        for (int i=0; i<n; i++)
            memory.add(i);

        for (String c : cmd)
            memory.execute(new Command(c));

        String result = memory.getResult(size);

        return result;
    }

    private static class Memory {
        private List<Integer> memory = new ArrayList<>();
        private Stack<Integer[]> deleted = new Stack();
        private int cursor;

        public Memory(int cursor) {
            this.cursor = cursor;
        }

        public void add(Integer num) {
            this.memory.add(num);
        }

        public void execute(Command command) {
            if (Type.DELETE.equals(command.type)) {
                delete();
            }
            else if (Type.UP.equals(command.type)) {
                up(command.getSpec());
            }
            else if (Type.DOWN.equals(command.type)) {
                down(command.getSpec());
            }
            else if (Type.RESTORE.equals(command.type)) {
                restore();
            }
        }

        public String getResult(int size) {
            StringBuilder sb = new StringBuilder();
            String[] ox = {"O", "X"};
            int cur = 0;
            for (int i=0; i<memory.size(); i++) {
                int til = memory.get(i);

                if (til == cur) {
                    sb.append(ox[0]);
                    cur++;
                } else {
                    while (cur < til) {
                        sb.append(ox[1]);
                        cur++;
                    }

                    sb.append(ox[0]);
                    cur++;
                }
            }

            while (cur < size) {
                sb.append(ox[1]);
                cur++;
            }

            return sb.toString();
        }

        private void delete() {
            deleted.add(new Integer[]{cursor, memory.get(cursor)});
            memory.remove(cursor);

            if (cursor >= memory.size())
                cursor -= 1;
        }

        private void up(int i) {
            this.cursor -= i;
        }

        private void down(int i) {
            this.cursor += i;
        }

        private void restore() {
            Integer[] pop = deleted.pop();
            memory.add(pop[0], pop[1]);

            if (pop[0] <= cursor)
                cursor += 1;
        }
    }

    static class Command {

        private static Type type;
        private static Integer spec;

        public Command(String str) {
            if (str.startsWith("U")) {
                type = Type.UP;
                spec = Integer.parseInt(str.split(" ")[1]);
            }
            else if (str.startsWith("D")) {
                type = Type.DOWN;
                spec = Integer.parseInt(str.split(" ")[1]);
            }
            else if (str.startsWith("C")) {
                type = Type.DELETE;
            }
            else if (str.startsWith("Z")) {
                type = Type.RESTORE;
            }
        }

        public Integer getSpec() {
            return spec;
        }
    }


    static enum Type {
        UP, DOWN, DELETE, RESTORE;
    }

    public static void main(String[] args) {
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
        Eight eight = new Eight();
        System.out.println(eight.solution(8, 2, cmd));
    }
}
