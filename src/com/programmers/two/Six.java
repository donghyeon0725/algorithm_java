package com.programmers.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/77486
 * */
public class Six {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        List<Employee> employees = new ArrayList<>();
        Employee center = new Employee("민호", null);
        employees.add(center);

        for (int i=0; i<enroll.length; i++) {
            if ("-".equals(referral[i]))
                employees.add(new Employee(enroll[i], center));
            else
                employees.add(new Employee(enroll[i], findEmployee(employees, referral[i])));
        }


        for (int i=0; i<seller.length; i++) {
            findEmployee(employees, seller[i]).setProfit(amount[i] * 100);
        }

        employees.remove(0);
        return employees.stream().mapToInt(s -> s.getProfit()).toArray();
    }

    public Employee findEmployee(List<Employee> employees, String name) {
        for (int i=employees.size() - 1; i>0; i--) {
            if (employees.get(i).getName().equals(name))
                return employees.get(i);
        }
        return null;
    }

    static class Employee {
        private String name;
        private Employee referral;
        private int profit;

        public Employee(String name, Employee referral) {
            this.name = name;
            this.referral = referral;
        }

        public void setProfit(int profit) {

            if (referral == null)
                this.profit += profit;
            else {
                int rest = profit / 10;

                if (rest >= 1)
                    referral.setProfit(rest);

                this.profit += profit - rest;
            }
        }

        public int getProfit() {
            return profit;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Six six = new Six();

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        int[] result = six.solution(enroll, referral, seller, amount);
        System.out.println(Arrays.toString(result));

    }
}
