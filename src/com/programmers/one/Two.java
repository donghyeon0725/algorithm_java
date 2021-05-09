package com.programmers.one;

import java.util.*;

/**
 * 베스트 플레이어
 *
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 * */
public class Two {

    /**
     * 비교를 위해서 구현해야하는 인터페이스
     *
     * 필요한 정보를 묶는 것이 핵심
     * */
    class Song implements Comparable{
        public int id;
        public String genre;
        public int play;
        public int sum;

        /**
         * 받은 것과 비교해서
         *
         * 1 리턴시    => 매개변수로 받은 객체가 앞으로 감
         * -1 리턴시   => 자기 자신의 객체가 앞으로 감
         * */
        @Override
        public int compareTo(Object o) {
            Song song = (Song)o;

            // sum
            if (this.sum > song.sum) return -1;
            else if (this.sum < song.sum) return 1;

            else if (this.play > song.play) return -1;
            else if (this.play < song.play) return 1;

            else if (this.id > song.id) return 1;
            else if (this.id < song.id) return -1;

            else return 0;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> sum = new HashMap<>();

        // 합계 구함
        for (int i=0; i<genres.length; i++) {
            sum.put(genres[i], sum.containsKey(genres[i]) ? sum.get(genres[i]) + plays[i] : plays[i]);
        }


        List<Song> songs = new ArrayList<>();

        for (int i=0; i<genres.length; i++) {
            Song song = new Song();
            song.id = i;
            song.play = plays[i];
            song.genre = genres[i];
            song.sum = sum.get(genres[i]);

            songs.add(song);
        }

        // 정렬 기준에 맞춰 정렬된 곡을 분류
        Collections.sort(songs);

        int len = 1;
        String gen = "";
        List<Integer> result = new ArrayList<>();

        for (Song song : songs) {
            // 장르가 다르면
            if (!song.genre.equals(gen)) {
                gen = song.genre;
                result.add(song.id);
                len = 1;
            } else {
                if (len > 1) continue;

                len++;
                result.add(song.id);
            }
        }

        // Integer List를 정수 배열로 변환하는 방법
        return result.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        Two two = new Two();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(two.solution(genres, plays)));
    }
}
