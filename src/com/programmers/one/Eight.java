package com.programmers.one;

public class Eight {
    /**
     * 우측 아래로만 갈 수 있기 때문에
     *
     * 만약 하나의 칸을 node 라고 부르고 x, y 좌표까지 모든 경로의 경우의 수를
     * node[y][x] 라고 나타낼 때
     *
     * 장애물이 없다고 가정하면
     * 위 노드까지 경로의 경우의 수 + 좌측 노드까지 경로의 경우의 수
     * node[y][x] = node[y-1][x] + node[y][x-1]
     *
     *
     * 위에서 부터 1줄 한줄 한줄 풀어 내려오면 이 문제를 쉽게 풀 수 있음
     * 예를 들어서 다음과 같이 경로가 있다고 할 때
     *
     * 집 1 1 1
     * 1  0 1  2
     * 1  1  2 4
     *
     * 이렇게 계산이 됩니다.
     * */
    public int solution(int m, int n, int[][] puddles) {

        int[][] node = new int[n][m];

        for (int p = 0; p<puddles.length; p++) {
            int x = puddles[p][0]-1;
            int y = puddles[p][1]-1;
            node[y][x] = -1;
        }

        for (int x=0; x<m; x++)
            if (node[0][x] != -1)
                node[0][x] = 1;

        for (int y=0; y<n; y++)
            if (node[y][0] != -1)
                node[y][0] = 1;

        for (int y=1; y<n; y++)
            for (int x=1; x<m; x++) {
                if (node[y][x] != -1) {
                    node[y][x] = (node[y-1][x] != - 1 ? node[y-1][x] : 0) + (node[y][x-1] != -1 ? node[y][x-1] : 0);
                }
            }

        return node[n-1][m-1] % 1000000007;
    }


    /**
     * 경로가 모두 막힌 경우를 고려해야 하기 때문에 1로 채우고 시작할 것이 아니라,
     * 처음에만 1을 부여하고 채워가는 방법을 선택해야 합니다.
     *
     * 또한 데이터는 중복해서 들어가기 때문에 순식간에 값을 넘어버린다.
     *
     * */
    public int solution1(int m, int n, int[][] puddles) {

        long[][] node = new long[n][m];
        node[0][0] = 1;

        for (int p = 0; p<puddles.length; p++) {
            int x = puddles[p][0]-1;
            int y = puddles[p][1]-1;
            node[y][x] = -1;
        }


        for (int y=0; y<n; y++)
            for (int x=0; x<m; x++) {
                if (x == 0 && y == 0)
                    continue;

                if (y == 0 && node[y][x] != -1)
                    node[y][x] = (node[y][x-1] != -1 ? node[y][x-1] : 0);
                else if (x == 0 && node[y][x] != -1)
                    node[y][x] = (node[y-1][x] != - 1 ? node[y-1][x] : 0);
                else if (node[y][x] != -1) {
                    node[y][x] = (node[y-1][x] != - 1 ? node[y-1][x] : 0) + (node[y][x-1] != -1 ? node[y][x-1] : 0);
                }
            }

        return (int)(node[n-1][m-1] % 1000000007);
    }

    /**
     *
     * 문제를 풀 때 좌 우 100 만 넘어가도
     * 수가 기하급수적으로 커지기 때문에 1000000007 으로 나눈 값을 반환하라는 부분이 있다.
     *
     * 주의할 점은, 계산 중간 크기가 int 변수 최대 범위를 넘어가는 방지하기 위해 중간에 1000000007 으로 나누어 주어야 한다고 한다.
     *
     * 한편, 배열을 0으로 한번 감싸면 문제 풀이가 더 쉬워진다.
     * ===================
     * 집    1   1   1
     * 1    0   1   2
     * 1    1   2   4
     * ==================
     * 0    0    0   0   0
     * 0   집    1   1   1
     * 0    1    0   1   2
     * 0    1    1   2   4
     * ===================
     * 이렇게 하고 계산을 하면 OutOfIndex Exception 을 위한 방어코드를 넣지 않아도 된다.
     * */
    public int solution2(int m, int n, int[][] puddles) {

        long[][] node = new long[n+1][m+1];
        boolean[][] isPuddles = new boolean[n+1][m+1];
        node[1][1] = 1;

        for (int p = 0; p<puddles.length; p++)
            isPuddles[puddles[p][1]][puddles[p][0]] = true;

        for (int y=1; y<=n; y++)
            for (int x=1; x<=m; x++) {
                if (x == 1 && y == 1)
                    continue;

                node[y][x] = ((!isPuddles[y-1][x] ? node[y-1][x] : 0) + (!isPuddles[y][x-1]? node[y][x-1] : 0)) % 1000000007;
            }

        return (int)node[n][m];
    }


    public static void main(String[] args) {
        Eight eight = new Eight();

        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        System.out.println(eight.solution2(m, n, puddles));
    }
}
