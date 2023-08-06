import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class KitapManager extends Veritabani {

    static Scanner scan = new Scanner(System.in);

    public static void kitapMenu() throws InterruptedException {
        String tercih = "";
        // TODO Kullanıcı Çıkış Yapmadığı sürece menüde kalalım...
        //TODO Kullanıcıdan alacağınız tercihe göre ilgili menü metodlarına yönlendirmeler yapın...

            do {System.out.println(
                    "\n============ TECHNO STUDY BOOTCAMP ============\n" +
                            "================== KITAP MENU =================\n" +
                            "\t   1- Kitap Listesi Yazdir\n" +
                            "\t   2- Yazardan Kitap Bulma\n" +
                            "\t   3- Kitap Turu veya Yayin Tarihi Ile Kitap Bulma\n" +
                            "\t   4- Bilgilerini Girerek Kitap Ekleme\n" +
                            "\t   5- Kitap Ismi Ile Kayit Silme \t\n" +
                            "\t   6- Kitap Odunc Al \t\n" +
                            "\t   7- Kitap Iade Et \t\n" +
                            "\t   A- ANAMENU\n" +
                            "\t   Q- CIKIS");
                System.out.print("tercih:");
                tercih=scan.nextLine();
                switch (tercih){
                    case "1":   kitapListesiYazdir();break;
                // Yazar Ismiyle Kitap Bulma
                    case "2":   yazardanKitapBulma();break;
                // Kitap Turu veya Yayin Tarihi Ile Kitap Bulma
                    case "3":   turVeyaYayinTarihiIleKitapBulma();break;
                // Bilgilerini Girerek Kitap Ekleme
                    case "4":   kitapEkle();break;
                    case "5":   isimIleKitapSilme();break;
                    case "6":   kitapOduncAl();break;
                    case "7":   kitapIadeEt();break;
                    case "A":   Helper.anaMenu();break;
                    case "Q":   Helper.projeDurdur();break;
                    default :   System.out.println("Lutfen gecerli bir tercih giriniz");
                        System.out.println("tercih giriniz");
                        tercih= scan.nextLine();
            }
        }while (!tercih.equals("Q"));

    }

    public static void kitapOduncAl(){
        System.out.println("Odunc almak istediginiz kitabin ismini giriniz: ");
        String ödünçkitap=scan.nextLine();
        String eklenecekkitap=kitaplarMap.get(ödünçkitap);
        ödünçkitaplarMap.put(ödünçkitap,eklenecekkitap);
        kitaplarMap.remove(ödünçkitap);
        System.out.println("kitap ödünç alındı= " +ödünçkitap+ eklenecekkitap);
        System.out.println(ödünçkitaplarMap);
        System.out.println(kitaplarMap);






        //TODO Kullanıcıdan alacağınız kitap ismiyle (Map te var olmalı)
        //TODO kitap ödünç alma metodunu tamamlayın...
        //NOT: Veritabanı'nda ödünç almayla alakalı ikinci bir map 'i tampon gibi kullanmalısınız...
        //Ödünç alındığında kitaplarMap 'ten düşüp bu map e eklenecek...
    }


    public static void kitapIadeEt() {
        System.out.println("Iade etmek istediginiz kitabin ismini giriniz: ");
        String ödünçkitap=scan.nextLine();
        String eklenecekkitap=ödünçkitaplarMap.get(ödünçkitap);
        kitaplarMap.put(ödünçkitap,eklenecekkitap);
        if (ödünçkitaplarMap.containsKey(ödünçkitap)){
            ödünçkitaplarMap.remove(ödünçkitap);
        System.out.println("kitap iade edildi= " +ödünçkitap+ eklenecekkitap);
            for (Map.Entry<String, String> each : kitaplarMap.entrySet()) {
                String eachKey = each.getKey();
                String eachValue = each.getValue();

                System.out.println(eachKey + " : " + eachValue + " | ");

                for (Map.Entry<String, String> eac : ödünçkitaplarMap.entrySet()) {
                    String eacKey = each.getKey();
                    String eacValue = each.getValue();

                    System.out.println(eachKey + " : " + eachValue + " | ");}}}
        else System.out.println("ödünçkitap = " + ödünçkitap);



        //TODO Kullanıcıdan alacağınız kitap ismiyle (Map te var olmalı)
        //TODO kitap iade etme metodunu tamamlayın...
        //NOT: Veritabanı'nda iade etmeyle alakalı ikinci bir map 'i tampon gibi kullanmalısınız...
        //Kitap iade edildiğinde,  kitaplarMap 'e geri eklenmeli...
    }


    private static void isimIleKitapSilme() throws InterruptedException
    {//İPUCU METODU... Bu metodu değiştirmenize gerek yok.
        System.out.println("Silinecek kitabin ismini giriniz");
        String silinecekKitap = scan.nextLine();

        String silinecekValue = kitaplarMap.get(silinecekKitap);
        String sonucValue = kitaplarMap.remove(silinecekKitap);

        System.out.print(silinecekKitap + " Siliniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        //ARTIK UYGUN YERLERDE BEKLEMEDİĞİNİZ SONUÇLAR İÇİN TRY CATCH KULLANABİLİRSİNİZ...
        //////////////////////////////////////////////////////////////////////////////////////////////////
        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            System.out.println("Istediginiz kitap ismi bulunamadi");
        }/////////////////////////////////////////////////////////////////////////////////////////////////
    }

    private static void kitapEkle() {
        //"A Tale of Two Cities", "Charles Dickens, Tarih, 1859" >> Kitap key,value su buna benzer şekilde...
        System.out.print("kitap adı giriniz");
        String yenikitapkey= scan.nextLine();
        System.out.print("kitabın yazarını,türünü,yazım tarhini sırasıyla aralarına virgül koyarak giriniz");
        String yenikitapvalue= scan.nextLine();
        kitaplarMap.put(yenikitapkey,yenikitapvalue);
        for (Map.Entry<String, String> each : kitaplarMap.entrySet()) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            System.out.println(eachKey + " : " + eachValue + " | ");}


        //TODO Kitap Adını, Yazar Adını, Kitap Türünü ve Yayınlanma Yılını Kullanıcıdan alarak,
        //TODO kitaplarMap'e ekleme yapınız...

        //TODO MÜMKÜNSE, kitap türünü, Enum olarak tanımlanan KitapTuru sınıfını kullanarak alınız...
        //KİTAP TÜRLERİ >>     TARIH, POLISIYE, KURGU, ROMAN, DESTAN, TANIMLANMAMIS_TUR
        //TODO Kullanıcı kitap türünü yanlış girdiği sürece , kullanıcıya
        //TODO "Hatali giris! Lutfen kitap turunu tekrar giriniz: " mesajı verin...
        //TODO while ve try-catch kullanılabilir... Giriş başarılı olursa try-catch bloğu kırılarak konsoldan
        //TODO yayınlama yılı alıp kitap ekleme işlemine devam edilebilir...
        //Kullanıcı tarafından girilen stringi, KitapTuru sınıfında tanımlanan türlerden birine çevirmeniz gerkecek...
        // kitapTuru değişkeni artık geçerli bir değere sahipse...
        // Diğer işlemlere devam edebilirsiniz.
        //System.out.println("Yayinlanma Tarihi: ");
        //String yayinTarihi = scan.nextLine();

        //TODO Ekleme işlemini tamamlayın...


    }

    public static void turVeyaYayinTarihiIleKitapBulma() throws InterruptedException {

        //TODO kitaplar.Map'in Value larını almak için  Set<Map.Entry<String, String>> cinsinden myEntrySet tanımlayın...
        System.out.println("Bulmak istediğiniz kitabın türünü veya yayın tarihini giriniz:");
        String türveyayayın= scan.nextLine();





        //TODO Metodu kullanıcıdan alacağınız girdileri kullanarak tamamlayın...

        System.out.println(
                "\n============ TECHNO STUDY CONFLUENCE ==========\n" +
                        "================= KITAP LISTESI ===============\n" +
                        "Kitap Ismi    :   Yazar Ismi , Kitap Turu , Yayin Yili");
        for (Map.Entry<String, String> each : kitaplarMap.entrySet()) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            if (eachValue.contains(türveyayayın)){

            System.out.println(eachKey + " : " + eachValue + " | ");}}


    }


    public static void yazardanKitapBulma() throws InterruptedException {

        //TODO kitaplar.Map'in Value larını almak için  Set<Map.Entry<String, String>> cinsinden myEntrySet tanımlayın...

        //TODO Metodu kullanıcıdan alacağınız girdileri kullanarak tamamlayın...
        System.out.println("Istediginiz yazar ismini yaziniz: ");
        String yazar=scan.nextLine();


        System.out.println(
                "\n============ TECHNO STUDY CONFLUENCE ==========\n" +
                        "================= KITAP LISTESI ===============\n" +
                        "Kitap Ismi    :   Yazar Ismi , Kitap Turu , Yayin Yili");
        for (Map.Entry<String, String> each : kitaplarMap.entrySet()) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            if (eachValue.contains(yazar)){

                System.out.println(eachKey + " : " + eachValue + " | ");}}

        // printf veya String.format metodları kullanılarak daha düzgün bi çıktı elde edilebilir.
        // Şart değil, isteğe bağlı.

    }

    public static void kitapListesiYazdir() throws InterruptedException { //Üye Listesi Yazdır Metodundan Faydalanabilirsiniz...

        //TODO kitaplar.Map'in Value larını almak için  Set<Map.Entry<String, String>> cinsinden myEntrySet tanımlayın...

        System.out.println(
                "\n============ TECHNO STUDY CONFLUENCE ==========\n" +
                        "================= KITAP LISTESI ===============\n" +
                        "Kitap Ismi    :   Yazar Ismi , Kitap Turu , Yayin Yili");
        for (Map.Entry<String, String> each : kitaplarMap.entrySet()) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            System.out.println(eachKey + " : " + eachValue + " | ");
        }



        //TODO Kitapları listeleyecek metodu oluşturun...
        //Üye Listesi Yazdır Metodundan Faydalanabilirsiniz...
    }
}
