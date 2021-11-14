package kitap.satis.otomasyonu;
import java.io.*;
import java.util.Scanner;

interface IUyelikler{
    void uyeMenuDefault();
    void uyeMenu();
    void uyeGiris();
    void uyeKayit();
    void sifremiUnuttum();
    void uyeCikis();
}

public class Uyelikler implements IUyelikler {
    
    static String simdikiUye;
    
    Uyelikler(){
        try{
        FileOutputStream uye = new FileOutputStream("uyelikler.txt",true);
        }
        catch(IOException e){
            System.out.println("Bir hata olustu! Menuye yonlendiriliyorsunuz...");
            KitapSatisOtomasyonu.anaMenu();
        }
    }
    
    @Override
    public void uyeMenuDefault(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("--------------------*--------------------");
        System.out.println("Yapmak istediginiz islemi secin");
        System.out.println("1.Uye Girisi");
        System.out.println("2.Kayit Ol");
        System.out.println("3.Sifremi Unuttum");
        System.out.println("4.Ana Menu");
        System.out.println("--------------------*--------------------");
        
        try{
            int secim = input.nextInt();
        
            switch(secim){
                case 1:
                    uyeGiris();
                    break;
                case 2:
                    uyeKayit();
                    break;
                case 3:
                    sifremiUnuttum();
                    break;
                case 4:
                    KitapSatisOtomasyonu.anaMenu();
                    break;
                default:
                System.out.println("Hatali Giris");
                uyeMenuDefault();
            }
        }
        catch(Exception e){
            System.out.println("Hatali Giris");
        }
    }
    
    @Override
    public void uyeMenu(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("--------------------*--------------------");
        System.out.println("Yapmak istediginiz islemi secin");
        System.out.println("1.Cikis Yap");
        System.out.println("2.Ana Menu");
        System.out.println("--------------------*--------------------");
        
        try{
            int secim = input.nextInt();
        
            switch(secim){
                case 1:
                    uyeCikis();
                    break;
                case 2:
                    KitapSatisOtomasyonu.anaMenu();
                    break;
                default:
                    System.out.println("Hatali Giris");
                    uyeMenu();
            }
        }
        catch(Exception e){
            System.out.println("Hatali Giris");
        }
    }
    
    @Override
    public void uyeGiris(){
        Scanner input = new Scanner(System.in);
        YoneticiUyelik yonetici = new YoneticiUyelik();
        
        System.out.print("Kullanici Adi:");
        String kullaniciAdi = input.nextLine();
        System.out.print("Sifre:");
        String sifre = input.nextLine();
        
        try{
            FileInputStream f = new FileInputStream("uyelikler.txt");
            BufferedReader buf = new BufferedReader(new InputStreamReader(f));
            String satir;
            
            while ((satir = buf.readLine())!= null){
                if(satir.equals(kullaniciAdi)){
                    satir = buf.readLine();
                    if(satir.equals(sifre)){
                        simdikiUye = kullaniciAdi;
                        System.out.println("Simdiki Uye:"+simdikiUye);
                        System.out.println("Giris Basarili! Menuye yonlendiriliyorsunuz...");
                        break;
                    }
                    else{
                        System.out.println("Hatali Kullanici Adi / Sifre! Menuye yonlendiriliyorsunuz...");
                        uyeMenuDefault();
                        break;
                    }
                }
            }
            
            if("admin".equals(simdikiUye)){
                yonetici.uyeMenuYonetici();
            }
            else{
                uyeMenu();
            }
        }
        catch(IOException e){
            System.out.println("Bir hata olustu! Menuye yonlendiriliyorsunuz...");
            KitapSatisOtomasyonu.anaMenu();
        }
    }
    
    @Override
    public void uyeKayit(){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Kullanici Adi:");
        String kullaniciAdi = input.nextLine();
        System.out.print("Sifre:");
        String sifre = input.nextLine();
        System.out.print("E-posta:");
        String ePosta = input.nextLine();
        System.out.print("Ad Soyad:");
        String adSoyad = input.nextLine();
     
        try{
            FileOutputStream f = new FileOutputStream("uyelikler.txt",true) ;
            PrintStream yaz = new PrintStream(f);
            
            if("".equals(kullaniciAdi) || "".equals(sifre) || "".equals(ePosta) || "".equals(adSoyad)){
                System.out.println("Hatali Giris Yaptiniz! Menuye yonlendiriliyorsunuz...");
                uyeMenuDefault();
            }
            else{
            yaz.println(kullaniciAdi);
            yaz.println(sifre);
            yaz.println(ePosta);
            yaz.println(adSoyad);
            System.out.println("Uyelik basariyla olusturuldu! Menuye yonlendiriliyorsunuz...");
            uyeMenuDefault();
            }
        }
        catch(IOException e){
            System.out.println("Bir hata olustu! Menuye yonlendiriliyorsunuz...");
            KitapSatisOtomasyonu.anaMenu();
        }
    }
    
    @Override
    public void sifremiUnuttum(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Kullanici adi ve e-postanızı girdikten sonra eslesme olur ise sifrenizi e-posta adresinize gönderecegiz.");
        System.out.print("Kullanici Adi:");
        String a = input.nextLine();
        System.out.print("E-Posta:");
        String b = input.nextLine();
        
        try{
            FileInputStream f = new FileInputStream("uyelikler.txt");
            BufferedReader buf = new BufferedReader(new InputStreamReader(f));
            String satir;
            while ((satir = buf.readLine())!= null){
                if(satir.equals(a)){
                    satir = buf.readLine();
                    satir = buf.readLine();
                    if(satir.equals(b)){
                        System.out.println("Islem Basarili! Menuye yonlendiriliyorsunuz...");
                        break;
                    }
                    else{
                        System.out.println("Boyle bir uye yok! Menuye yonlendiriliyorsunuz...");
                        break;
                    }
                }
            }
            uyeMenuDefault();
        }
        catch(IOException e){
            System.out.println("Bir hata olustu! Menuye yonlendiriliyorsunuz...");
            KitapSatisOtomasyonu.anaMenu();
        }
    }
    
    @Override
    public void uyeCikis(){
        System.out.println("Cikis yapiliyor! Menuye yonlendiriliyorsunuz...");
        simdikiUye = null;
        uyeMenuDefault();
    }
}