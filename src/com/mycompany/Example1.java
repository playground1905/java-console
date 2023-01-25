package com.mycompany;

public class Example1 {
    public static void main(String[] args) {
        String first = "Baeldung";
        String second = "Baeldung";
        String third = new String("Baeldung");
        String fourth = new String("Baeldung");

        System.out.println("first == second? " + (first == second));
        System.out.println("third == fourth? " + (third == fourth));
        System.out.println("first == third? " + (first == third));
    }
}
