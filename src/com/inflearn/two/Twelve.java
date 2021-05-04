package com.inflearn.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 멘토링
 *
 * 현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니
 * 다. 멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의
 * 수학공부를 도와주는 것입니다.
 * 선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
 * 만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서
 * 모두 B학생보다 등수가 앞서야 합니다.
 * M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지
 * 출력하는 프로그램을 작성하세요.
 *
 *
 * ▣ 입력설명
 * 첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.
 * 두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 학생번호가 제일
 * 앞에서부터 1등, 2등, ...N등 순으로 표현된다.
 * 만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번 학생이 1등, 4번 학생이
 * 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.
 *
 * ▣ 출력설명
 * 첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.
 *
 * ▣ 입력예제 1
 * 4 3
 * 3 4 1 2
 * 4 3 2 1
 * 3 1 4 2
 *
 * ▣ 출력예제 1
 * 3
 * (3, 1), (3, 2), (4, 2)와 같이 3가지 경우의 (멘토, 멘티) 짝을 만들 수 있다.
 * */
public class Twelve {

    public static int solution(int[][] arr, int count, int match_num) {

        int[][] record = new int[arr.length][arr[0].length];
        // 자료를 각각 번호 별 등수로 변환한다.
        for (int i=0; i<match_num; i++) {

            for (int num = 0; num<count; num++) {
                int rank = num + 1;
                int number = arr[i][num] - 1;
                record[i][number] = rank;
            }
        }

        System.out.println(Arrays.toString(record[0]));
        System.out.println(Arrays.toString(record[1]));
        System.out.println(Arrays.toString(record[2]));

        int result = 0;

        // 학생 수 만큼 멘토 맨티가 될 수 있는지 확인한다.
        for (int mento=0; mento < count; mento++) {

            // 한명을 맨티로 잡고 확인한다.
            for (int mentee=0; mentee < count; mentee++) {

                boolean canBeMento = true;

                // 모든 경기에서 이겼는지 확인한다.
                for (int match=0; match<match_num; match++) {
                    int mento_rank = record[match][mento];
                    int mentee_rank = record[match][mentee];

                    // 숫자가 더 높은 쪽이 낮은 등수
                    if (mentee_rank < mento_rank) {
                        canBeMento = false;
                    }

                    //for (int i=0; i<)
                }

                // 검사를 마쳤는데도 true이면
                if (canBeMento) {
                    System.out.println(mento + " : " + mentee);
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] input = {
                {3,4,1,2},
                {4,3,2,1},
                {3,1,4,2}
        };
        System.out.println(solution(input, 4, 3));
    }
}
