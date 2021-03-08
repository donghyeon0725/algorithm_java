package com.linkedlist;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
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

        list.add(1, "9");
        System.out.println("============");

        for (int i=0; i<list.size(); i++) {
            System.out.println((String)list.get(i));
        }



    }
}
