import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UyeManager extends Veritabani {
    static Scanner scan = new Scanner(System.in);

    public static void uyeMenu() throws InterruptedException {
        String tercih = "";

        { //TODO Kullanıcı Çıkış Yapmadığı Sürece, Menüyü Görmeye Devam Etsin...



            //TODO Kullanıcıdan alacağınız tercihe göre ilgili menü metodlarına yönlendirmeler yapın...
            {

            }
                do {System.out.println(
                        "\n========== TECHNO STUDY CONFLUENCE =========\n" +
                                "================= UYE MENU =================\n" +
                                "\n" +
                                "\t   1- Uye Listesi Yazdir\t\n" +
                                "\t   2- Soyisimden Uye Bulma\n" +
                                "\t   3- Sehire Gore Uye Bulma\n" +
                                "\t   4- Bilgilerini Girerek Uye Ekleme\n" +
                                "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                                "\t   A- ANAMENU\n" +
                                "\t   Q- CIKIS\n");
                    System.out.print("tercih:");
                    tercih=scan.nextLine();

                    switch (tercih){
                        // Uye Listesi Yazdir

                        case "1":   uyeListesiYazdir();break;
                // Soyisimden Uye Bulma
                        case "2":   soyisimdenUyeBulma();break;
                // Sehre Gore Uye Bulma
                        case "3":   sehreGoreUyeBulma();break;
                // Bilgilerini Girerek Uye Ekleme
                        case "4":   uyeEkleme();break;
                // Kimlik No Ile Kayit Silme
                        case "5":   tcNoIleUyeSil();break;
                        case "A":   Helper.anaMenu();break;
                        case "Q":   Helper.projeDurdur();break;
                        default:    System.out.println("Lutfen gecerli tercih yapiniz: ");
            }

        }while (!tercih.equals("Q"));
        }
    }

    public static void tcNoIleUyeSil() throws InterruptedException {

        //TODO Kullanıcıdan alacağınız kimlik no ile ilgili üyeyi kayıtlardan siliniz...

        System.out.print("Silinecek uyeye ait kimlik no giriniz: ");
        String tckn=scan.nextLine();


        //TODO Gerekli atamaları yapınız. Aşağıdaki try-catch bloğu yardımcı olabilir...

        System.out.print(uyelerMap.get(tckn) + " Siliniyor...");
        uyelerMap.remove(tckn);
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        //try {
        //    boolean sonuc = sonucValue.equals(silinecekValue);
        //} catch (Exception e) {
        //    System.out.println("Istediginiz Tc numarasi ile uye bulunamadi.");
        //}
    }

    public static void uyeEkleme() {
        System.out.print("üye tckn giriniz:");
        String üyetckn= scan.nextLine();
        System.out.print("üyenin adını,soyadını,şehrini,doğum tarihini sırasıyla aralarına virgül koyarak giriniz");
        String yeniüyevalue= scan.nextLine();
        uyelerMap.put(üyetckn,yeniüyevalue);
        for (Map.Entry<String, String> each : uyelerMap.entrySet()) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            System.out.println(eachKey + " : " + eachValue + " | ");}

        //TODO Kullanıcıdan Tc no , Isim, Soyisim, Sehir, Dogum Yili alınız...
        //TODO Aldığınız değeri UyelerMap mapine uygun şekilde ekleyiniz...

    }

    public static void sehreGoreUyeBulma() throws InterruptedException {

        //TODO Kullanıcıdan aldığınız girdiyle, UyelerMap'inde şehir araması yapın;
        //TODO Girilen şehire sahip tüm üyeleri map veya liste olarak döndürünüz...
        System.out.print("Aradiginiz Uyenin Sehrini Giriniz:");
        String şehir=scan.nextLine();

        System.out.println(
                "\n============= TECHNO STUDY CONFLUENCE =============\n" +
                        "=============== SEHIR ILE UYE ARAMA ===============\n" +
                        "TcNo : Isim , Soyisim , Sehir, D.Yili");
        for (Map.Entry<String, String> each : uyelerMap.entrySet()) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            if (eachValue.contains(şehir)){

                System.out.println(eachKey + " : " + eachValue + " | ");}}
        // Daha düzgün bi görünüm için printf veya String.format kullanılabilir... Zorunlu değil...

    }

    public static void soyisimdenUyeBulma() throws InterruptedException {
        //TODO Kullanıcıdan aldığınız girdiyle, UyelerMap'inde soyisim araması yapın;
        //TODO Girilen soyismine sahip tüm üyeleri map veya liste olarak döndürünüz...
        System.out.print("Aradiginiz uyenin soyisminin tamamini ya da bir kismini giriniz: ");
        String soyisim=scan.nextLine();

        Set<Map.Entry<String, String>> uyelerEntrySet = uyelerMap.entrySet();

        System.out.println(
                "\n========== TECHNO STUDY BOOTCAMP ===========\n" +
                        "=========== SOYISIM ILE UYE ARAMA ==========\n" +
                        "TcNo : Isim , Soyisim , Sehir , D.Yili");
        for (Map.Entry<String, String> each : uyelerEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            if (eachValue.contains(soyisim)){

                System.out.println(eachKey + " : " + eachValue + " | ");}}
        // printf veya String.format metodları kullanılarak daha düzgün bi çıktı elde edilebilir. Şart değil, isteğe bağlı.

        //TODO Syisminin bir kısmı girilse bile bulunan üyeler listelensin...
    }

    public static void uyeListesiYazdir() throws InterruptedException {
        //İPUCU METODU: Bu metodu değiştirmenize gerek yok...

        Set<Map.Entry<String, String>> uyelerEntrySet = uyelerMap.entrySet();

        System.out.print("Uye Listesi yazdiriliyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        System.out.println(
                "\n========== TECHNO STUDY CONFLUENCE =========\n" +
                        "=============== UYE LISTESI ================\n" +
                        "TcNo : Isim , Soyisim , Sehir , D.Yili");

        // Daha düzgün bi görünüm için printf veya String.format kullanılabilir...
        for (Map.Entry<String, String> each : uyelerEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            System.out.println(eachKey + " : " + eachValue + " | ");
        }
    }
}
