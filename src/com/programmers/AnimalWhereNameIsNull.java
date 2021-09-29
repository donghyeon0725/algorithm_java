package com.programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/59039
 * */
public class AnimalWhereNameIsNull {
    public static void main(String[] args) {
        String sql = "SELECT  ANIMAL_ID from ANIMAL_INS where name is NULL order by ANIMAL_ID asc";
    }
}
