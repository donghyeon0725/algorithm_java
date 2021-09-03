package com.fcamp.graph;

import java.util.Stack;

public class NQueen {
    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        System.out.println(nQueen.solution(8));
    }

    Stack<Integer[]> place = new Stack<>();
    Stack<Integer[]> stack = new Stack<>();
    int count = 0;

    public int solution(int n) {
        for (int i=1; i<=n; i++)
            dfs(1, i, n);

        return count;
    }

    public void dfs(int row, int column, int stop) {


        if (isNext(row, column)) {
            place.add(new Integer[]{row, column});

            if (row < stop) {
                for (int i = 1; i <= stop; i++)
                    dfs(row + 1, i, stop);
            } else
                count++;

            place.pop();
        }
    }

    public boolean isNext(int row, int column) {
        // 조건 탐색
        for (int i=0; i<place.size(); i++) {
            Integer[] old = place.get(i);

            // 열이 동일하면 or 행의 차이분 만큼 열도 차이가 날때
            if (old[1] == column || Math.abs(old[0] - row) == Math.abs(old[1] - column))
                return false;
        }
        return true;
    }
}
