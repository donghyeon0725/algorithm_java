package com.dataType.heap;

public abstract class Heap<T> {
    /**
     * 자칫 잘못 생성 될 수 있는 값을
     * 클래스 단에서 정해버림으로써,
     * 의도치 않은 오류를 막을 수 있다.
     * */
    public enum HEAP_TYPE {
        MIN,MAX
    }

    /**
     * 힙은 미리 메모리 공간을 할당해두어야 한다는 단점이 있다.
     *
     * 공간 복잡도가 큰 대신 상대적으로
     * 시간 복잡도는 2logn으로 성능이 나오는 편이다.
     * */
    private final int HEAP_MEMORY_SIZE = Integer.MAX_VALUE / 100000;
    // 정렬 기준 => 최대값, 최소값
    private HEAP_TYPE type = null;
    private T[] list = null;
    private Heap() {}


    public Heap(HEAP_TYPE type) {
        this.type = type;
        // 직접 제네릭을 인스턴스화 할 수 없기 때문에 이런 방식을 사용한다.
        this.list = (T[]) new Object[HEAP_MEMORY_SIZE];
    }

    /**
     * 추상 메소드
     *
     * 비교 기준(대소)을 외부에서 주입 받는다.
     * */
    public abstract int compareTo(T t1, T t2);

    /**
     *
     * */
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
            // 최대 힙인 경우 "상위 노드의 인덱스 값 = (인덱스 값 - 1) / 2" 를 이용해서 상위 노드를 찾고 값을 비교해가며 방금 삽입된 노드의 제자리를 찾아준다.
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

    /**
     * 힙
     * */
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

    /**
     * 공통 : 0번 인덱스의 값을 리턴하고 배열에서는 제거
     *
     * 최대 힙 : 제일 큰값
     * 최소 힙 : 제일 작은 값
     * */
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
