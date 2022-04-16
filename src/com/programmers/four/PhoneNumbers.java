package com.programmers.four;

import java.util.Arrays;

public class PhoneNumbers {
    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        System.out.println(Arrays.toString(phone_book));

        for (int i=0; i<phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] phone_book = {"0", "010", "100", "10", "1", "0000", "12","21", "211", "2113", "212", "123","1235","567","88"};
        PhoneNumbers phoneNumbers = new PhoneNumbers();
        System.out.println(phoneNumbers.solution(phone_book));
    }
}
