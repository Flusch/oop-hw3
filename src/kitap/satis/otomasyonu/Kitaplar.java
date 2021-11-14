package kitap.satis.otomasyonu;
import java.io.*;
import java.util.Scanner;

interface IKitaplar{
    void kitapMenu();
    void kitapListesi();
    void kitapSecme();
    void kitapEkle();
}

public abstract class Kitaplar implements IKitaplar {
    
    Kitaplar(){
        try{
        FileOutputStream kitap = new FileOutputStream("kitaplar.txt",true);
        }
        catch(IOException e){
            System.out.println("Bir hata olustu! Menuye yonlendiriliyorsunuz...");
            KitapSatisOtomasyonu.anaMenu();
        }
    }
    
    @Override
    public void kitapMenu(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("--------------------*--------------------");
        System.out.println("Yapmak istediginiz islemi secin");
        System.out.println("1.Kitap Listesi");
        System.out.println("2.Id Ile Sepete Kitap Ekle");
        System.out.println("3.Ana Menu");
        System.out.println("--------------------*--------------------");
        
        try{
            int secim = input.nextInt();
        
            switch(secim){
                case 1:
                    kitapListesi();
                    break;
                case 2:
                    kitapSecme();
                    break;
                case 3:
                    KitapSatisOtomasyonu.anaMenu();
                    break;
                default:
                    System.out.println("Hatali Giris");
                    kitapMenu();
            }
        }
        catch(Exception e){
            System.out.println("Hatali Giris");
        }
    }
    
    @Override
    public void kitapListesi(){
        
        try{
            FileInputStream f = new FileInputStream("kitaplar.txt");
            BufferedReader buf = new BufferedReader(new InputStreamReader(f));
            String satir;
            
            System.out.println("----------*KITAPLAR BASLANGIC*----------");
            
            while ((satir = buf.readLine())!=null){
                System.out.print(satir+" - ");
                satir = buf.readLine();
                System.out.print(satir+" - ");
                satir = buf.readLine();
                System.out.println(satir);
            }
            
            System.out.println("------------*KITAPLAR BITIS*------------");
            kitapMenu();
        }
        catch(IOException ioex){
            System.out.println("Bir hata olustu! Menuye yonlendiriliyorsunuz...");
            KitapSatisOtomasyonu.anaMenu();
        }

    }
       
    @Override
    public void kitapSecme(){
        Scanner input = new Scanner(System.in);
        Sepet sepet = new Sepet();
        
        System.out.print("Sepetinize eklemek istediginiz kitabin id'sini yazin:");
        String id = input.nextLine();
        sepet.sepeteEkle(id);
        
        System.out.println("Menuye yonlendiriliyorsunuz...");
        kitapMenu();
    }
    
    @Override
    public void kitapEkle(){
        Scanner input = new Scanner(System.in);
        YoneticiUyelik yonetici = new YoneticiUyelik();
        
        System.out.print("Kitap icin id girin:");
        String id = input.nextLine();
        System.out.print("Kitabin adini girin:");
        String kitapAdi = input.nextLine();
        System.out.print("Kitabin yazarini girin:");
        String kitapYazari = input.nextLine();
        
        try{
            FileOutputStream f = new FileOutputStream("kitaplar.txt",true) ;
            PrintStream yaz = new PrintStream(f);
            
            FileInputStream fk = new FileInputStream("kitaplar.txt");
            BufferedReader buf = new BufferedReader(new InputStreamReader(fk));
            String satir;
            
            try{
                while ((satir = buf.readLine())!=null){
                    if(satir.equals(id) || satir.equals(kitapAdi)){
                        throw new InterruptedException();
                        //Rastgele bir hata fırlatıp eger kitap veya id mevcutsa alttaki koda ulasilmadan catch e duser.
                    }
                }
            
                yaz.println(id);
                yaz.println(kitapAdi);
                yaz.println(kitapYazari);
                System.out.println("Kitap basariyla eklendi! Menuye yonlendiriliyorsunuz...");
                yonetici.uyeMenuYonetici();
            }
            catch(InterruptedException ex){
                System.out.println("Girdiginiz id veya kitap sistemde mevcut! Menuye yonlendiriliyorsunuz...");
                yonetici.uyeMenuYonetici();
            }
        }
        catch(IOException e){
            System.out.println("Bir hata olustu! Menuye yonlendiriliyorsunuz...");
            KitapSatisOtomasyonu.anaMenu();
        }
    }
}