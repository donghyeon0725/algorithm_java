package com.inflearn.one;

import java.util.Arrays;
import java.util.Optional;

/**
 * 문장 속 단어
 *
 * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
 * 문장속의 각 단어는 공백으로 구분됩니다.
 *
 *
 * ▣ 입력설명
 * 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성
 * 되어 있습니다.
 *
 * ▣ 출력설명
 * 첫 줄에 가장 긴 단어를 출력한다. 가장 긴 단어가 여러개일 경우 문장속에가 가장 앞쪽에 위
 * 치한 단어를 답으로 합니다.
 *
 * ▣ 입력예제 1
 * it is time to study
 *
 * ▣ 출력예제 1
 * study
 *
 * */
public class Three {

    public static String solution(String str) {
        // 공백을 기준으로 문장을 나눕니다.
        String[] arr = str.split(" ");

        // 배열을 스트림으로 변환 해서, 가장 긴 단어를 찾는다.
        Optional<String> max = Arrays.stream(arr).max((a, b) -> {
            if      (a.length() > b.length())   return 1;
            else if (a.length() == b.length())  return 0;
            else                                return -1;
        });

        return max.get();
    }

    public static String solution_1(String str) {
        String[] arr = str.split(" ");

        String result = "";

        // 반복문을 돌려서 가장 긴 단어를 찾는다.
        for (String s : arr) {
            if (s.length() > result.length()) {
                result = s;
            }
        }

        return result;
    }

    public static String solution_2(String word) {
        String result = "";
        // 가장 작은 수를 담아 놓는다. 단어의 끝 번호를 가리킬 index 변수를 만든다.
        int len = Integer.MIN_VALUE, index;

        // 처음 단어의 공백이 발견 되는 위치를 index에 담는다.
        // 문장의 마지막 단어 이전까지 반복된다. -1
        while ( (index = word.indexOf(' ')) != -1) {
            // 이번에 검사할 단어
            String temp = word.substring(0, index);

            // 길이가 더 긴 단어인 경우 결과값 교체
            if (temp.length() > len) {
                len = temp.length();
                result = temp;
            }

            // **** 이전에 검사했던 부분을 짤라낸다. 예를 들어서 "it is time to study" 에서 it 이라는 단어를 검사 했다면 이 후에는 "is time to study" 를 검사할 수 있도록
            word = word.substring(index+1);
        }

        // 끝나고 마지막 단어까지 검사해야 한다.
        if (word.length() > len) {
            result = word;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Three.solution("it is time to study"));
        System.out.println(Three.solution_1("it is time to study"));
        System.out.println(Three.solution_2("it is time to study"));
    }
}
