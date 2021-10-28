package com.programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/59039
 * */
public class AnimalWhereNameIsNull {
    public static void main(String[] args) {
        String sql = "SELECT ANIMAL_ID FROM  ANIMAL_INS WHERE NAME IS NULL ORDER BY ANIMAL_ID ASC";
    }
}
