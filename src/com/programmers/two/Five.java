package com.programmers.two;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/17678
 * */
public class Five {
    public String solution(int n, int t, int m, String[] timetable) {

        Arrays.sort(timetable);

        Queue<People> peoples = new LinkedList<>();
        LinkedList<Bus> buses = new LinkedList<>();

        for (String time : timetable)
            peoples.add(new People(time));

        int first = 3600 * 9;
        buses.add(new Bus(first, m));
        for (int i=1; i<n; i++)
            buses.add(new Bus(first + (i * (t * 60)), m));

        Bus bus = null;
        while (!buses.isEmpty()) {
            bus = buses.poll();

            // 사람을 더 태울 수 있으면
            while (bus.isRideMorePeople()) {
                People people = peoples.peek();

                if (people != null && people.getTime() <= bus.getTime())
                    bus.rideThisBus(peoples.poll());
                else
                    break;
            }

        }

        // 마지막 버스에 자리가 남는 경우
        if (bus.isRideMorePeople())
            return timeToString(bus.getTime());

        // 마지막 버스에도 자리가 남지 않으면
        return timeToString(bus.getLastLimitTime());
    }

    public String timeToString(int time) {
        return  String.format("%02d", time / 3600) + ":" + String.format("%02d", ( time % 3600 ) / 60);
    }

    static class People {

        private int time;

        public People(String time) {
            this.time = 3600 * Integer.parseInt(time.split(":")[0]) + 60 * Integer.parseInt(time.split(":")[1]);
        }

        public int getTime() {
            return time;
        }
    }

    static class Bus {
        private int time;
        private int limit;
        private List<People> peoples = new ArrayList<>();

        public Bus(int time, int limit) {
            this.time = time;
            this.limit = limit;
        }

        public int getTime() {
            return time;
        }

        public boolean isRideMorePeople() {
            return peoples.size() < limit;
        }

        public int getLastLimitTime() {
            if (peoples.size() > 0)
                return this.peoples.get(peoples.size() - 1).getTime() - 60;
            else
                return this.time;
        }

        public void rideThisBus(People people) {
            this.peoples.add(people);
        }
    }

    public static void main(String[] args) {
        Five five = new Five();
        String[] timetable = {"09:00", "09:00", "09:00", "09:00"};

        System.out.println(five.solution(2, 1, 2, timetable));
    }
}
