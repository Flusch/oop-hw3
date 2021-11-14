package kitap.satis.otomasyonu;
import java.util.Scanner;

public class YoneticiUyelik extends Uyelikler {
    
    public void uyeMenuYonetici(){
        Scanner input = new Scanner(System.in);
        KitapIslemleri kitap = new KitapIslemleri();
        
        System.out.println("--------------------*--------------------");
        System.out.println("Yapmak istediginiz islemi secin");
        System.out.println("1.Kitap Ekle");
        System.out.println("2.Cikis Yap");
        System.out.println("3.Ana Menu");
        System.out.println("--------------------*--------------------");
        
        try{
            int secim = input.nextInt();

            switch(secim){
                case 1:
                    kitap.kitapIslemleriEkle();
                    break;
                case 2:
                    super.uyeCikis();
                    break;
                case 3:
                    KitapSatisOtomasyonu.anaMenu();
                    break;
                default:
                    System.out.println("Hatali Giris");
                    uyeMenuYonetici();
            }
        }
        catch(Exception e){
            System.out.println("Hatali Giris");
        }
    }
}