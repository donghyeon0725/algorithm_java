package com.inflearn.two;

import java.util.Arrays;

/**
 * 봉우리
 *
 * 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다. 각 격자
 * 판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개
 * 있는 지 알아내는 프로그램을 작성하세요.
 * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
 * 만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
 *
 * 0 0 0 0 0 0 0
 * 0 5 3 7 2 3 0
 * 0 3 7 1 6 1 0
 * 0 7 2 5 3 4 0
 * 0 4 3 6 4 1 0
 * 0 8 7 3 5 2 0
 * 0 0 0 0 0 0 0
 *
 *
 * ▣ 입력설명
 * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는
 * 다.
 *
 * ▣ 출력설명
 * 봉우리의 개수를 출력하세요.
 *
 * ▣ 입력예제 1
 * 5
 * 5 3 7 2 3
 * 3 7 1 6 1
 * 7 2 5 3 4
 * 4 3 6 4 1
 * 8 7 3 5 2
 *
 * ▣ 출력예제 1
 * 10
 * */
public class Ten {

    public static int solution(int[][] temp) {
        int len = temp.length;
        int[][] arr = new int[len+2][len+2];
        int result = 0;

        // 계산하기 쉽도록 각각 양 바깥쪽에 0을 하나씩 추가 해준다.
        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                arr[i+1][j+1] = temp[i][j];
            }
        }

        // 위 오른쪽 아래 왼쪽 순서
        int[] offset_x = {0, 1, 0, -1};
        int[] offset_y = {-1, 0, 1, 0};

        for (int y=1; y<len+1; y++) {
            for (int x=1; x<len+1; x++) {

                boolean isTop = true;

                // 네 방향 모두 검사
                for (int t=0; t<4; t++) {

                    int target_x = x + offset_x[t];
                    int target_y = y + offset_y[t];

                    // 하나라도 크거나 같으면
                    if (arr[target_y][target_x] >= arr[y][x]) {
                        isTop = false;
                    }
                }


                if (isTop) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] input = {
                {5,3,7,2,3},
                {3,7,1,6,1},
                {7,2,5,3,4},
                {4,3,6,4,1},
                {8,7,3,5,2}
        };
        System.out.println(solution(input));
    }
}
