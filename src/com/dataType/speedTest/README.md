ListSpeedTest.java
-

LinkedList VS ArrayList
-
    100000개 추가하는 시간
    * LinkedList : 9
    * ArrayList : 4
    100000개중 10000개
    중간 부분에 추가하는 시간
    * LinkedList : 1178
    * ArrayList : 82
    앞 부분에 추가하는 시간
    * LinkedList : 202
    * ArrayList : 163
    0번에 추가하는 시간
    * LinkedList : 72
    * ArrayList : 224
    
    100000개중 10000개
    중간 부분 삭제하는 시간
    * LinkedList : 1489
    * ArrayList : 63
    앞 부분 삭제하는 시간
    * LinkedList : 266
    * ArrayList : 430
---
| |ArrayList|LinkedList|
|---|---|---|
|인덱싱|O(1)|O(n)|
|수정/삭제(앞에서)|O(n)|O(1)|
|수정/삭제(뒤에서)|O(1)|O(n) => O(1)(마지막노드를 저장한 경우)|
|수정/삭제(중간)|O(n)|검색시간+O(1)|
|공간복잡도(평균)|O(n)|O(n)|
---

시간이 이렇게 측정되는 원인
-  
* 링크드 리스트는 노드를 앞에서 부터 찾기 때문에 순차적으로 뒷 부분에 추가하면 검색에 많은 시간을 쏟는다.    
* 어레이 리스트는 뒤로 가도 검색에 걸리는 시간은 적고, 앞으로 당겨줘야하는 하는 값의 개수가 줄어들어서 시간도 줄어든다.  
* 반면 추가하는 부분이 앞쪽으로 갈 수록 링크드리스트는 줄어들고(검색속도는 줄어들고 연결하는데 걸리는 시간은 더 빠르니) 어레이 리스트는 늘어난다.