package com.backjun.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TreeTour {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        int[] size = {1, 2, 4, 8, 16, 32};

        for (int i=0; i<len; i++) {
            String[] target = br.readLine().split(" ");

            map.put(target[0], map.getOrDefault(target[0], new Node(target[0])));

            Node node = map.get(target[0]);

            if (!".".equals(target[1])) {
                Node left = new Node(target[1]);
                node.setLeft(left);
                map.put(target[1], map.getOrDefault(target[1], left));
            }

            if (!".".equals(target[2])) {
                Node right = new Node(target[2]);
                node.setRight(right);
                map.put(target[2], map.getOrDefault(target[2], right));
            }
        }

        Node root = map.get("A");

        root.searchFront();
        System.out.println();
        root.searchMiddle();
        System.out.println();
        root.searchBack();


    }


    private static HashMap<String, Node> map = new HashMap<>();

    static class Node {
        private String target;
        private Node left;
        private Node right;

        public Node (String target) {
            this.target = target;
        }

        public void setLeft(Node node) {
            this.left = node;
        }

        public void setRight(Node node) {
            this.right = node;
        }

        public void searchBack() {
            if (left != null) {
                left.searchBack();
            }
            if (right != null) {
                right.searchBack();
            }

            System.out.print(target);
        }

        public void searchMiddle() {
            if (left != null) {
                left.searchMiddle();
            }

            System.out.print(target);

            if (right != null) {
                right.searchMiddle();
            }

        }

        public void searchFront() {
            System.out.print(target);

            if (left != null)
                left.searchFront();

            if (right != null)
                right.searchFront();
        }
    }

}
