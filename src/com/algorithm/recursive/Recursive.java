package com.algorithm.recursive;

public class Recursive {





    /**
     * 팩토리얼 - 일반적인 구현
     *
     * 공간 복잡도는 O(1) / 사용된 변수는 f 하나
     * 시간 복잡도는 O(n)
     * */
    public static int factorial(int n) {
        int f = 1;
        for (int i=1; i<=n; i++) {
            f *= i;
        }
        return f;
    }


    /**
     * 팩토리얼 - 재귀용법을 사용하는 대표적인 예시
     *
     * 공간 복잡도는 O(n) => n의 크기에 따라 호출되는 함수의 개수가 달라지고 함수 내부에서 사용하는 변수인 n의 개수가 n-1 개 생성 되므로
     * */
    public static int factorial_recursive(int n) {
        if (n > 1) {
            return n * factorial_recursive(n - 1);
        } else {
            return 1;
        }
    }


    /**
     * 회문은 순서가 거꾸로 되어도 같은 단어인 문자를 의미함
     * 재귀 호출을 이용해서 회문을 판별할 수 있는 알고리즘을 만들기
     * 회문 예시 : LEVEL => true
     * 회문이 아닌 예시 : MOTOR => false
     * */
    public static boolean palindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }

        // 양쪽 끝이 동일하면 다음 단계 진행
        if (str.charAt(0) == str.charAt(str.length()-1)) return palindrome(str.substring(1, str.length()-1));
        else return false;
    }

    /**
    * 1. 정수 n 에 대해
    * 2. n이 홀수이면 3 * n + 1을 하고
    * 3. n이 짝수이면 n을 2로 나눕니다.
    * 4. 이렇게 계속 진행해서 n이 결국 1이 될 때까지 2와 3의 과정을 반복합니다.
    * 예를 들어 3을 넣으면
    * ========
    * 3
    * 10
    * 5
    * 16
    * 8
    * 4
    * 2
    * 1
    * ========
    * 이렇게 정수 n을 입력받아, 위 알고리즘에 의해 1이 되는 과정을 모두 출력하는 함수 작성
    * */
    public static int sss(int n) {
        System.out.println(n);
        if (n == 1) return n;

        if (n % 2 == 1) {
            return sss((3*n)+1);
        } else {
            return sss((int)n/2);
        }
    }

    /**
     * 정수 4 를 1,2,3의 조합으로 나타내는 방법은 다음과 같이 총 7가지가 있음
     * 1+1+1+1
     * 1+1+2
     * 1+2+1
     * 2+1+1
     * 2+2
     * 1+3
     * 3+1
     * 정수 n이 입력으로 주어졌을 때, n을 1,2,3의 합으로 나타낼 수 있는 모든 방법을 출력하시오
     * */
    public static int subCase(int n) {
        if (n == 1) return 1;       // 주어진 수가 1일 때 1개의 조합수
        else if (n == 2) return 2;  // 주어진 수가 2일 때 2개의 조합수
        else if (n == 3) return 4;  // 주어진 수가 3일 때 4개의 조합수

        // 현재 숫자에서 1을 빼고 2를 빼고 3을 계속 지속적으로 빼서 3,2,1 이 되는 모든 경우를 구함
        return subCase(n-1) + subCase(n-2) + subCase(n-3);
    }

    public static void main(String[] args) {
        System.out.println(subCase(8));
    }


}
