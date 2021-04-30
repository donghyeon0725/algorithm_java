package com.inflearn.one;

/**
 * 특정 문자 뒤집기
 *
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고, 특수문자는 자기
 * 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 *
 *
 * ▣ 입력설명
 * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
 *
 * ▣ 출력설명
 * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
 *
 * ▣ 입력예제 1
 * a#b!GE*T@S
 *
 * ▣ 출력예제 1
 * S#T!EG*b@a
 * */
public class Five {
    /**
     * 아스키 코드를 출력하는 방법은 char를 int 형으로 변환하는 것이다.
     *
     * A ~ Z 의 아스키 코드는 65 ~ 90 이고
     * a ~ z 의 아스키 코드는 97 ~ 122 이다.
     * */
    public static String solution(String str) {
        char[] arr = str.toCharArray();

        int left = 0, right = arr.length-1;

        while ( left < right ) {

            // 알파벳을 만날 때까지 값을 찾는다.
            while (!Character.isAlphabetic(arr[left]) && left <= arr.length - 1) {
                left++;
            }


            while (!Character.isAlphabetic(arr[right]) && right >= 0) {
                right--;
            }

            // 교체 후 인덱스 교체
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return new String(arr);
    }

    public static boolean isAlphabet(char c) {
        int ascii = (int)c;
        return ( ascii >= 65 && ascii <= 90 ) || ( ascii >= 97 && ascii <= 122 );
    }

    public static void main(String[] args) {
        System.out.println(solution("a#b!GE*T@S"));
    }
}
