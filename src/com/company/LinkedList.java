package com.company;

public class LinkedList {
    /*
LinkedList list = new LinkedList();
list.add("1");
list.add("2");
list.add("3");
list.add("4");
System.out.println("============");

for (int i=0; i<list.size(); i++) {
    System.out.println((String)list.get(i));
}
System.out.println("============");

//System.out.println(test.size());
list.remove(0);
System.out.println("============");

for (int i=0; i<list.size(); i++) {
    System.out.println((String)list.get(i));
}
=> 사용방법

    * */
    private Node node;
    public LinkedList() {
        if(null == node) {
            node = new Node("");
        }
    }

    public class Node {
        private Object data;
        private Object next;

        public Node(Object data, Object next) {
            this.data = data;
            this.next = next;
        }
        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node node(int k) {
        Node result = this.node;
        // 첫 노드를 기준으로 삼는다
        for (int t=0; t<k; t++) {
            result = (Node)result.next;
        }
        return result;
    }

    public int size() {
        int result = 0;
        // 첫 노드를 기준으로 삼는다
        Node lastNode = this.node;
        // 첫 노드를 기준 다음이 없을 때까지 찾는다.
        while(lastNode.next != null) {
            result++;
            lastNode = (Node)lastNode.next;
        }
        return result;
    }

    public void add(Object data) {
        Node lastNode = node(this.size());
        Node newNode = new Node(data);
        lastNode.next = newNode;
    }

    // 제거
    public void remove(int i) {
        if (i < 0) {
            return;
        }
        Node target = this.node;    // 제거할 노드
        Node before = null;         // 제거할 노드의 이전 노드
        Node after = null;          // 제거할 노드의 다음 노드

        before = node(i);
        //속도 개선을 위해 node 메소드 사용 X
        target = (Node)before.next;
        after = (Node)target.next;

        //마지막
        if (null == after) {
            //메모리 상에서 제거
            target.data = null;
            //이전 주소 데이터 제거
            before.next = null;

        //다음을 이어줘야 하는 경우
        } else {
            before.next = after;
        }
    }

    public Object get(int i) {
        Node result = this.node;
        // 첫 노드를 제외하고 출력하므로
        for (int t=0; t<i+1; t++) {
            result = (Node)result.next;
        }
        return result.data;
    }




}
