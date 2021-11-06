package com;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class One {
    public int[] solution(int[] arr) {
        int maxCount = Integer.MIN_VALUE;
        Map<Integer, Integer> count = new HashMap<>();
        int[] nums = {1, 2, 3};
        int[] answer = {0, 0, 0};

        for (int a : arr)
            count.put(a, count.getOrDefault(a, 0) + 1);


        for (int a : nums)
            if (maxCount < count.getOrDefault(a, 0))
                maxCount = count.getOrDefault(a, 0);

        for (int i=0; i<nums.length; i++) {
            answer[i] = maxCount - count.getOrDefault(nums[i], 0);
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3, 3, 3};
        One temp = new One();
        System.out.println(Arrays.toString(temp.solution(arr)));
    }
}

