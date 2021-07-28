package com.programmers.two;


import java.sql.Time;
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
        // 시간을 LocalDateTime 클래스가 파싱할 수 있는 형태로 변환
        List<String> dates = Arrays.stream(lines).map(s -> s.replaceFirst(" ", "T")).collect(Collectors.toList());

        int max = 0;

        // 현재 대상 로그가 끝나는 시점으로 부터 1초 구간에 로그 시작시간이 들어 오는지 검사
        for (int i=0; i<dates.size(); i++) {
            int size = 1;

            // 로그 끝 시간 1초 이후
            LocalDateTime endRangeOfTime = LocalDateTime.parse(dates.get(i).split(" ")[0]).plus(Duration.ofSeconds(1L));

            // 최대 범위 => 이 이후의 시간은 검사할 필요 없음 (로그의 최대 처리 시간은 3초이기 때문)
            LocalDateTime maxRangeOfTime = LocalDateTime.parse(dates.get(i).split(" ")[0]).plus(Duration.ofSeconds(3L));

            for (int j=i+1; j<dates.size(); j++) {
                // 실행시간
                int runningTime = (int)(1000 * Float.parseFloat(dates.get(j).split(" ")[1].replace("s", ""))) - 1;

                LocalDateTime startTime = LocalDateTime.parse(dates.get(j).split(" ")[0]).minus(Duration.ofMillis(runningTime));
                if (endRangeOfTime.isAfter(startTime))
                    size++;

                if (maxRangeOfTime.isBefore(startTime))
                    break;
            }

            if (max < size)
                max = size;
        }

        return max;
    }

    public int solution1(String[] lines) {
        int max = 0;

        // 현재 대상 로그가 끝나는 시점으로 부터 1초 구간에 로그 시작시간이 들어 오는지 검사
        for (int i=0; i<lines.length; i++) {

            int size = 1;

            // 로그 끝 시간 1초 이후
            LocalDateTime endRangeOfTime = LocalDateTime.parse(lines[i].replaceFirst(" ", "T").split(" ")[0]).plus(Duration.ofSeconds(1L));

            // 최대 범위 => 이 이후의 시간은 검사할 필요 없음 (로그의 최대 처리 시간은 3초이기 때문)
            LocalDateTime maxRangeOfTime = LocalDateTime.parse(lines[i].replaceFirst(" ", "T").split(" ")[0]).plus(Duration.ofSeconds(3L));

            for (int j=i+1; j<lines.length; j++) {

                int runningTime = (int)(1000 * Float.parseFloat(lines[j].split(" ")[2].replace("s", ""))) - 1;
                LocalDateTime target = LocalDateTime.parse(lines[j].replaceFirst(" ", "T").split(" ")[0]).minus(Duration.ofMillis(runningTime));

                if (endRangeOfTime.isAfter(target))
                    size++;

                if (maxRangeOfTime.isBefore(target))
                    break;
            }

            if (max < size)
                max = size;
        }

        return max;
    }


    public int solution2(String[] lines) {
        // 초단위로 환산
        Double[] endTimes = new Double[lines.length];
        Double[] runningTime = new Double[lines.length];

        for (int i=0; i<lines.length; i++) {
            String time = lines[i].split(" ")[1];

            endTimes[i] = Double.parseDouble(time.split(":")[0]) * 3600 + Double.parseDouble(time.split(":")[1]) * 60 + Double.parseDouble(time.split(":")[2]);

            runningTime[i] = Double.parseDouble(lines[i].split(" ")[2].replace("s", ""));
        }


        int max = 0;

        // 현재 대상 로그가 끝나는 시점으로 부터 1초 구간에 n 개의 시작시간이 들어오는지 검사
        for (int i=0; i<endTimes.length; i++) {
            int size = 1;
            Double endRangeOfTime = endTimes[i] + 1.000;
            Double maxRangeOfTime = endRangeOfTime + 3.000;

            for (int j=i+1; j<endTimes.length; j++) {

                Double target = endTimes[j] - (runningTime[j] - 0.001);
                if (endRangeOfTime > target)
                    size++;

                if (maxRangeOfTime < target)
                    break;
            }

            if (max < size)
                max = size;
        }



        return max;
    }

    public int solution3(String[] lines) {
        // 초단위로 환산
        Log[] times = new Log[lines.length];

        for (int i=0; i<lines.length; i++)
            times[i] = new Log(lines[i]);


        int max = 0;

        // 현재 대상 로그가 끝나는 시점으로 부터 1초 구간에 n 개의 시작시간이 들어오는지 검사
        for (int i=0; i<times.length; i++) {
            int size = 1;
            Log standard = times[i];

            for (int j=i+1; j<times.length; j++) {

                Log target = times[j];

                if (standard.isInRange(target))
                    size++;

                if (standard.isOutMaxRange(target))
                    break;
            }

            if (max < size)
                max = size;
        }

        return max;
    }

    public static void main(String[] args) {
        Two t = new Two();
        String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        System.out.println(t.solution3(lines));
    }


    class Log {
        Double endTime;
        Double runningTime;

        public Log(String time) {
            // 초로 환산
            String d = time.split(" ")[1];
            endTime = Double.parseDouble(d.split(":")[0]) * 3600 + Double.parseDouble(d.split(":")[1]) * 60 + Double.parseDouble(d.split(":")[2]);
            runningTime = Double.parseDouble(time.split(" ")[2].replace("s", ""));
        }

        public Double getEndRangeTime() {
            return endTime + 1.000;
        }

        public Double getMax() {
            return this.getEndRangeTime() + 3.000;
        }

        public Double getStart() {
            return endTime - runningTime + 0.001;
        }

        // 다른 로그의 시작 시간이 로그 수집 시간 범위에 들어가는지 계산
        public boolean isInRange(Log log) {
            return this.getEndRangeTime() > log.getStart();
        }

        // 다른 로그의 시작 시간이 로그 수집 최대 시간 범위에 들어가는지 계산
        public boolean isOutMaxRange(Log log) {
            return this.getMax() < log.getStart();
        }
    }

}
