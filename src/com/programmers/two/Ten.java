package com.programmers.two;

import java.util.Stack;

public class Ten {


    public String solution(int n, int k, String[] cmd) {

       Memory memory = new Memory(n, k);

        for (String c : cmd)
            memory.execute(new Command(c));

        return memory.getResult();
    }

    private static class Memory {
        private int[] memory;
        private Stack<Integer> deleted = new Stack();
        private int cursor;
        private int buffer;

        public Memory(int size, int cursor) {
            memory = new int[size];
            this.cursor = cursor;
        }

        public void execute (Command command) {
            if (Type.DELETE.equals(command.type)) {
                flushAndClear();
                delete();
            }
            else if (Type.UP.equals(command.type))
                buffer -= command.getSpec();
            else if (Type.DOWN.equals(command.type))
                buffer += command.getSpec();
            else if (Type.RESTORE.equals(command.type)) {
                restore();
            }
        }

        public void flushAndClear() {
            if (buffer < 0)
                up(-buffer);
            else if (buffer > 0)
                down(buffer);

            buffer = 0;
        }

        public String getResult() {
            StringBuilder sb = new StringBuilder();
            String[] ox = {"O", "X"};

            for (int i : memory)
                if (i == 0)
                    sb.append(ox[0]);
                else
                    sb.append(ox[1]);

            return sb.toString();
        }

        // 마지막 인덱스 찾기
        private void resetCursor() {
            int cursor = this.cursor;
            int i = 1;

            while (cursor < memory.length - 1 && i > 0) {
                if (!isDeletedIndex(cursor + 1))
                    i--;
                cursor++;
            }

            if (i > 0) {
                cursor = this.cursor;

                while (cursor > 0 && i > 0) {
                    if (!isDeletedIndex(cursor - 1))
                        i--;
                    cursor--;
                }
            }

            this.cursor = cursor;
        }

        private void delete() {
            deleted.add(cursor);
            memory[cursor] = -1;

            resetCursor();
        }

        private boolean isDeletedIndex(int i) {
            return memory[i] != 0;
        }

        private void up(int i) {
            while (i > 0) {
                // 삭제 안된 경우
                if (!isDeletedIndex(cursor - 1))
                    i--;
                cursor--;
            }
        }

        private void down(int i) {
            while (i > 0) {
                if (!isDeletedIndex(cursor + 1))
                    i--;
                cursor++;
            }
        }

        private void restore() {
            Integer pop = deleted.pop();
            memory[pop] = 0;
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
        Ten ten = new Ten();
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};

        System.out.println(ten.solution(8, 2, cmd));

    }
}
