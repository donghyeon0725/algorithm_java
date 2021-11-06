package com;

public class Two {
    public String solution(String[] log) {
        int max = 3600 * 1 + 45 * 60;
        int min = 5  * 60;
        int total = 0;

        for (int i=0; i<log.length; i+=2) {
            int start = Integer.parseInt(log[i].substring(0, 2)) * 3600 + Integer.parseInt(log[i].substring(3)) * 60;
            int end = Integer.parseInt(log[i + 1].substring(0, 2)) * 3600 + Integer.parseInt(log[i + 1].substring(3)) * 60;
            int study = end - start;


            if (study > max) study = max;
            if (study < min) study = 0;

            total += study;
        }

        return String.format("%02d", total / 3600) + ":" + String.format("%02d", (total % 3600) / 60);
    }

    public static void main(String[] args) {
        Two two = new Two();
        String[] logs = {"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"};
        System.out.println(two.solution(logs));
    }
}
