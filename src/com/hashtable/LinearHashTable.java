package com.hashtable;

import com.linkedlist.LinkedList;

/**
 * **원리(Linear 기법으로 충돌 해결[남는 공간을 찾아가는 기법])**
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
public class LinearHashTable<T> {
    private int capacity;
    Slot<T>[] hashtable = null;


    private class Slot<N> {
        int hash = 0;
        N value = null;

        public Slot(int hash, N value) {
            this.hash = hash;
            this.value = value;
        }
    }

    public LinearHashTable(int capacity) {
        this.capacity = capacity;
        this.hashtable = new Slot[capacity];
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

    public void put(String key, T data) {
        int hash = getHash(key);
        int index = convertToIndex(hash);

        if (this.hashtable[index] == null) {
            hashtable[index] = new Slot(hash, data);
            return;
        }



        int nextIndex = index + 1;
        // 빈 공간을 찾을 때까지 탐색
        while( nextIndex < capacity && this.hashtable[nextIndex] != null ) {
            nextIndex++;
        }

        if (this.hashtable[nextIndex] == null) {
            this.hashtable[nextIndex] = new Slot<T>(hash, data);
        }

    }


    public T get(String key) {
        int hash = getHash(key);
        int index = convertToIndex(hash);

        // 비어 있으면 null 리턴
        if (this.hashtable[index] == null) {
            return null;
        }

        if (this.hashtable[index].hash == hash) {
            return this.hashtable[index].value;
        }

        int nextIndex = index + 1;
        //같은 해시값을 찾을 때까지
        while ( nextIndex < capacity && this.hashtable[nextIndex] != null ) {
            if (this.hashtable[index].hash == hash) {
                return this.hashtable[index].value;
            }
            nextIndex++;
        }
        return null;
    }

    // 중간에 값이 삭제 되는 경우, 노드 찾기를 그만두므로, 더미데이터를 넣어줘야 한다.
    public void remove(String key) {
        int hash = getHash(key);
        int index = convertToIndex(hash);

        // 비어 있으면 null 리턴
        if (this.hashtable[index] == null) {
            return;
        }

        int nextIndex = index;
        //같은 해시값을 찾을 때까지
        while ( nextIndex < capacity && this.hashtable[nextIndex] != null) {

            if (this.hashtable[nextIndex].hash == hash) {
                this.hashtable[nextIndex] = new Slot<T>(-1, null); // 더미 데이터
                return;
            }

            nextIndex++;
        }
        return;
    }

}
