package com.hashtable;

import com.linkedlist.LinkedList;

/**
 * **원리(Chaining 기법으로 충돌 해결[배열에 링크드리스트를 넣는 방법])**
 *
 * 해시 값을 가져온다.
 * 해시 값을 배열의 인덱스로 변환한다.
 * 인덱스 안에 해시값과 데이터를 함께 넣는다.
 *
 * 1. put
 * 2. get
 * 3. remove
 * 4. getHash
 * 5. convertToIndex
 * 6. searchKey
 *
 * 특히 getHash, convertToIndex, searchKey(슬롯을 찾는다) 세가지 메소드를 신경쓰며 구현하는 것이 구조설계에 있어서 중요한 것 같다.
 * */
public class ChainingHashTable<T> {
    private int capacity;
    LinkedList[] hashtable = null;


    private class Slot<N> {
        int hash = 0;
        N value = null;

        public Slot(int hash, N value) {
            this.hash = hash;
            this.value = value;
        }
    }

    public ChainingHashTable(int capacity) {
        this.capacity = capacity;
        this.hashtable = new LinkedList[capacity];
    }

    public int getHash(String key) {
        int hashCode = 0;
        for(char c : key.toCharArray()) {
            // 아스키 코드를 모두 더한 값을 해시값으로 사용한다.
            hashCode += c;
        }
        return hashCode;
    }

    public int convertToIndex(int hash) {
        return hash % capacity;
    }

    public Slot<T> searchSlot(LinkedList<Slot> list, int hash) {
        if (list == null) return null;
        Slot slot = null;
        for (int i=0; i<list.size(); i++) {
            slot = list.get(i);
            if (slot.hash == hash) {
                return slot;
            }
        }
        return null;
    }

    public void put(String key, T data) {
        int hash = getHash(key);
        int index = convertToIndex(hash);

        if (this.hashtable[index] == null) {
            hashtable[index] = new LinkedList<T>();
        }

        Slot<T> slot = searchSlot(hashtable[index], hash);

        if (slot == null) {
            hashtable[index].add(new Slot<T>(hash, data));
        } else {
            // 슬롯이 이미 있을 때, 키 값이 같은지 다른지 비교해야함
            slot.value = data;
        }
    }


    public T get(String key) {
        int hash = getHash(key);
        int index = convertToIndex(hash);

        if (this.hashtable[index] == null) {
            return null;
        }

        Slot<T> slot = searchSlot(hashtable[index], hash);

        if (slot == null) {
            return null;
        } else {
            return slot.value;
        }
    }

    public void remove(String key) {
        int hash = getHash(key);
        int index = convertToIndex(hash);

        LinkedList<Slot> list = hashtable[index];

        for (int i=0; i<list.size(); i++) {
            if (list.get(i).hash == hash) {
                list.remove(i);
                return;
            }
        }
    }

}
