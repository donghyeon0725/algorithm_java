package com.fcamp.binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[20];

        // 탐색을 위한 속도가 O (1)
        Set<Integer> set = new HashSet<>();

        while (set.size() < 20) {
            int random = (int)(Math.random() * 100) + 1;

            if (!set.contains(random))
                set.add(random);
        }


        List<Integer> arrList = set.stream().sorted().collect(Collectors.toList());
        for (int i=0; i<arr.length; i++)
            arr[i] = arrList.get(i);


        System.out.println(Arrays.toString(arr));

        BinarySearch binarySearch = new BinarySearch();

        System.out.println(binarySearch.search(arr, 30));
    }


    public boolean search(int[] arr, int target) {
        if (arr.length == 1) {
            if (arr[0] == target)
                return true;
            else
                return false;
        }

        int middle = arr.length / 2;

        if (arr[middle] == target)
            return true;

        // 더 작은 범위 탐색하기
        if (arr[middle] > target)
            return search(Arrays.copyOfRange(arr, 0, middle), target);
        else
            return search(Arrays.copyOfRange(arr, middle + 1, arr.length), target);

    }
}
