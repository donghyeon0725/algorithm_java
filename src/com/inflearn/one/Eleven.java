package com.inflearn.one;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 문자열 압축
 *
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시
 * 오. 단 반복횟수가 1인 경우 생략합니다.
 *
 *
 * ▣ 입력설명
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *
 * ▣ 출력설명
 * 첫 줄에 압축된 문자열을 출력한다.
 *
 * ▣ 입력예제 1
 * KKHSSSSSSSE
 *
 * ▣ 출력예제 1
 * K2HS7E
 * */
public class Eleven {


    // 맵에 처음 발견한 것은 1로 초기화 아니면 기존의 것을 가져와 +1 함
    public static String solution(String word) {

        Map<String, Integer> result = new HashMap<>();

        for (int i=0; i<word.length(); i++) {
            String character = Character.toString(word.charAt(i));

            // 처음 발견 한 것
            if (word.indexOf(character) == i) {
                result.put(character, 1);
            } else {
                result.put(character, result.get(character)+1);
            }
        }

        return result.toString();
    }

    // LinkedHashMap은 선입 선출 구조이다.
    public static String solution_1(String word) {

        Map<String, Integer> result = new LinkedHashMap<>();

        for (int i=0; i<word.length(); i++) {
            String character = Character.toString(word.charAt(i));

            // 처음 발견 한 것
            if (word.indexOf(character) == i) {
                result.put(character, 1);
            } else {
                result.put(character, result.get(character)+1);
            }
        }

        // 이런 방식으로 출력해보면 FIFO 구조임을 알 수 있음
        /*result.forEach(((a, b) -> {
            System.out.println(a + ", " + b);
        }));*/

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("KKHSSSSSSSE"));
        System.out.println(solution_1("KKHSSSSSSSE"));
    }
}
