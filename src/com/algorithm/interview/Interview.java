package com.algorithm.interview;

import java.util.HashSet;
import java.util.Set;

public class Interview {

    // 정렬되지 않은 정수 배열이 있다. 두 수의 합(정수) 어떤수가 주어지면 이 수가 배열에 있는 수로 구성할 수 있으면 true 아니면 false를 리턴하는 함수를 구현하시오.
    // 즉, 배열 [3, 5, 1, 12, 13, 15, 19, 22, -33,......., 4] 가 있고 두 수의 합이 9가 주어지면 함수는 true를 반환 해야합니다.
    public boolean run1(int[] arr, int target) {

        boolean result = false;

        for (int i=0; i<arr.length; i++) {
            for (int j=i + 1; j<arr.length - 1; j++) {
                if (arr[i] + arr[j] == target) {
                    result = true;
                }
            }
        }

        return result;
    }

    public boolean run1_better(int[] arr, int target) {
        Set<Integer> box = new HashSet<>();

        for (int number : arr) {
            box.add(number);
            int temp = target - number;
            if (box.contains(temp)) {
                return true;
            }
        }

        return false;
    }


}
