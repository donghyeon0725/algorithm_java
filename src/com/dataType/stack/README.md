스택
-

구조
-
* 데이터를 넣은 곳에서 빼낼 수 있는 구조(한쪽 끝에서만)
* 가장 나중에 넣은 것이 가장 처음 (LIFO)

활용
-
컴퓨터 내부 프로세스 중, 함수를 호출할 때 작동하는 방식을 구현하기 위해 사용
예를 들어
```java
public static void main(String[] args) {
    doFilter();
}

public static void doFilter() {
    System.out.println(getString());
}

public static String getString() {
    return "문자열";
}
```
위 코드에서 main을 호출하면 실행계획은 아래와 같다.  
1. main
2. doFilter()
3. getString()  
순서대로 메소드를 찾고 실행은
1. getString()
2. doFilter()
3. main  
순서로 실행 된다. 
즉 먼저 쌓인 실행할 메소드가 나중에 실행된다.  
즉 실행할 메소드를 스택에 쌓아두고 나중에 쌓인 메소드를 먼저 실행한다.

이 점을 이용해서 메소드 실행 프로세스를 구현한다.

* 장점 : 단순한 구조. 구현이 쉽다. 읽고 쓰는 속도가 빠름
* 데이터 최대 개수를 미리 지정해야한다. 그래서 저장공간의 낭비가 발생할 수 있다.
