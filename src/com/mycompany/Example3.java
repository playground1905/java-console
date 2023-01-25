package com.mycompany;

import java.math.BigDecimal;

public class Example3 {
    public static void main(String[] args) {
//        float alininParasi = 1.00f;
//        float sekerinFiyati = 0.10f;
//        int aldigiSekerSayisi = 0;
//        System.out.println("Ali'nin cebinde " + alininParasi + " TL'si vardır");
//        System.out.println("Bakkldaki şekerin tanesi " + sekerinFiyati + " TL'dir");
//        while(alininParasi>sekerinFiyati){
//            alininParasi = alininParasi - sekerinFiyati;
//            aldigiSekerSayisi++;
//        }
//
//        System.out.println("Hesaba göre Ali bakkldan " + aldigiSekerSayisi +" seker alabilir ve cebinde de " + alininParasi + " TL'si kalır.");


        BigDecimal alininParasi = new BigDecimal("1.00");
        BigDecimal sekerinFiyati = new BigDecimal("0.1");
        int aldigiSekerSayisi = 0;

        while (alininParasi.compareTo(sekerinFiyati) >= 0) {
            aldigiSekerSayisi++;
            alininParasi = alininParasi.subtract(sekerinFiyati);
        }

        System.out.println("Hesaba göre Ali bakkaldan " + aldigiSekerSayisi +" seker alabilir ve cebinde de " + alininParasi + " TL'si kalır.");

    }
}
