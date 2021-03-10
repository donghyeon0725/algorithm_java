package com.speedTest;

public class MemoryTest {
    public static void main(String[] args) {

        // Garbage Collection으로 메모리 초기화
        System.gc();

        // 실행전 메모리 사용량 조회
        long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // 측정하고싶은 코드



        /*String str = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaa";
        String str2 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaa";
        String str3 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaa";
        String str4 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaa";
        String str5 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaa";
       */
        // Garbage Collection으로 메모리 정리
        System.gc();

        // 실행 후 메모리 사용량 조회
        long after  = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        long usedMemory = (before - after)/1024/1024;

        long heapSize = Runtime.getRuntime().maxMemory();

        // 애플리케이션에 할당돈 힙메모리 사이즈. 이 사이즈를 넘어서면 OOM발생
        System.out.println("메모리 사용량 : " + usedMemory);
        // 애플리케이션에 할당돈 힙메모리 사이즈. 이 사이즈를 넘어서면 OOM발생
        System.out.println("힙 메모리 사용량 : " + heapSize/1024/1024);
    }
}
