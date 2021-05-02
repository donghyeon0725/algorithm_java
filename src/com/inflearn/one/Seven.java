package com.inflearn.one;


/**
 * 회문 문자열
 *
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
 * 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력
 * 하는 프로그램을 작성하세요.
 * 단 회문을 검사할 때 대소문자를 구분하지 않습니다.
 *
 *
 * ▣ 입력설명
 * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
 *
 * ▣ 출력설명
 * 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
 *
 * ▣ 입력예제 1
 * gooG
 *
 * ▣ 출력예제 1
 * YES
 * */
public class Seven {

    // 문자열 길이를 줄여가며 확인하는 방법
    public static boolean solution(String word) {

        // 길이가 1 이하가 되면 true 리턴
        if (word.length() < 2) {
            return true;
        }

        // 양쪽 끝의 문자가 같으면 다시 재귀 호출
        if (word.charAt(0) == word.charAt(word.length()-1))
            return solution(word.substring(1, word.length()-2));
        else
            return false;
    }

    // 문자열의 인덱스를 간직하는 방법
    public static boolean solution_1(String word, int index) {

        // 만약 인덱스의 길이가 중간을 넘어서면 true
        if (index >= word.length() / 2) {
            return true;
        }


        if (word.charAt(index) == word.charAt( (word.length()-1) - index)) {
            index++;
            return solution_1(word, index);
        } else {
            return false;
        }
    }


    // 기본 내장 함수를 사용하는 방법
    public static boolean solution_2(String word) {
        String reverse = new StringBuilder(word).reverse().toString();

        if (word.equals(reverse)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        String input = "gooG";
        input = input.toLowerCase();

        System.out.println(Seven.solution(input));
        System.out.println(Seven.solution_1(input, 0));
        System.out.println(Seven.solution_2(input));

    }
}
