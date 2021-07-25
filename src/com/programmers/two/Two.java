package com.programmers.two;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @See https://programmers.co.kr/learn/courses/30/lessons/17676?language=java
 * */
public class Two {


    public int solution(String[] lines) {
        List<String> dates = Arrays.stream(lines).map(s -> s.replaceFirst(" ", "T")).collect(Collectors.toList());

        int max = 0;

        // 현재 대상 로그가 끝나는 시점으로 부터 1초 구간에 n 개의 시작시간이 들어오는지 검사
        for (int i=0; i<dates.size(); i++) {
            int size = 1;
            LocalDateTime currentTime = LocalDateTime.parse(dates.get(i).split(" ")[0]).plus(Duration.ofSeconds(1L));
            LocalDateTime maxTime = LocalDateTime.parse(dates.get(i).split(" ")[0]).plus(Duration.ofSeconds(3L));

            for (int j=i+1; j<dates.size(); j++) {

                int seconds = (int)(1000 * Float.parseFloat(dates.get(j).split(" ")[1].replace("s", ""))) - 1;

                LocalDateTime target = LocalDateTime.parse(dates.get(j).split(" ")[0]).minus(Duration.ofMillis(seconds));
                if (currentTime.isAfter(target))
                    size++;

                if (maxTime.isBefore(target))
                    break;
            }

            if (max < size)
                max = size;
        }

        return max;
    }

    public int solution1(String[] lines) {
        int max = 0;

        // 현재 대상 로그가 끝나는 시점으로 부터 1초 구간에 n 개의 시작시간이 들어오는지 검사
        for (int i=0; i<lines.length; i++) {

            int size = 1;
            LocalDateTime currentTime = LocalDateTime.parse(lines[i].replaceFirst(" ", "T").split(" ")[0]).plus(Duration.ofSeconds(1L));
            LocalDateTime maxTime = LocalDateTime.parse(lines[i].replaceFirst(" ", "T").split(" ")[0]).plus(Duration.ofSeconds(3L));

            for (int j=i+1; j<lines.length; j++) {

                int seconds = (int)(1000 * Float.parseFloat(lines[j].split(" ")[2].replace("s", ""))) - 1;
                LocalDateTime target = LocalDateTime.parse(lines[j].replaceFirst(" ", "T").split(" ")[0]).minus(Duration.ofMillis(seconds));
                if (currentTime.isAfter(target))
                    size++;

                if (maxTime.isBefore(target))
                    break;
            }

            if (max < size)
                max = size;
        }

        return max;
    }


    public int solution2(String[] lines) {
        // 초단위로 환산
        Double[] times = new Double[lines.length];
        Double[] runningTime = new Double[lines.length];

        for (int i=0; i<lines.length; i++) {
            String time = lines[i].split(" ")[1];

            times[i] = Double.parseDouble(time.split(":")[0]) * 3600 + Double.parseDouble(time.split(":")[1]) * 60 + Double.parseDouble(time.split(":")[2]);

            runningTime[i] = Double.parseDouble(lines[i].split(" ")[2].replace("s", ""));
        }


        int max = 0;

        // 현재 대상 로그가 끝나는 시점으로 부터 1초 구간에 n 개의 시작시간이 들어오는지 검사
        for (int i=0; i<times.length; i++) {
            int size = 1;
            Double currentTime = times[i] + 1.000;
            Double maxTime = currentTime + 3.000;

            for (int j=i+1; j<times.length; j++) {

                Double target = times[j] - (runningTime[j] - 0.001);
                if (currentTime > target)
                    size++;

                if (maxTime < target)
                    break;
            }

            if (max < size)
                max = size;
        }



        return max;
    }


    public static void main(String[] args) {

        String[] lines = {
                "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"
        };

        // 초단위로 환산
        Double[] times = new Double[lines.length];
        Double[] runningTime = new Double[lines.length];

        for (int i=0; i<lines.length; i++) {
            String time = lines[i].split(" ")[1];

            times[i] = Double.parseDouble(time.split(":")[0]) * 3600 + Double.parseDouble(time.split(":")[1]) * 60 + Double.parseDouble(time.split(":")[2]);

            runningTime[i] = Double.parseDouble(lines[i].split(" ")[2].replace("s", ""));
        }


        int max = 0;

        // 현재 대상 로그가 끝나는 시점으로 부터 1초 구간에 n 개의 시작시간이 들어오는지 검사
        for (int i=0; i<times.length; i++) {
            int size = 1;
            Double currentTime = times[i] + 1.000;
            Double maxTime = currentTime + 3.000;

            for (int j=i+1; j<times.length; j++) {

                Double target = times[j] - (runningTime[j] - 0.001);
                if (currentTime > target)
                    size++;

                if (maxTime < target)
                    break;
            }

            if (max < size)
                max = size;
        }

        System.out.println(max);


    }

}
