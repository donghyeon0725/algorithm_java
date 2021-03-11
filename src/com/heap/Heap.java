package com.heap;

public abstract class Heap<T> {
    public enum HEAP_TYPE {
        MIN,MAX
    }

    private final int HEAP_MEMORY_SIZE = Integer.MAX_VALUE / 100000;
    private HEAP_TYPE type = null;
    private T[] list = null;
    private Heap() {}


    public Heap(HEAP_TYPE type) {
        this.type = type;
        // 직접 제네릭을 인스턴스화 할 수 없기 때문에 이런 방식을 사용한다.
        this.list = (T[]) new Object[HEAP_MEMORY_SIZE];
    }


    public abstract int compareTo(T t1, T t2);

    public void insert(T value) {
        int lastIdx = getSize();
        if (lastIdx < 1) {
            list[0] = value;
            return;
        }

        //일단 삽입
        list[lastIdx] = value;

        boolean isMax = HEAP_TYPE.MAX == this.type;
        if (isMax) {

            while( compareTo( list[ (lastIdx-1) / 2], list[lastIdx] ) < 0 && lastIdx > 0) {
                swap( (lastIdx-1) / 2, lastIdx );
                lastIdx = (lastIdx-1) / 2;
            }
        } else {

            while( compareTo( list[(lastIdx-1) / 2], list[lastIdx] ) > 0 && lastIdx > 0) {
                swap( (lastIdx-1) / 2, lastIdx );
                lastIdx = (lastIdx-1) / 2;
            }
        }
    }

    private void swap(int i1, int i2) {
        if (i1 == i2) {
            return;
        }

        T t = list[i2];
        list[i2] = list[i1];
        list[i1] = t;
    }

    public int getSize() {
        int result = 0;
        for( int i=0; i<list.length; i++ ) {
            if (list[i] == null) break;
            result++;
        }
        return result;
    }

    public T get(int i) {
        return list[i];
    }

    public T pop() {
        int size = getSize();
        if (size < 1) return null;
        T result = list[0];

        for (int i=0; i<size-1; i++) {
            list[i] = list[i+1];
        }
        list[size] = null;
        return result;
    }

}
