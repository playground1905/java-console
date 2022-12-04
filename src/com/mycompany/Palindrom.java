package com.mycompany;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String flag = "";
        System.out.println("Girilen metnin palindrom olup olmadığını kontrol eden uygulama");
        System.out.println("Çıkış için 0 giriniz.");
        do {
            System.out.println("Metin giriniz: ");
            String girilenDeger = scanner.nextLine();
            if (girilenDeger.equals("0")) {
                flag = girilenDeger;
            } else {
                char[] duzArray = new char[girilenDeger.length()];
                char[] tersArray = new char[girilenDeger.length()];
                for (int i = 0; i < girilenDeger.length(); i++) {
                    duzArray[i] = girilenDeger.charAt(i);
                }
                for (int i = girilenDeger.length() - 1, j = 0; i >= 0; i--, j++) {
                    tersArray[j] = girilenDeger.charAt(i);
                }

                boolean palidromMu = true;
                for (int i = 0; i < duzArray.length; i++) {
                    if (duzArray[i] != tersArray[i]) {
                        palidromMu = false;
                    }
                }

                if (palidromMu) {
                    System.out.println("Girilen deger palidromdur. :)");
                } else {
                    System.out.println("Girilen değer palindrom değildir! :(");
                }

            }
        } while (!flag.equals("0"));
        System.out.println("Güle güle...");

    }
}
