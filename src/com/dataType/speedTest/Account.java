package com.dataType.speedTest;

public class Account {
    private String id;
    private int order;

    public Account(String id, int order) {
        this.id = id;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", order=" + order +
                '}';
    }
}
