package kitap.satis.otomasyonu;
import java.util.Scanner;

public class KitapSatisOtomasyonu {
    
    public static void anaMenu(){
        Scanner input = new Scanner(System.in);
        Uyelikler uye = new Uyelikler();
        KitapIslemleri kitap = new KitapIslemleri();
        Sepet sepet = new Sepet();
        Siparis siparis = new Siparis();
        YoneticiUyelik yonetici = new YoneticiUyelik();
        
        System.out.println("--------------------*--------------------");
        System.out.println("Yapmak istediginiz islemi secin");
        System.out.println("1.Uye Islemleri");
        System.out.println("2.Kitap Islemleri");
        System.out.println("3.Sepet");
        System.out.println("4.Siparis Olustur");
        System.out.println("5.Cikis");
        System.out.println("--------------------*--------------------");
        
        try{
            int secim = input.nextInt();
        
            switch(secim){
                case 1:
                    if(Uyelikler.simdikiUye == null){
                        uye.uyeMenuDefault();
                    }
                    else if(Uyelikler.simdikiUye.equals("admin")){
                        yonetici.uyeMenuYonetici();
                    }
                    else{
                        uye.uyeMenu();
                    }
                    break;
                case 2:
                    kitap.kitapIslemleriMenu();
                    break;
                case 3:
                    sepet.sepetMenu();
                    break;
                case 4:
                    siparis.siparisMenu();
                    break;
                case 5:
                    System.out.println("Cikiliyor...");
                    break;
                default:
                    System.out.println("Hatali Giris");
                    anaMenu();
            }
        }
        catch(Exception e){
            System.out.println("Hatali Giris");
        }
    }
    
    public static void main(String[] args) {
        anaMenu();
    }
}