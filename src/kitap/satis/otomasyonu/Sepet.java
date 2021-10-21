//
//Yavuz Selim GÜLER
//1306160016
//

package kitap.satis.otomasyonu;
import java.io.*;
import java.util.Scanner;

interface ISepet{
    void sepetMenu();
    void sepeteEkle(String id);
    void sepetiGoruntule();
    void sepetiGoruntuleMenusuz();
}

public class Sepet implements ISepet {
    
    Sepet(){
        try{
            FileOutputStream sepet = new FileOutputStream("sepet.txt",true);
        }
        catch(IOException e){
            System.out.println("Bir hata olustu! Menuye yonlendiriliyorsunuz...");
            KitapSatisOtomasyonu.anaMenu();
        }
    }
    
    @Override
    public void sepetMenu(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("--------------------*--------------------");
        System.out.println("Yapmak istediginiz islemi secin");
        System.out.println("1.Sepeti Goruntule");
        System.out.println("2.Sepeti Sil");
        System.out.println("3.Ana Menu");
        System.out.println("--------------------*--------------------");
        
        try{
            int secim = input.nextInt();

            switch(secim){
                case 1:
                    sepetiGoruntule();
                    break;
                case 2:
                    System.out.println("Sepeti silmek istediginize emin misiniz? Onaylıyorsanız 1'e, onaylamıyorsanız ana menuye donmek icin başka herhangi bir tusa basin...");
                    
                    try{
                        int onay = input.nextInt();
                
                        if(onay == 1){
                            try{
                                FileOutputStream sepet = new FileOutputStream("sepet.txt",false);
                                System.out.println("Sepet silindi! Menuye yonlendiriliyorsunuz...");
                                KitapSatisOtomasyonu.anaMenu();
                            }
                            catch(IOException e){
                                System.out.println("Bir hata olustu! Menuye yonlendiriliyorsunuz...");
                                KitapSatisOtomasyonu.anaMenu();
                            }
                        }
                        else{
                            KitapSatisOtomasyonu.anaMenu();
                        }
                    }
                    catch(Exception e){
                        KitapSatisOtomasyonu.anaMenu();
                    }
                    break;
                case 3:
                    KitapSatisOtomasyonu.anaMenu();
                    break;
                default:
                    System.out.println("Hatali Giris");
                    sepetMenu();
            }
        }
        catch(Exception e){
            System.out.println("Hatali Giris");
        }
    }
    
    @Override
    public void sepeteEkle(String id){
        KitapIslemleri kitap = new KitapIslemleri();
        
        int counter1 = 0;
        int counter2 = 0;
        
        try{
            FileInputStream fS1 = new FileInputStream("sepet.txt");
            BufferedReader buf1 = new BufferedReader(new InputStreamReader(fS1));
            String satir1;
            
            while ((satir1 = buf1.readLine())!=null){
                counter1++;
            }
        }
        catch(IOException e){}
        
        try{
            FileOutputStream f = new FileOutputStream("sepet.txt",true) ;
            PrintStream yaz = new PrintStream(f);
            
            FileInputStream fK = new FileInputStream("kitaplar.txt");
            BufferedReader buf = new BufferedReader(new InputStreamReader(fK));
            String satir;

            while ((satir = buf.readLine())!=null){
                if(satir.equals(id)){
                    yaz.println(id);
                    System.out.print(id+" Id'li kitap sepete basariyla eklendi! ");
                    break;
                }
            }  
        }
        catch(IOException e){
            System.out.println("Bir hata olustu! Menuye yonlendiriliyorsunuz...");
            KitapSatisOtomasyonu.anaMenu();
        }
        
        try{
            FileInputStream fS2 = new FileInputStream("sepet.txt");
            BufferedReader buf2 = new BufferedReader(new InputStreamReader(fS2));
            String satir2;
            
            while ((satir2 = buf2.readLine())!=null){
                counter2++;
            }
        }
        catch(IOException e){}
        
        if(counter1 == counter2){
            System.out.println("Boyle bir kitap yok! Menuye yonlendiriliyorsunuz...");
            kitap.kitapIslemleriMenu();
        }
    }
    
    @Override
    public void sepetiGoruntule(){
        try{
            FileInputStream f = new FileInputStream("sepet.txt");
            BufferedReader buf = new BufferedReader(new InputStreamReader(f));
            String id;
            
            System.out.println("----------*Sepet Basi*----------");
            
            while ((id=buf.readLine())!=null){
                System.out.print(id+" - ");
                
                try{
                    FileInputStream fKitap = new FileInputStream("kitaplar.txt");
                    BufferedReader bufKitap = new BufferedReader(new InputStreamReader(fKitap));
                    String ktp;
                    
                    while ((ktp = bufKitap.readLine())!=null){
                        if(ktp.equals(id)){
                            ktp = bufKitap.readLine();
                            System.out.print(ktp+" - ");
                            ktp = bufKitap.readLine();
                            System.out.println(ktp);
                            break;
                        }
                    }
                }
                catch(IOException e){
                    System.out.println("Bir hata olustu! Menuye yonlendiriliyorsunuz...");
                    KitapSatisOtomasyonu.anaMenu();
                }
            }
            
            System.out.println("----------*Sepet Sonu*----------");
            
        }
        catch(IOException e){
            System.out.println("Bir hata olustu! Menuye yonlendiriliyorsunuz...");
            KitapSatisOtomasyonu.anaMenu();
        }
        sepetMenu();
    }
    
    @Override
    public void sepetiGoruntuleMenusuz(){
        try{
            FileInputStream f = new FileInputStream("sepet.txt");
            BufferedReader buf = new BufferedReader(new InputStreamReader(f));
            String id;
            
            System.out.println("----------*Sepet Basi*----------");
            
            while ((id=buf.readLine())!=null){
                System.out.print(id+" - ");
                
                try{
                    FileInputStream fKitap = new FileInputStream("kitaplar.txt");
                    BufferedReader bufKitap = new BufferedReader(new InputStreamReader(fKitap));
                    String ktp;
                    
                    while ((ktp = bufKitap.readLine())!=null){
                        if(ktp.equals(id)){
                            ktp = bufKitap.readLine();
                            System.out.print(ktp+" - ");
                            ktp = bufKitap.readLine();
                            System.out.println(ktp);
                            break;
                        }
                    }
                }
                catch(IOException e){
                    System.out.println("Bir hata olustu! Menuye yonlendiriliyorsunuz...");
                    KitapSatisOtomasyonu.anaMenu();
                }
            }
            System.out.println("----------*Sepet Sonu*----------");
        }
        catch(IOException e){
            System.out.println("Bir hata olustu! Menuye yonlendiriliyorsunuz...");
            KitapSatisOtomasyonu.anaMenu();
        }
    } 
}