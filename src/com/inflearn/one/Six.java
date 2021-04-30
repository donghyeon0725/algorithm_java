package com.inflearn.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 중복문자제거
 *
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하
 * 세요.
 * 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 *
 *
 * ▣ 입력설명
 * 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
 *
 * ▣ 출력설명
 * 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
 *
 * ▣ 입력예제 1
 * ksekkset
 *
 * ▣ 출력예제 1
 * kset
 * */
public class Six {
    // 별도의 공간에 한번 추가한 값은 두번 추가하지 않는 방법으로 해결
    public static String solution(String str) {
        char[] arr = str.toCharArray();
        List<String> result = new ArrayList<>();

        for (char c : arr) {
            if (!result.contains(Character.toString(c))) {
                result.add(Character.toString(c));
            }
        }

        return String.join("", result);
    }

    // indexOf로 검색되는 인덱스가 첫인덱스인 점을 이용한다.
    public static String solution_1(String str) {
        List<String> result = new ArrayList<>();

        for (int i=0; i<str.length(); i++) {
            // 현재 검사하려는 인덱스가 처음 찾은 인덱스인가?
            if ( str.indexOf(str.charAt(i)) == i ) {
                result.add(Character.toString(str.charAt(i)));
            }
        }

        return String.join("", result);
    }

    public static void main(String[] args) {
        System.out.println(Six.solution("ksekkset"));
        System.out.println(Six.solution_1("ksekkset"));
    }
}
