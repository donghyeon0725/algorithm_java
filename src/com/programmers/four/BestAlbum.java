package com.programmers.four;

import java.util.*;

public class BestAlbum {


    static class Album implements Comparable {
        private int seq;
        private int plays;
        private String genres;
        private int totalGenPlays;

        public Album(int seq, int plays, String genres, int totalGenPlays) {
            this.seq = seq;
            this.plays = plays;
            this.genres = genres;
            this.totalGenPlays = totalGenPlays;
        }

        @Override
        public int compareTo(Object o) {
            Album other = (Album) o;

            if (totalGenPlays != other.totalGenPlays) {
                return other.totalGenPlays - totalGenPlays;
            }

            if (plays != other.plays) {
                return other.plays - plays;
            }

            return seq - other.seq;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> totalPlays = new HashMap<>();

        for (int i=0; i<genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
        }

        Album[] albums = new Album[genres.length];

        for (int i=0; i<genres.length; i++) {
            albums[i] = new Album(i, plays[i], genres[i], totalPlays.get(genres[i]));
        }

        Arrays.sort(albums);

        // 장르별로 2개씩 모아야 함
        List<Album> albumList = new ArrayList<>();

        String before = "";
        int cur = 0;
        for (Album album : albums) {
            if (!before.equals(album.genres)) {
                cur = 1;
                before = album.genres;

                albumList.add(album);
            } else {
                if (cur >= 2)
                    continue;

                albumList.add(album);
                cur++;
            }
        }

        return albumList.stream().mapToInt(a -> a.seq).toArray();
    }

    public static void main(String[] args) {
        BestAlbum album = new BestAlbum();
        String[] genres = {"classic", "pop", "classic", "classic", "pop", "temp1", "temp2", "temp1", "temp1"};
        int[] plays = {500, 600, 150, 800, 2500, 200, 700, 200, 200};

        System.out.println(Arrays.toString(album.solution(genres, plays)));
    }

}
