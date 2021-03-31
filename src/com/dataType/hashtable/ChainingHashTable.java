package com.dataType.hashtable;

import com.dataType.linkedlist.LinkedList;

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
    /**
     * 데이터를 저장할 배열을 생성
     * 해시값으로 얻은 인덱스가 충돌의 경우를 대비해서 LinkedList로 생성을 한다.
     */
    LinkedList[] hashtable = null;

    /**
     * 데이터를 저장하는 구조이다.
     * 고유 식별 값인 해시와 데이터를 저장하는 공간이다.
     * */
    private class Slot<N> {
        int hash = 0;
        N value = null;

        public Slot(int hash, N value) {
            this.hash = hash;
            this.value = value;
        }
    }

    /**
     * 생성자를 통해서 저장 공간의 크기를 정한다.
     *
     * 슬롯을 더 많이 사용할 수록 해시 충돌이 적어서, 접근이 빠르다.
     * */
    public ChainingHashTable(int capacity) {
        this.capacity = capacity;
        this.hashtable = new LinkedList[capacity];
    }

    /**
     * 값을 식별할 해쉬값을 얻는다.
     * */
    private int getHash(String key) {
        int hashCode = 0;
        for(char c : key.toCharArray()) {
            // 아스키 코드를 모두 더한 값을 해시값으로 사용한다.
            hashCode += c;
        }
        return hashCode;
    }

    /**
     * 해시값을 인덱스로 변환한다.
     * */
    private int convertToIndex(int hash) {
        return hash % capacity;
    }

    /**
     * 인덱스를 통해 찾은 LinkedList에서 hash 값을 비교하여 슬롯을 찾아온다.
     * */
    private Slot<T> searchSlot(LinkedList<Slot> list, int hash) {
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

    /**
     * 데이터를 삽입한다.
     *
     * 1. 해시값을 받는다.
     * 2. 인덱스로 변환해서 얻은 주소로 접근한다.
     * 3. 접근한 주소에 값이 없으면 링크드 리스트를 생성하고 있으면, 슬롯을 찾는다.
     * 4. 중복되는 키 값이면 덮어쓰기, 아닌 경우 그냥 추가
     * */
    public void put(String key, T data) {
        int hash = getHash(key);
        int index = convertToIndex(hash);

        if (this.hashtable[index] == null) {
            hashtable[index] = new LinkedList<T>();
        }

        // 슬롯을 찾는다.
        Slot<T> slot = searchSlot(hashtable[index], hash);

        if (slot == null) {
            hashtable[index].add(new Slot<T>(hash, data));
        } else {
            // 슬롯이 이미 있을 때, 키 값이 같은지 다른지 비교해야함
            slot.value = data;
        }
    }

    /**
     * 인덱스로 링크드리스트를 찾고
     * 찾은 링크드 리스트에서 슬롯을 찾아 data를 반환한다.
     * */
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

    /**
     * 인덱스를 먼저 찾고
     * 찾은 링크드리스트에 동일한 해시값을 가진 슬롯이 있으면 제거
     * */
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
