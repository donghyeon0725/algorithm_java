package com;


public class Six {
    Time mondayStart = new Time("1PM");
    Time mondayEnd = new Time("6PM");
    Time fridayStart = new Time("9AM", 30);
    Time fridayEnd = new Time("6PM");

    public String solution(double time, String[][] plans) {

        for (int i=0; i<plans.length; i++) {
            Time startAt = new Time(plans[i][1]);
            Time endAt = new Time(plans[i][2]);
            int totalNeedTime = needTimeAtFriday(startAt) + needTimeAtMonday(endAt);

            if (time < totalNeedTime / 3600) {
                return plans[i - 1][0];
            }

            time -= totalNeedTime / 3600;
        }

        return plans[plans.length][0];
    }

    public int needTimeAtMonday(Time end) {
        if (end.isBiggerThan(mondayEnd))
            return 5 * 3600;

        if (end.isSmallerThan(mondayStart))
            return 0;

        return end.getTime() - mondayStart.getTime();
    }

    public int needTimeAtFriday(Time start) {
        if (start.isSmallerThan(fridayStart))
            return 8 * 3600 + 30 * 60;

        if (start.isBiggerThan(fridayEnd))
            return 0;

        return fridayEnd.getTime() - start.getTime();
    }

    static class Time {
        private int time;
        Time (String timeString) {
            setTime(timeString);
        }

        Time (String timeString, int minute) {
            setTime(timeString);
            time += minute * 60;
        }

        Time (int time) {
            this.time = time;
        }

        public void setTime(String timeString) {
            if (timeString.length() == 3) {
                if ("AM".equals(timeString.substring(1)))
                    this.time = Integer.parseInt(timeString.substring(0, 1)) * 3600;
                else
                    this.time = (Integer.parseInt(timeString.substring(0, 1)) + 12) * 3600;
                return;
            }

            if ("AM".equals(timeString.substring(1)))
                this.time = Integer.parseInt(timeString.substring(0, 2)) * 3600;
            else
                this.time = (Integer.parseInt(timeString.substring(0, 2)) + 12) * 3600;
        }

        public int getTime() {
            return time;
        }

        public boolean isBiggerThan(Time other) {
            return this.getTime() > other.getTime();
        }

        public boolean isSmallerThan(Time other) {
            return !isBiggerThan(other);
        }
    }

    public static void main(String[] args) {
        Six six = new Six();
        double time = 3.5;
        String[][] plans = {{"홍콩", "11PM", "9AM"}, {"엘에이", "3PM", "2PM"}};


        System.out.println(six.solution(time, plans));
    }
}
