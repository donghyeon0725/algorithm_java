package com.dataType.hashtable;

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

    /**
     * 선형 탐색 기법으로 인덱스 값 충돌 문제를 해결한 해시 테이블은 해시 함수의 성능이 곧 테이블의 성능이다.
     *
     * 해시함수가 각각 인덱스 간의 간격이 멀어지도록 잘 설계된 함수라면 빠른 성능을 보장하겠지만,
     * 촘촘하게 인덱스를 반환하는 함수라면 충돌이 많이 일어날 것이고 성능은 떨어지게 된다.
     * */
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

    /**
     * 해시값으로 얻은 인덱스를 찾아갔을 때
     * 이미 값이 있으면 빈 공간이 나올 때까지 찾아가 값을 넣는 방법이다.
     * 이때 해시 값을 슬롯에 같이 넣기 때문에 여전히 값은 식별이 가능하다.
     * */
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

    /**
     * 인덱스로 찾은 값에서 다음 값으로 넘겨가며 해시값을 비교해서 슬롯을 찾아온다.
     *
     * 값이 없다면 더이상 검색을 하지 않는다.
     * */
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

    /**
     * 삭제할 때 중간에 값을 제거해버리면
     *
     * 충돌 문제로 다른 공간에 저장된 데이터에 대한 탐색을 멈춰버릴 가능성이 있기 때문에 그 자리에 비어 있지 않은 다른 값을 넣어주어야 한다.
     * */
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
