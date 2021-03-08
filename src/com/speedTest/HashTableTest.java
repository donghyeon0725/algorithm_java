package com.speedTest;

import com.hashtable.ChainingHashTable;
import com.hashtable.LinearHashTable;

public class HashTableTest {
    public static void main(String[] args) {

    }

    public static void ChaniningHashTest() {
        ChainingHashTable ht = new ChainingHashTable(3);

        ht.put("sung", "She is pretty");
        ht.put("jin", "She is model");
        ht.put("hee", "She is hee"); // => 같은 306 번에 해당하는 해쉬값을 가짐
        ht.put("hfd", "She is hfd"); // => 같은 306 번에 해당하는 해쉬값을 가짐
        ht.put("min", "She is cute");
        ht.put("sung", "She is sung"); // 중복된 키값


        System.out.println(ht.get("sung")); // She is pretty 가 아닌 => She is sung
        System.out.println(ht.get("jin"));
        System.out.println(ht.get("hee"));
        System.out.println(ht.get("hfd")); // 해시값 조차 같게 되는 경우 문제가 되긴 함.
        System.out.println(ht.get("min"));
        System.out.println(ht.get("jae")); // null

        ht.remove("hfd");
        System.out.println(ht.get("hfd")); // null
    }

    public static void LinearHashTest() {
        LinearHashTable ht = new LinearHashTable(8);

        ht.put("sung", "She is pretty");
        ht.put("jin", "She is model");
        ht.put("hee", "She is hee"); // => 같은 306 번에 해당하는 해쉬값을 가짐
        ht.put("hfd", "She is hfd"); // => 같은 306 번에 해당하는 해쉬값을 가짐
        ht.put("min", "She is cute");
        ht.put("sung", "She is sung"); // 중복된 키값


        System.out.println(ht.get("sung")); // She is pretty 가 아닌 => She is sung
        System.out.println(ht.get("jin"));
        System.out.println(ht.get("hee"));
        System.out.println(ht.get("hfd")); // 해시값 조차 같게 되는 경우 문제가 되긴 함.
        System.out.println(ht.get("min")); // null
        System.out.println(ht.get("jae")); // null

        ht.remove("hfd");
        System.out.println(ht.get("hfd")); // null
    }
}
