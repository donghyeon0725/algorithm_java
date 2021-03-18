package com.dataType.tree;

public abstract class Tree<T> {
    /**
     * 노드에 왼쪽 오른쪽이 있음을 주의 깊게 본다.
     * 연결 관계를 표시한 것이다.
     * */
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

    /**
     * 비교 기준을 외부에서 구현 받는다.
     * */
    public abstract int compareTo(T t1, T t2);

    /**
     * 값을 비교해서 작으면 왼쪽으로 크면 우측으로 자식 노드를 찾아 나간다.
     * 탐색시 있으면 true 반환
     * */
    public boolean find(T value) {
        Node<T> newNode = new Node<>(value);
        // 첫 노드를 기준으로
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
                return true;
            }
        }
        // Leaf Node 노드까지 탐색했는데도 없는 경우
        return false;
    }

    /**
     * 노드에서 데이터를 꺼내준다.
     * */
    public T get(T value) {
        Node<T> result = getNode(value);
        return result != null ? result.getData() : null;
    }

    /**
     * 노드를 찾아서 있으면 리턴 없으면
     * null 리턴
     * */
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

    /**
     * 부모 노드를 찾는다.
     * 비교값을 비교해서 노드를 찾으면 그 이전에 찾았던 노드를 반환 하고 없으면 null
     * */
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

    /**
     * 값을 비교해서 왼쪽 또는 오른쪽에 노드를 연결한다.
     * */
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

    /**
     * 노드를 삭제할 때 4가지 경우를 따져야 한다.
     *
     * 1. 없는 노드를 삭제하려는 경우
     *      => return
     * 2. 자식 노드가 둘다 없는 경우
     *      => 대상 노드의 부모 노드로 부터 대상 노드와의 연결을 끊으면 됨
     * 3. 하나의 자식 노드를 가진경우
     *      => 대상의 부모 노드로 부터 대상 노드가 있었던 위치(왼쪽, 오른쪽)에 대상 노드의 자식 노드만 연결해주면 됨
     * 4. 자식이 둘다 있는 경우
     *      => 한쪽을 정해서 연결 관계를 재정의 해야함. 우측을 기준으로 하면, 대상 노드의 우측엔 대상 노드보다 큰 값이고 좌측은 착은 값이다.
     *      => 고로 우측에서 가장 작은 값을 찾으면 좌측의 모든 노드 값보다 큰 값이므로, 대상의 왼쪽 자식을 우측 자식중 제일 작은 노드의 왼쪽 자식으로 넣는다.
     *      => 그리고 대상의 우측에 있던 노드를 부모 노드와 연결한다. (원래 대상이 있던 위치에)
     *
     * 어려우면 설명 MarkDown 파일을 참고하길 바란다. (README.md 파일)
     * */
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
