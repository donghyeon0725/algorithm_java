package com.programmers.one;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42897
 */
public class Four {

    /**
     * 단순히 한집 건너 한집을 터는 방법
     */
    public int solution(int[] money) {
        int one = 0;
        int two = 0;

        for (int i = 0; i < money.length; i++) {
            if (i % 2 == 0)
                one += money[i];
            else
                two += money[i];
        }

        return Math.max(one, two);
    }

    private int max = Integer.MIN_VALUE;

    /**
     * 재귀 호출을 이용한 깊이 우선 탐색
     */
    public void dfs(int search, int[] isVisit, int[] money) {

        // 마지막까지 탐색을 마친 경우
        if (search >= isVisit.length) {
            int total = 0;
            for (int i = 0; i < isVisit.length; i++)
                if (isVisit[i] == 1)
                    total += money[i];

            if (max < total)
                max = total;
            return;
        }


        // search 보다 최소 2 이상 큰 수를 탐색. 최대 2를 더 넘는 수 까지는 탐색
        for (int i = search + 2; i < isVisit.length + 2; i++) {
            // 탐색
            isVisit[search] = 1;
            dfs(i, isVisit, money);
            isVisit[search] = 0;
        }
    }


    public int solution1(int[] money) {
        int[] isVisit = new int[money.length];

        dfs(0, isVisit, money);
        dfs(1, isVisit, money);

        return max;
    }


    /**
     * 가장 많은 돈을 털어내려면
     * 몇집을 건너 띄어야 할 수도 있음
     * 단, 절대 인접한 집은 털면 안됨
     * <p>
     * 깊이 우선 탐색으로 1개 건너부터 천천히 탐색 해본다.
     * <p>
     * 4 개씩 나누어 계산한 값의 최대 값을 모두 더하는 방법은 어떨까?
     */
    public int solution2(int[] money) {

        int result = 0;
        int i = 0;

        for (i = 0; i < money.length; i += 50) {
            if (money.length > 50) {
                int[] copy = Arrays.copyOfRange(money, i, i + 50);
                int[] isVisit = new int[copy.length];

                dfs(0, isVisit, copy);
                dfs(1, isVisit, copy);
                result += max;
                max = Integer.MIN_VALUE;
            } else {
                int[] copy = Arrays.copyOfRange(money, i, money.length);
                int[] isVisit = new int[copy.length];

                dfs(0, isVisit, copy);
                dfs(1, isVisit, copy);
                result += max;
                max = Integer.MIN_VALUE;
            }
        }

        // i 가
        if (i < money.length) {
            int[] copy = Arrays.copyOfRange(money, i - 50, money.length);
            int[] isVisit = new int[copy.length];

            dfs(0, isVisit, copy);
            dfs(1, isVisit, copy);
            result += max;
        }


        return result;
    }


    /**
     *
     * 이 집을 털 수 있는 경우와 이 집을 털 수 없는 경우 중에서
     * 더 많은 금액을 보유할 수 있는 경우를 선택해야 하는 문제
     *
     * 만약 i 번 집에 도착했을 때 가지고 있는 최대 금액을 dp[i] 라고 하면,
     * 이 집을 털 수 있는 경우 => 이전 집을 털지 않은 것. 최대 금액을 훔쳐야 하기 때문에 이 집은 턴다. dp[i] = dp[i-2] + money[i] => 2번 째 전 집에서 가지고 있던 최대 금액에 현재 금액을 더한 것
     * 이 집을 털 수 없는 경우 => 이전 집을 턴 것 dp[i] = dp[i-1] => 즉, 이전 집에 도착했을 때 가지고 있는 최대 금액을 이번 집에도 그대로 가지고 있어야 합니다.
     *
     * 이 두 경우 중에서 최대로 많은 금액을 털 수 있는 경우를 선택합니다.
     * 0번째 집을 털고 시작하는 경우 => 마지막 집은 털 수 없습니다
     * 0번째 집을 털지 않고 시작하는 경우 (1번째 집을 무조건 텁니다)
     *
     *
     * 이전까지의 탐색 결과를 배열에 가지고 있는다.
     * */
    public int solution3(int[] money) {

        int[] dp0 = new int[money.length];
        int[] dp1 = new int[money.length];

        // 첫 번째 케이스
        dp0[0] = money[0];
        dp0[1] = money[0];

        // 두 번째 케이스
        dp1[0] = 0;
        dp1[1] = money[1];

        // 1번 째 케이스, 돈을 쭉 텁니다.
        for (int i = 2; i < money.length; i++) {
            // 마지막 집은 털 수 없음
            if (i == money.length - 1) {
                dp0[i] = dp0[dp0.length - 2];
                break;
            }

            dp0[i] = Math.max(dp0[i - 1], dp0[i - 2] + money[i]);
        }

        // 2번 째 케이스, 돈을 쭉 텁니다.
        for (int i = 2; i < money.length; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
        }


        return Math.max(dp0[dp0.length - 1], dp1[dp1.length - 1]);
    }


    public static void main(String[] args) {
        Four four = new Four();
        // 8 이여야 하는데
        int[] money = {1, 2, 3, 1};
        System.out.println(four.solution3(money));
    }
}
