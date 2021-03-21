package com.algorithm.sort;

public class Account implements Comparable<Account>{
    private int order;
    private String name;

    public Account(int order, String name) {
        this.order = order;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "Account{" +
                "order=" + order +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 이 메소드를 오버라이드 해야만, 순서를 비교할 수 있다.
     * */
    @Override
    public int compareTo(Account o) {
        if (this.getOrder() == o.getOrder()) {
            return 0;
        } else if (this.getOrder() - o.getOrder() > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
