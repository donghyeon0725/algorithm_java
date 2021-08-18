package com.programmers.two;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/67258
 * */
public class Seven {


    public int[] solution(String[] gems) {
        Set<String> gemStones = new HashSet<>();

        for (String gem : gems) {
            gemStones.add(gem);
        }

        int target = gemStones.size();
        int start = 0, end = 0;
        while (start == 0) {
            for (int i=0; i<=gems.length - target; i++) {
                Set<String> temp = new HashSet<>();
                for (int j=i; j<i + target; j++) {
                    temp.add(gems[j]);
                }

                if (gemStones.size() == temp.size()) {
                    start = i + 1;
                    end = i + target;
                    break;
                }
            }

            target++;
        }

        return new int[]{start, end};
    }


    public int[] solution1(String[] gems) {

        Set<String> gemStones = new HashSet<>();

        for (String gem : gems) {
            gemStones.add(gem);
        }

        int target = gemStones.size();
        int start = 0, end = 0;
        while (start == 0) {
            for (int i=0; i<=gems.length - target; i++) {
                Set<String> temp = new HashSet<>();

                int duplication = 0;
                // 만약 구하려는 target 이 5이고 genStones 의 사이즈가 4라면 3번 이상 중복되는 구간이 있으면 안된다.
                // 중복의 수만 구하면 될 것 같은데 중복인지 아닌지 어떻게 알까
                for (int j=i; j<i + target; j++) {
                    if (temp.contains(gems[j]))
                        duplication++;
                    else
                        temp.add(gems[j]);

                    if (gemStones.size() + duplication > target + 1)
                        break;
                }

                if (gemStones.size() == temp.size()) {
                    start = i + 1;
                    end = i + target;
                    break;
                }
            }

            target++;
        }

        return new int[]{start, end};
    }

    public int[] solution2(String[] gems) {

        List<String> gemStones = new ArrayList<>();

        for (String gem : gems) {
            if (!gemStones.contains(gem))
                gemStones.add(gem);
        }

        int stoneSize = gemStones.size();
        int target = gemStones.size();
        int start = 0, end = 0;
        while (start == 0) {
            for (int i=0; i<=gems.length - target; i++) {
                Map<String, Integer> temp = new HashMap<>();
                int duplication = 0;

                for (int j=i; j<i + target; j++) {
                    if (temp.get(gems[j]) == null)
                        temp.put(gems[j], 1);
                    else
                        duplication++;

                    if (stoneSize + duplication > target + 1)
                        break;
                }

                if (stoneSize == temp.size()) {
                    start = i + 1;
                    end = i + target;
                    break;
                }
            }

            target++;
        }

        return new int[]{start, end};
    }

    public int[] solution3(String[] gems) {

        Set<String> gemStones = new HashSet<>();

        for (String gem : gems)
            gemStones.add(gem);

        int stoneSize = gemStones.size(), len = gemStones.size();
        int start = 0, end = 0;
        int[] result = new int[gems.length];


        // 5 크기에 4개짜리 다른 종류의 보석이 있다면 최소 1번 인덱스까지는 검사해야함
        for (int s=0; s<=gems.length - stoneSize; s++) {
            Set<String> temp = new HashSet<>();
            int e = s;

            while (temp.size() < stoneSize && e < gems.length) {
                temp.add(gems[e]);
                e++;
            }

            // 크기가 같아진 구간이 왔다면
            if (temp.size() == stoneSize)
                result[s] = e - s;
            // 구간 사이의 크기가 최소 값이라면 break;
            if (e - s == stoneSize - 1)
                break;
        }

        int idx = 0, min = Integer.MAX_VALUE;

        for (int i=0; i<result.length; i++) {
            if (result[i] != 0 && min > result[i]) {
                idx = i;
                min = result[i];
            }
        }

        return new int[]{idx + 1, idx + result[idx]};
    }

    static class Repository {
        private Map<String, Integer> repository = new HashMap<>();

        public void add(String data) {
            if (repository.containsKey(data))
                repository.put(data, repository.get(data) + 1);
            else
                repository.put(data, 1);
        }

        public void remove(String data) {

            if (repository.containsKey(data)) {
                if (repository.get(data) <= 1)
                    repository.remove(data);
                else
                    repository.put(data, repository.get(data) - 1);
            }
        }

        public int getSize() {
            return this.repository.keySet().size();
        }

        public void clear(){
            this.repository.clear();
        }

        public Map getMap(){
            return this.repository;
        }
    }

    public int[] solution4(String[] gems) {

        Set<String> gemSet = Arrays.stream(gems).collect(Collectors.toSet());

        int stoneSize = gemSet.size(), len = gemSet.size();
        Repository repository = new Repository();

        int[] result = new int[2];

        while (len <= gems.length) {

            for (int i=0; i<len; i++)
                repository.add(gems[i]);

            if (repository.getSize() == stoneSize) {
                result[0] = 0 + 1;
                result[1] = len;
                break;
            }

            int s = 0, e = s + len;

            // 마지막 것은 추가하고 처음 것은 제거
            for (; e<gems.length; s++, e++) {
                repository.remove(gems[s]);
                repository.add(gems[e]);

                if (repository.getSize() == stoneSize) {
                    // 제거한 인덱스 + 1 (번호 + 1)
                    result[0] = s + 1 + 1;
                    result[1] = s + 1 + len;
                    break;
                }
            }

            if (result[1] != 0)
                break;

            repository.clear();
            len++;
        }

        return result;
    }

    public int[] solution5(String[] gems) {
        int[] result = new int[2];

        Set<String> set = new HashSet<>();

        for (String g : gems)
            set.add(g);

        int kind = set.size();

        Repository repository = new Repository();
        int start = 0, end = 0;
        int minDist = Integer.MAX_VALUE;

        while(true) {

            if (repository.getSize() >= kind) {
                repository.remove(gems[start]);
                start++;
            }
            else if (end == gems.length)
                break;
            else {
                repository.add(gems[end]);
                end++;
            }


            if (repository.getSize() == kind) {
                if (Math.abs(end - start) < minDist) {
                    minDist = Math.abs(end - start);
                    result[0] = start + 1;
                    result[1] = end;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems1 = {"AA", "AB", "AC", "AA", "AC"};
        String[] gems2 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        String[] gems3 = {"A","B","B","B","B","B","B","C","B","A"};

        Seven seven = new Seven();
        System.out.println(Arrays.toString(seven.solution4(gems3)));
    }
}
