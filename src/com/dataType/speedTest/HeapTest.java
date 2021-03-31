package com.dataType.speedTest;

import com.dataType.heap.Heap;

public class HeapTest {
    public static void main(String[] args) {
        Heap<Account> heap = new Heap<Account>(Heap.HEAP_TYPE.MAX) {
            @Override
            public int compareTo(Account t1, Account t2) {
                return t1.getId() - t2. getId();
            }
        };

        heap.insert(new Account("eight", 8));
        heap.insert(new Account("four", 4));
        heap.insert(new Account("twelve", 12));
        heap.insert(new Account("two", 2));
        heap.insert(new Account("six", 6));
        heap.insert(new Account("ten", 10));
        heap.insert(new Account("fourteen", 14));
        heap.insert(new Account("one", 1));
        heap.insert(new Account("three", 3));
        heap.insert(new Account("five", 5));
        heap.insert(new Account("seven", 7));
        heap.insert(new Account("nine", 9));
        heap.insert(new Account("eleven", 11));
        heap.insert(new Account("thirteen", 13));
        heap.insert(new Account("fifteen", 15));

        //제거
        heap.pop();

        int size = heap.getSize();
        int dept = 0;
        for (int i=0; i<size; i++) {
            if (i < 2-1) dept = 1;
            else if (i < 4-1) dept = 2;
            else if (i < 8-1) dept = 3;
            else if (i < 16-1) dept = 4;

            System.out.println("depth : " + dept + " / 아이디 : " + heap.get(i).getId() + ",   이름 : " + heap.get(i).getName());
        }
    }
}
