package com.speedTest;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class ListSpeedTest {
    final static String DATA = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
            "\n" +
            "Why do we use it?\n" +
            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).\n" +
            "\n" +
            "\n" +
            "Where does it come from?\n" +
            "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
            "\n" +
            "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.\n" +
            "\n" +
            "Where can I get some?\n" +
            "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc";
    public static void main(String[] args) {
        addInLastSpeedTest();
        addSpeedTest();
        removeSpeedTest();

        /*
        추가하는 시간
        LinkedList : 1079
        ArrayList : 283
        중간 부분에 추가하는 시간
        LinkedList : 1130
        ArrayList : 86
        앞 부분에 추가하는 시간
        LinkedList : 198
        ArrayList : 240
        중간 부분 삭제하는 시간
        LinkedList : 1323
        ArrayList : 51
        앞 부분 삭제하는 시간
        LinkedList : 197
        ArrayList : 110
        */
    }

    /**
     * 추가하는데 걸리는 시간
     */
    private static void addInLastSpeedTest() {
        LinkedList Llist = new LinkedList();
        ArrayList Alist = new ArrayList();
        long bTime = 0;
        long aTime = 0;

        bTime = System.currentTimeMillis();
        for (int i=0; i<100000; i++) {
            Llist.add(DATA);
        }
        aTime = System.currentTimeMillis();
        System.out.println("100000개 추가하는 시간");
        System.out.println("LinkedList : " + (aTime - bTime)); // 216


        bTime = System.currentTimeMillis();
        for (int i=0; i<100000; i++) {
            Alist.add(DATA);
        }
        aTime = System.currentTimeMillis();
        System.out.println("ArrayList : " + (aTime - bTime)); // 136
    }

    /**
     * 앞 부분과 중간 부분의 값 제거하는데 걸리는 시간
     */
    private static void removeSpeedTest() {
        LinkedList Llist = new LinkedList();
        ArrayList Alist = new ArrayList();

        for (int i=0; i<100000; i++) {
            Llist.add(DATA);
        }
        for (int i=0; i<100000; i++) {
            Alist.add(DATA);
        }

        long bTime = 0;
        long aTime = 0;
        int start_1 = 10000;
        int start_2 = 50000;
        int end_1 = 20000;
        int end_2 = 60000;

        bTime = System.currentTimeMillis();
        for (int i=start_2; i<end_2; i++) {
            Llist.remove(i);
        }
        aTime = System.currentTimeMillis();
        System.out.println("100000개중 10000개");
        System.out.println("중간 부분 삭제하는 시간");
        System.out.println("LinkedList : " + (aTime - bTime)); // 1519 => 1.5 초


        bTime = System.currentTimeMillis();
        for (int i=start_2; i<end_2; i++) {
            Alist.remove(i);
        }
        aTime = System.currentTimeMillis();
        System.out.println("ArrayList : " + (aTime - bTime)); // 76


        bTime = System.currentTimeMillis();
        for (int i=start_1; i<end_1; i++) {
            Llist.remove(i);
        }
        aTime = System.currentTimeMillis();
        System.out.println("앞 부분 삭제하는 시간");
        System.out.println("LinkedList : " + (aTime - bTime)); // 216


        bTime = System.currentTimeMillis();
        for (int i=start_2; i<end_2; i++) {
            Llist.remove(i);
        }
        aTime = System.currentTimeMillis();
        System.out.println("ArrayList : " + (aTime - bTime)); // 136
    }

    /**
     * 앞 부분과 중간 부분의 값을 넣는 작업
     */
    private static void addSpeedTest() {
        LinkedList Llist = new LinkedList();
        ArrayList Alist = new ArrayList();

        for (int i=0; i<100000; i++) {
            Llist.add(DATA);
        }
        for (int i=0; i<100000; i++) {
            Alist.add(DATA);
        }

        long bTime = 0;
        long aTime = 0;
        int start_1 = 10000;
        int start_2 = 50000;
        int end_1 = 20000;
        int end_2 = 60000;

        bTime = System.currentTimeMillis();
        for (int i=start_2; i<end_2; i++) {
            Llist.add(i, DATA);
        }
        aTime = System.currentTimeMillis();
        System.out.println("100000개중 10000개");
        System.out.println("중간 부분에 추가하는 시간");
        System.out.println("LinkedList : " + (aTime - bTime)); // 1504 => 1.5 초


        bTime = System.currentTimeMillis();
        for (int i=start_2; i<end_2; i++) {
            Alist.add(i, DATA);
        }
        aTime = System.currentTimeMillis();
        System.out.println("ArrayList : " + (aTime - bTime)); // 79


        bTime = System.currentTimeMillis();
        for (int i=start_1; i<end_1; i++) {
            Llist.add(i, DATA);
        }
        aTime = System.currentTimeMillis();
        System.out.println("앞 부분에 추가하는 시간");
        System.out.println("LinkedList : " + (aTime - bTime)); // 247


        bTime = System.currentTimeMillis();
        for (int i=start_1; i<end_1; i++) {
            Alist.add(i, DATA);
        }
        aTime = System.currentTimeMillis();
        System.out.println("ArrayList : " + (aTime - bTime)); // 249


        bTime = System.currentTimeMillis();
        for (int i=0; i<10000; i++) {
            Llist.add(i, DATA);
        }
        aTime = System.currentTimeMillis();
        System.out.println("0번에 추가하는 시간");
        System.out.println("LinkedList : " + (aTime - bTime)); // 247


        bTime = System.currentTimeMillis();
        for (int i=0; i<10000; i++) {
            Alist.add(i, DATA);
        }
        aTime = System.currentTimeMillis();
        System.out.println("ArrayList : " + (aTime - bTime)); // 249

        /**
         * 시간이 이렇게 측정되는 원인
         * 링크드 리스트는 노드를 앞에서 부터 찾기 때문에, 뒷부분에 노드를 넣어주면 연결하는 시간까지 포함하여, 많은 시간이 걸리지만,
         * 어레이 리스트는 뒤로 갈수록 뒤로 옮겨줘야 하는 값의 개수가 줄어들어서 시간도 줄어든다.
         *
         * 반면 추가하는 부분이 앞쪽으로 갈 수록 링크드리스트는 줄어들고 어레이 리스트는 늘어난다.
         */

    }
}
