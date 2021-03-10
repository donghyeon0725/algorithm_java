package com.tree;

import com.speedTest.Account;
import org.w3c.dom.Node;

import java.util.Objects;

public abstract class Tree<T> {
    class Node<T> {
        private T data;
        private Node left;
        private Node right;
        public Node(T value) {
            this.data = value;
        }

        // equals 구현 한 뒤에 호출하기
        // hashCode 구현하기
        // comparable 을 받아서 좌우 노드를 구분함
        /* 비교하기 */

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    private Node root;

    public Tree() {
        this.root = null;
    }

    public abstract int compareTo(T t1, T t2);

    public boolean find(T value) {
        Node<T> newNode = new Node<>(value);
        Node<T> parent = this.root;
        while (parent != null) {
            // 부모 노드보다 작은 경우
            if (this.compareTo(parent.getData(), newNode.getData()) > 0) {
                parent = parent.getLeft();
            } else if (this.compareTo(parent.getData(), newNode.getData()) < 0) {
                // 부모 노드보다 큰 경우
                parent = parent.getRight();
            } else {
                // 비교값으로 객체를 찾고 equals 함수를 리턴
                return true; // this.equals(parent.getData(), newNode.getData())
            }
        }
        // Leaf Node 노드까지 탐색했는데도 없는 경우
        return false;
    }

    public T get(T value) {
        Node<T> result = getNode(value);
        return result != null ? result.getData() : null;
    }

    private Node<T> getNode(T value) {
        Node<T> newNode = new Node<>(value);
        Node<T> parent = this.root;
        while (parent != null) {
            if (this.compareTo(parent.getData(), newNode.getData()) > 0) {
                parent = parent.getLeft();
            } else if (this.compareTo(parent.getData(), newNode.getData()) < 0) {
                parent = parent.getRight();
            } else {
                return parent;
            }
        }
        return null;
    }

    private Node<T> getParentNode(T value) {
        Node<T> newNode = new Node<>(value);
        Node<T> parent = this.root;
        Node<T> target = this.root;
        while (parent != null) {
            if (this.compareTo(parent.getData(), newNode.getData()) > 0) {
                target = parent;
                parent = parent.getLeft();
            } else if (this.compareTo(parent.getData(), newNode.getData()) < 0) {
                target = parent;
                parent = parent.getRight();
            } else {
                return target;
            }
        }
        return null;
    }

    public void insert(T value) {
        Node<T> newNode = new Node(value);

        //노드가 비어있을 때
        if (this.root == null) {
            this.root = newNode;
            return;
        }

        Node<T> parent = this.root;
        while (parent != null) {
            // 부모 노드보다 작은 경우
            if (this.compareTo(parent.getData(), newNode.getData()) > 0) {
                if (parent.getLeft() == null) {
                    parent.setLeft(newNode);
                }
                parent = parent.getLeft();
            } else if (this.compareTo(parent.getData(), newNode.getData()) < 0) {
                // 부모 노드보다 큰 경우
                if (parent.getRight() == null) {
                    parent.setRight(newNode);
                }
                parent = parent.getRight();
            } else {
                // 같은 경우
                return;
            }
        }
    }

    public void delete(T value) {
        Node<T> parent = getParentNode(value);
        Node<T> target = getNode(value);


        //노드를 찾지 못한 경우
        if (parent == null) {
            return;
        }

        boolean isRight = parent.getRight() == target;
        //둘다 없는 경우
        if (target.getLeft() == null && target.getRight() == null) {
            if (isRight)    parent.setRight(null);
            else            parent.setLeft(null);
        }

        else if (target.getLeft() == null) {
            Node<T> child = target.getRight();
            if (isRight)    parent.setRight(child);
            else            parent.setLeft(child);

        }
        else if (target.getRight() == null) {
            Node<T> child = target.getLeft();
            if (isRight)    parent.setRight(child);
            else            parent.setLeft(child);
            // 둘다 빈값이 아닌 경우
        } else {
            //우측에서 가장 작은 값을 찾음
            Node<T> smallerNode = target.getRight();
            while(smallerNode.getLeft() != null) {
                smallerNode = smallerNode.getLeft();
            }

            smallerNode.setLeft(target.getLeft());
            if (isRight)    parent.setRight(target.getRight());
            else            parent.setLeft(target.getRight());
        }


    }

    public void display(T value) {
        Node<T> node = getNode(value);

        T r = node.getRight() != null ? (T)node.getRight().getData() : null;
        T l = node.getLeft() != null ? (T)node.getLeft().getData() : null;

        System.out.println("우측 자식 : " + (r != null ? r.toString() : null));
        System.out.println("좌측 자식 : " + (l != null ? l.toString() : null));
    }

}
