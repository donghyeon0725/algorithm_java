package com.inflearn.one;


/**
 * 대소문자 변환
 *
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로
 * 변환하여 출력하는 프로그램을 작성하세요.
 *
 * ▣ 입력설명
 * 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
 * 문자열은 영어 알파벳으로만 구성되어 있습니다.
 *
 * ▣ 출력설명
 * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
 *
 * ▣ 입력예제 1
 * StuDY
 *
 * ▣ 출력예제 1
 * sTUdy
 * */
public class Two {
    public static String solution(String str) {
        char[] arr = str.toCharArray();

        String result = "";

        for (char s :  arr) {
            if (Character.isLowerCase(s))   result += Character.toUpperCase(s);
            else                            result += Character.toLowerCase(s);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Two.solution("StuDY"));

    }
}