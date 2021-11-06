package com;

import java.util.HashMap;
import java.util.Map;

public class Three {
    public int solution(String[] ings, String[] menu, String[] sell) {
        Map<String, Integer> expense = new HashMap<>();
        Map<String, Integer> revenue = new HashMap<>();
        int total = 0;

        for (String s : ings)
            expense.put(s.split(" ")[0], Integer.parseInt(s.split(" ")[1]));

        for (String s : menu) {
            int origin = 0;

            for (String t : s.split(" ")[1].split(""))
                origin += expense.get(t);

            int price = Integer.parseInt(s.split(" ")[2]) - origin;
            revenue.put(s.split(" ")[0], price);
        }

        for (String s : sell) {
            total += revenue.get(s.split(" ")[0]) * Integer.parseInt(s.split(" ")[1]);
        }

        return total;
    }

    public static void main(String[] args) {
        Three three = new Three();
        String[] ings = {"r 10", "a 23", "t 124", "k 9"};
        String[] menu = {"PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30", "ICECREAM rar 50", "SHAVEDICE rar 45", "JUICE rra 55", "WATER a 20"};
        String[] sell = {"BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"};

        System.out.println(three.solution(ings, menu, sell));
    }
}
