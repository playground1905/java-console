package com.mycompany;

public class Example2 {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(42);
        Integer b = 42;
        Integer c = 450;
        Integer d = 450;

        System.out.println("a==b? " + (a == b));
        System.out.println("c==d? " + (c == d));

        int u = 42; // 4-byte
        Integer v = Integer.valueOf(42); //12-Byte + 4-Byte = 16-Byte
    }
}
