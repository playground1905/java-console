package com.mycompany;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Example5 {
    public static void main(String[] args) {
        // char veri tipi "işaretsiz" 16-bit tam sayı olarak ele alınır.

        // 1000 0001 > decimal - (01111110 + 00000001)
        System.err.println((int) (char) (byte) -1);
        // Yukaraıdaki kod çalışır ise ekranda 65535 değeri görülür. Nedeni char tipinin işaretsiz, int ve byte tam sayı tiplerinin ise işaretli olmasıdır.

        // Tam sayılar (byte, short, int) ile yapılan aritmetik işlemler (+, - , *, /) sonucu her zaman int tipindedir.
        // Bu nedenle derleyici aşağıdaki kod için hata verecektir.

        short x = 42,
                y = 108,
                z = 0;
        //z= x + y; Hatanın açıklamasında "Type mismatch: cannot convert from int to short" yazdığını göreceksiniz.
        // x+y sonucu int tipinde ve bu tipte bir değeri short tipinde bir değişkene yazmak istiyoruz.
        // Çözüm için ya tüm değişkenleri int tipinde tanımlayacağız ya da tip dönüşümü yapacağız.

        z = (short) (x + y);
        System.out.println(z);

        //Bir yol daha var += operatörünü kullanmak. Tüm kısayol operatörleri örtük bir tip dönüşümü barındırırlar.
        //Bu nedenle aşağıdaki kod hatasız derlenir.
        z += x + y;
        System.out.println(z);

        //Tüm tam sayı sabitler "int" tipindedir ve "32" bittir. Sonuna l ya da L koyarsanır "long" sabit tanımlamış olursunuz.
        // 1 ile karışmaması için L kullamak faydalı olacaktır.
        // Bu durumda sabitin uzunluğu iki katına çıkar 64-bit. En uzun tam sayı tipimiz long, yeterince uzun olsa da bir sınırı var. 9223372036854775807
        // Bu sınırı aşarsanız hata yaparsınız aöa hata yaptığınızı fark etmeyebilirsiniz.
        // Daha uzun tam sayılar için java.math.BigInteger sınıfını kullanabilirsiniz.
        // Bu iş için float ya da double kullanmayı düşünüyorsanız yazının devamını okuyun! Kararınızı gözden geçirmeniz gerekebilir.
        // Bir de tam sayılarla çalışırken herhangi bir sayıyı sıfıra bölmeye çalışmayın, bölemezsiniz.

        //int inf = 1/0;
        //int one = 0/0;
        // Yukarıdaki her iki bölme işlemi de RuntimeException fırlatır. java.lang.ArithmeticException: / by zero

        // Kayan noktolı sayıları karşılaştırırken çok daha dikkatli olmak gerekir. Örneğin aşağıdaki kod parçasını inceleyelim.

        double myMoney = 4.35;
        System.err.println("I have worked hard!");
        myMoney *= 100;
        if (myMoney == 435.0) {
            System.err.println("I have $ 435.00 now!");
        }

        // Yukarıda ne yazık ki "if" cümlesindeki karşılaştırma hiçbir zaman "true" olmaz.
        // 4 ile 5 arasında sayılamaz sonsuz sayı bulunur.
        // Amam bizim bu sayılamaz sonsuz sayıda sayıyı kodlamak için sınırlı sayıda bitimiz var:
        // float için 32-bit ve double için 64-bit
        // Kayan noktalı sayılar IEEE-754 standardına göre kodlanırlar. IEEE-754 gösterimi, küçük sayılar için küçük,
        // büyük sayılar için büyük hatalar yapılacak şekilde tasarlanmıştır. Bu kodlamada her kayan noktalı sayıyı gösteremiyoruz,
        // 4.35'de bu tam olarak gösteremediğimiz sayılardan.
        // Üstelik bu şekilde tam oalrak gösteremediğimiz için hata yaptığımız çok sayı var. Ne kadar? Sonsuz sayıda
        // Üstelik ne kadar hata yapılacağınıda kontrol edemiyoruz.
        // !!!! O halde kayan noktalı sayılarla hesaplama yapmak istiyorsanız ve noktadan sonra kaç basamak doğru hesaplamak istediğinizi kontrol etmek istiyorsanız
        // "float" ya da "double" temel tiplerini kullanMAMALIsınız. Bu amaçla "java.util.BigDecimal" sınıfını kullanabilirisiniz.

        BigDecimal myMoney2 = new BigDecimal("4.35");
        myMoney2.setScale(6);
        System.err.println("I have worked hard!");
        myMoney2 = myMoney2.multiply(BigDecimal.valueOf(100.0));
        if (myMoney2.compareTo(BigDecimal.valueOf(435)) == 0) {
            System.err.println("I have 435 TL now ...");
        }

        // Burada setScale metodunu kullanarak noktadan sonra kaçıncı basamağa kadar doğru hesaplamak istediğimizi belirtebiliyoruz.
        // BigDecimal sınıfını kullanarak pi sayısını noktadan sonra örneğin 100.000 basamağa kadar hesaplayabiliriz:

        // Kayan noktalı sayılarda büyük sayılarda daha büyük hatalar yapıyoruz. Bir milyar liranız var ve hesabınıza 50 TL yatırıyorsunuz:

        float yourMoney = 1_000_000_000F;
        yourMoney += yourMoney + 50;
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("tr", "TR"));
        System.err.println("Your money is " + nf.format(yourMoney));

        BigDecimal yourMoney2 = new BigDecimal("1000000000");
        yourMoney2 = yourMoney2.add(new BigDecimal("50"));
        System.err.println("Your money is " + nf.format(yourMoney2));


        //Kayan noktalı sayılarda bölme işlemi RuntimeException fırlatmaz.
        double inf = 1. / 0;
        double negative_inf = -1. / 0;
        double nan = 0. / 0;
        System.err.println(inf);
        System.err.println(negative_inf);
        System.err.println(nan);

        //Yukarıdaki kod ekrana
        //Infinity
        //-Infinity
        // NaN
        // çıktısını veriri.

        //Tam sayılarla çalışırken özel bir durum olmasa da bunların sarmal(wrapper) sınıfıları ile çalışırken dikkatli olmamızı gerektiren bir durum var.

        Integer sayi1 = 108;
        Integer sayi2 = 108;
        System.err.println(sayi1 == sayi2); // true yazar
        Integer sayi3 = 496;
        Integer sayi4 = 496;
        System.err.println(sayi3 == sayi4); // false yazar.

        // Yukarıdaki durumun açıklaması için "Integer" sınıfının kaynak kodunu başvurmalısınız.
        // Sarmal sınıftan bir referans değişkene bir sabiti atarken derleyici gerçekte bu atamayı valueof metod çağrısı üzerinden gerçekleştirir.
        // "valueOf" metodu size ipucu verecektir. Burada "Integer" sınıfınn bir sekizliğe sığan tam sayıları [-128..127] cepte tututuğunu göreceksiniz

        //!!!Bu nedenle karşılaştırmanın her durumda doğru sonuçlanmasını istiyorsanız,
        // referansları değil içeriği karşılaştırın. İçeriği ise her durumda "equals" metodunu kullanarak karşılaştırabilirsiniz.
        Integer lostIsland = 108;
        Integer helixIsland = 108;
        System.err.println(lostIsland.equals(helixIsland));
        Integer perfectNumber = 496;
        Integer nothingSpecial = 496;
        System.err.println(perfectNumber.equals(nothingSpecial));

        // Benzer duruma "String" sınıfında da karşılaşıyoruz. "String" aslında temel tip değil.
        // Ancak onu temel tipler ile birlikte incelememizi gerektirecek ve diğer sınıflarda olmayan bir kullanımı var.
        // JAva programlama dilinde bir sınıftan bir nesne yaratmak istediğimizde "new" operatörünü kullanmanız gerekir.
        // Ancak String ile çalışırken iki farklı şekilde tanımlama yapabiliyoruz.

        String jack1 = "Jack";
        String jack2 = new String("Jack");
        System.err.println(jack1 == jack2);
        // İlk kullanımda String nesnesi bir "String havuzunda" yaratılır.
        // Eğer daha önce aynı karakter katarı yaratılmışsa "jack1" referansı bu nesneyi gösterir. İkinci kullanımda ise String nesnesi her zaman "Heap'de" yaratılır.
        // Bu nedenle String referansları (jack1 ve jack2) karşılaştırılır ise "false" değer üretir.

        String mike1 = "Mike";
        String mike2 = new String("Mike");
        String mike3 = "Mike";
        System.out.println(mike1 == mike2);
        System.out.println(mike1 == mike3);
        System.out.println(mike1.equals(mike2));
        System.out.println(mike1.equals(mike3));


        System.out.println("----");
        // String sınıfında yer alan intern() metodu ile Heap'deki bir String nesnesini String havuzuna getirmek mümkündür.
        String bob1 = "Bob";
        String bob2 = new String("Bob");
        bob2 = bob2.intern();
        System.out.println(bob1==bob2);

        // String sınıfı değiştirilemez bir sınıftır. (immutable) Metodlarının hepsi yeni bir String nesnesi döndürür.
        // Mevcut String nesnesinin karakterleri üzerinde bir değişikliğe neden olmazlar.
        String name= "Jack";
        name.toUpperCase();
        if(name.equals("JACK")){
            System.err.println("Jack the Ripper");
        }else{
            System.err.println("Jack Bauer");
        }

        // Yukarıdaki kod çalıştırıılır ise ekranda "Jack Bauer" iletisi görülür.
        // name.toUpperCase() ifadesi yeni bir String nesnesi döndü "JACK" ama bu sonucu referans değişkeninde saklamadığımız için bu nesne çöp oldu.


        System.err.println("------------------");
        //String sınıfı içindeki toUpperCase, toLowerCase gibi metotlar dil bilgisini kullanırlar.
        String text="ışiğöçü";
        System.err.println(text);
        System.err.println(text.toUpperCase(Locale.US));
        System.err.println(text.toUpperCase(new Locale("tr", "TR")));

    }
}
