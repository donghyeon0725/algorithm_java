package com.company;

public class LinkedList {
    private Node head;
    public LinkedList() {
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
        Node result = this.head;
        // 첫 노드를 기준으로 삼는다
        for (int t=0; t<k; t++) {
            result = (Node)result.next;
        }
        return result;
    }

    public int size() {
        if (this.head == null) {
            return 0;
        }

        int result = 1;
        // 첫 노드를 기준으로 삼는다
        Node lastNode = this.head;
        // 첫 노드를 기준 다음이 없을 때까지 찾는다.
        while(lastNode.next != null) {
            result++;
            lastNode = (Node)lastNode.next;
        }
        return result;
    }

    public void add(Object data) {
        if (this.size() == 0) {
            this.head = new Node(data);
            return;
        }

        Node lastNode = node(this.size()-1);
        Node newNode = new Node(data);
        lastNode.next = newNode;
    }

    public void add(int index, Object data) {
        // 해더를 변경하는 작업을 해준다.
        if (index == 0) {
            Node curNode = (Node)this.head;
            this.head = new Node(data);
            this.head.next = curNode;
            return;
        }
        Node prevNode = node(index-1);
        Node nextNode = (Node)prevNode.next;
        Node newNode = new Node(data);
        prevNode.next = newNode;
        newNode.next = nextNode;
    }

    // 제거
    public void remove(int i) {
        if (i < 0) {
            return;
        }
        if (i == 0) {
            Node nextNode = (Node)this.head.next;
            this.head = nextNode;
            return;
        }

        Node target = this.head;    // 제거할 노드
        Node before = null;         // 제거할 노드의 이전 노드
        Node after = null;          // 제거할 노드의 다음 노드

        before = node(i-1);
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
        Node result = this.head;
        // 첫 노드를 제외하고 출력하므로
        for (int t=0; t<i; t++) {
            result = (Node)result.next;
        }
        return result.data;
    }




}
