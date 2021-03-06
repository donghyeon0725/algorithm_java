package com.passByTest;

public class passByTest {
    public static void main(String[] args) {
        System.out.println("자바는 pass by value이다. 다만 아래와 같은 결과가 나오는 이유는, 객체의 주소를 복사해서 넘겨주기 때문이다.");
        Model model = new Model("A");

        modify1(model);

        System.out.println(model.getModel());

        modify2(model);

        System.out.println(model.getModel());

        int a = 7;
        modify(a);
        System.out.println(a);
    }

    public static void modify(int t) {
        t = 0;
    }

    public static void modify1(Model model) {
        model.setModel("B");
    }

    public static void modify2(Model model) {
        model = new Model("C");
    }
}
