package com.dataType.speedTest;

import com.dataType.linkedlist.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LInkedListImplement();
    }
    /**
     * 구현한 링크드 리스트 테스트
     */
    private static void LInkedListImplement() {
        LinkedList<String> list = new LinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println("============");
        for (int i=0; i<list.size(); i++) {
            System.out.println((String)list.get(i));
        }
        System.out.println("============");

        //System.out.println(test.size());
        list.remove(0);

        list.add(0, "9");
        System.out.println("============");

        for (int i=0; i<list.size(); i++) {
            System.out.println((String)list.get(i));
        }

    }
}
