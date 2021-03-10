package com.speedTest;

import com.tree.Tree;

public class TreeTest {
    public static void main(String[] args) {

        Tree<Account> tree = new Tree<Account>() {

            @Override
            public int compareTo(Account t1, Account t2) {
                return t1.getOrder() - t2.getOrder();
            }

           /* @Override
            public boolean equals(Account t1, Account t2) {

                return this.compareTo(t1, t2) == 0;//t1.getId().equals(t2.getId()) && (t1.getOrder() == t2.getOrder());
            }*/
        };

        tree.insert(new Account("eight", 8));
        tree.insert(new Account("four", 4));
        tree.insert(new Account("twelve", 12));
        tree.insert(new Account("two", 2));
        tree.insert(new Account("six", 6));
        tree.insert(new Account("ten", 10));
        tree.insert(new Account("fourteen", 14));
        tree.insert(new Account("one", 1));
        tree.insert(new Account("three", 3));
        tree.insert(new Account("five", 5));
        tree.insert(new Account("seven", 7));
        tree.insert(new Account("nine", 9));
        tree.insert(new Account("eleven", 11));
        tree.insert(new Account("thirteen", 13));
        tree.insert(new Account("fifteen", 15));



        boolean result1 = tree.find(new Account("kim", 3));
        boolean result2 = tree.find(new Account("one", 16));
        System.out.println(result1);
        System.out.println(result2);

       tree.delete(new Account("aa",4));
       tree.display(new Account("sad", 8));
       tree.display(new Account("sad", 6));
       tree.display(new Account("sad", 5));

//        tree.display(new Account("asd",8));
//        tree.display(new Account("asd",12));
//        tree.display(new Account("asd",6));
//
//
//        tree.delete(new Account("aaa", 4));
//        tree.display(new Account("asd",6));
//
//        tree.delete(new Account("aaa", 15));
//        tree.display(new Account("asd",14));
//
//
//        tree.delete(new Account("aaa", 1));
//        tree.display(new Account("asd",2));



    }

}
