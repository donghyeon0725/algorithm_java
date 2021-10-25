package com.programmers.three;

/**
 * 자료형 선택을 정확하게 하자.
 * 자료형의 범위를 정확하게 확인하지 않으면 실무에서도 큰 문제를 일으킬 수 있다.
 * 따라서 항상 이 부분을 확인하고 코딩하도록 한다.
 *
 * */
public class NormalRectangle {
    public long solution(int w, int h) {
        // 먼저 나눗셈을 하고 곱하는 경우 부동 소수점 특성상 정확도가 떨어질 수 있음. 따라서, 먼저 곱하고 나누는 방법을 택한다.
        // 만약 뺀 값이 정확하게 0 으로 떨어지는 경우, 시작과 끝점이 정확하게 0 이면 개수가 2개

        long total = w * (long)h;
        long trash = 0;

        for (long i=0; i<w; i++) {
            long start = i;
            long end = i + 1;

            trash += (long)Math.ceil(h * end / (double)w) - (long)(h * start / (double)w);
        }

        return total - trash;
    }

    public static void main(String[] args) {
        NormalRectangle rectangle = new NormalRectangle();
        System.out.println(rectangle.solution(8, 12));
        System.out.println(rectangle.solution(7, 3));
    }
}
