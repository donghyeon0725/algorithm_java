package com.dataType.speedTest;

import com.dataType.tree.Tree;

public class TreeTest {
    public static void main(String[] args) {
        // Account 계정의 순서를 비교해서 정렬 기준을 만듬 => id값이 높을 수록
        Tree<Account> tree = new Tree<Account>() {

            @Override
            public int compareTo(Account t1, Account t2) {
                return t1.getId() - t2.getId();
            }

           /* @Override
            public boolean equals(Account t1, Account t2) {

                return this.compareTo(t1, t2) == 0;//t1.getId().equals(t2.getId()) && (t1.getOrder() == t2.getOrder());
            }*/
        };

        Account account1 = new Account("one", 1);
        Account account2 = new Account("two", 2);
        Account account3 = new Account("three", 3);
        Account account4 = new Account("four", 4);
        Account account5 = new Account("five", 5);
        Account account6 = new Account("six", 6);
        Account account7 = new Account("seven", 7);
        Account account8 = new Account("eight", 8);
        Account account9 = new Account("nine", 9);
        Account account10 = new Account("ten", 10);
        Account account11 = new Account("eleven", 11);
        Account account12 = new Account("twelve", 12);
        Account account13 = new Account("thirteen", 13);
        Account account14 = new Account("fourteen", 14);
        Account account15 = new Account("fifteen", 15);

        tree.insert(account8);
        tree.insert(account4);
        tree.insert(account12);
        tree.insert(account2);
        tree.insert(account6);
        tree.insert(account10);
        tree.insert(account14);
        tree.insert(account1);
        tree.insert(account3);
        tree.insert(account5);
        tree.insert(account7);
        tree.insert(account9);
        tree.insert(account11);
        tree.insert(account13);
        tree.insert(account15);

        // 노드 찾기 => 이때 오직 id 값으로 찾음
        boolean result1 = tree.find(account3);
        boolean result2 = tree.find(new Account("one", 16));
        System.out.println(result1); // true
        System.out.println(result2); // false

        // 삭제하기
        tree.delete(account4);

        // 디버깅
        tree.display(account8);
        tree.display(account6);
        tree.display(account5);

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
