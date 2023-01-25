package com.mycompany;

public class Example4 {
    public static void main(String[] args) {
        // 2's complement nasıl alınır
        //Örn: 10010 önce 1's complemnt 01101 sonra 1 eklenir 01110
        // 10010 2's comolement is '01110 olur.

        byte max = Byte.MAX_VALUE;
        max++;
        System.out.println(max);

        //Byte tipindeki değişken [-128..127] aralığında değer alır.
        //max değişkeni alabileceği en büyük değeri almışken bir artırırsanız, yeni değeri -128 olacaktır.

        //Aynı nedenle aşağıdaki kod sonsuz döngüye girer.
//        int sum = 0;
//        for (byte b = Byte.MIN_VALUE; b <= Byte.MAX_VALUE; b++) {
//            sum += b;
//        }

        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
            if (b == 0x90) {
                System.out.println("Yesssss, I found it!");
            }
        }
        // Tüm tam sayı tipleri (byte,short, int, long) işaretli tam sayıdır.
        // En yüksek anlamlı bit işareti bitini gösteriri positif ya da negatif
        // 0X90 onluk tabanada 144'de ikilik tabanda da -112 ye karşılık gelmektedir.
        // Yukarıda kontrol işlemini onluk tabana göre yapıyor ve 144 değerini arıyor ve if'e girmiyor.
        // 0X90 = 10010000 (2 lik tabanda gösterimi) sayı negatif ilk bit 1 on tabanına çeviriken 1's complementini alıp 1 ekleriz
        // - (01101111 + 00000001) = -112 değerine eşittir
        // Eğer yukarıki kodda gerçekten sekiz bitlik olarak tanımlamak istiyorsak karşılaştırma koşulunu (b==(byte) 0X90) olarak değiştirmeliyiz.

        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
            if (b == (byte) 0x90) {
                System.out.println("Yesssss, I found it!");
            }
        }



    }
}
