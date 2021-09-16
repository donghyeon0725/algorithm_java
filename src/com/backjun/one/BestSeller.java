package com.backjun.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class BestSeller {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<len; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }


        int max = 0;
        String book = null;
        for (String key : map.keySet()) {
            if (max < map.get(key)) {
                max = map.get(key);
                book = key;
            } else if (max == map.get(key)) {
                String[] arr = {book, key};

                if (book == null)
                    arr = new String[]{key};

                Arrays.sort(arr);

                max = map.get(arr[0]);
                book = arr[0];
            }
        }

        System.out.println(book);
    }
}
