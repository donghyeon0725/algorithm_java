package com.inflearn.one;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 유효한 팰린드롬
 *
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
 * 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을
 * 작성하세요.
 * 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
 * 알파벳 이외의 문자들의 무시합니다.
 *
 *
 * ▣ 입력설명
 * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
 *
 * ▣ 출력설명
 * 첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.
 *
 * ▣ 입력예제 1
 * found7, time: study; Yduts; emit, 7Dnuof
 *
 * ▣ 출력예제 1
 * YES
 * */
public class Eight {
    public static boolean solution(String word) {
        String reverse = new StringBuilder(word).reverse().toString();


        if (word.equals(reverse)) {
            return true;
        } else {
            return false;
        }
    }




    public static void main(String[] args) {
        String input = "found7, time: study; Yduts; emit, 7Dnuof";

        System.out.println(solution(only_alphabet(input).toLowerCase()));
        System.out.println(solution(only_alphabet_1(input).toLowerCase()));
        System.out.println(solution(only_alphabet_2(input).toLowerCase()));
    }

    // character 클래스를 이용하는 방법
    public static String only_alphabet(String str) {
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<arr.length; i++) {
            if (Character.isAlphabetic(arr[i])) {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }

    // 정규식을 이용해서 변경하는 방법
    public static String only_alphabet_1(String str) {
        Pattern pattern = Pattern.compile("[^a-zA-Z]");
        Matcher matcher = pattern.matcher(str);

        return matcher.replaceAll("");
    }

    // 정규식을 활용한 방법 2
    public static String only_alphabet_2(String str) {
        return str.replaceAll("[^a-zA-Z]", "");
    }

}
