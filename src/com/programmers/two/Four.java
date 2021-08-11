package com.programmers.two;

import java.lang.reflect.Array;
import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12952?language=java
 * */
public class Four {


    /**
     * 깊이 우선 탐색
     *
     *
     * 하나의 체스 말을 a, b 에 놓았을 때 다음과 같은 라인은 사용할 수 없게 됨
     *
     * x = a
     * y = b
     * b = a + t1 (t1 는 이 식을 만족하는 값)
     * b = -a + t2
     *
     * 즉, 정리하면 다음과 같다
     * x = a
     * y = a
     * y = x + t1
     * y = -x + t2
     *
     * 따라서 다음 놓이는 체스 말은 위 식을 만족하지 않는 값 중에 선택 해야 합니다.
     *
     *
     * 계산을 하기 위해서 저장해야할 값은
     * 1. 체스 말이 놓인 좌표 모임 => 해시 코드
     * 2. 체스 말이 놓임에 따라서 추가될 계산식 {좌표, x, y, y = x + t1, y = -x + t2}
     * */
    public int solution(int n) {
        queen = new int[n][2];
        dfs(0, n);
        return result.size();
    }

    private List<int[]> formula = new ArrayList<>();
    private int[][] queen;
    private Set<Integer> result = new HashSet<>();

    public void dfs(int d, int n) {

        if (d == n) {
            result.add(Arrays.deepHashCode(queen));
            return;
        }

        int x = d;
        for (int y=0; y<n; y++) {
            boolean next = isNext(x, y);

            if (next) {
                formula.add(new int[] {x, y, y - x, y + x});
                queen[d] = new int[]{x, y};
                dfs(d + 1, n);
                formula.remove(formula.size() - 1);
                queen[d] = null;
            }
        }
    }

    public boolean isNext(int x, int y) {
        boolean next = true;

        for (int f=0; f<formula.size(); f++) {
            boolean on = false;
            int[] formu = formula.get(f);
            if (x == formu[0] || y == formu[1] || y == x + formu[2] || y == -x + formu[3])
                on = true;

            if (on) {
                next = false;
                break;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Four four = new Four();
        int n = 8;
        System.out.println(four.solution(n));
    }
}
