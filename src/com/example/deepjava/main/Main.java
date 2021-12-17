package com.example.deepjava.main;

import com.example.deepjava.stream.StreamBasic;

public class Main {
    public static void main(String[] args) {
        StreamBasic stream = new StreamBasic();
        stream.streamEx3();

        System.out.println(stream.streamEx4(new String[][]{
                {"1", "number"},
                {"2", "number"},
                {"a", "alphabet"},
                {"b", "alphabet"},
                {"ⅰ", "roma"},
                {"ⅱ", "roma"},
                {"ㄱ", "korean"},
                {"ㄴ", "korean"}}
        ));
    }
}
