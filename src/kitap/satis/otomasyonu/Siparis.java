//
//Yavuz Selim GÜLER
//1306160016
//

package kitap.satis.otomasyonu;
import java.io.*;
import java.util.Scanner;

interface ISiparis{
    void siparisMenu();
    void siparisOnay();
}

public class Siparis implements ISiparis {
    
    Siparis(){
        try{
            FileOutputStream siparis = new FileOutputStream("siparisler.txt",true);
        }
        catch(IOException e){
            System.out.println("Bir hata olustu! Menuye yonlendiriliyorsunuz...");
            KitapSatisOtomasyonu.anaMenu();
        }
    }
    
    @Override
    public void siparisMenu(){
        Scanner input = new Scanner(System.in);
        Sepet sepet = new Sepet();
        
        System.out.println("--------------------*--------------------");
        System.out.println("Yapmak istediginiz islemi secin");
        System.out.println("1.Sepeti Goruntule");
        System.out.println("2.Siparisi Tamamla");
        System.out.println("3.Ana Menu");
        System.out.println("--------------------*--------------------");
        
        try{
            int secim = input.nextInt();
        
            switch(secim){
                case 1:
                    sepet.sepetiGoruntule();
                    break;
                case 2:
                    siparisOnay();
                    break;
                case 3:
                    KitapSatisOtomasyonu.anaMenu();
                    break;
                default:
                    System.out.println("Hatali Giris");
                    siparisMenu();
            }
        }
        catch(Exception e){
            System.out.println("Hatali Giris");
        }
    }
    
    @Override
    public void siparisOnay(){
        Scanner input = new Scanner(System.in);
        Sepet sepet = new Sepet();
        Uyelikler uye = new Uyelikler();
        
        if(Uyelikler.simdikiUye == null){
            System.out.println("Siparis olusturmak icin oncelikle uye girisi yapmaniz gerekmektedir. Uye menusunue yonlendiriliyorsunuz...");
            uye.uyeMenuDefault();
        }
        else{
            System.out.println("Asagidaki Urunleri Satin alacaksiniz:");
            sepet.sepetiGoruntuleMenusuz();
            System.out.println("Urunleri onayliyor musunuz? Onayliyorsaniz 1'e, onaylamiyorsaniz ana menuye donmek icin baska herhangi bir tusa basin...");
            
            try{
                int onay1 = input.nextInt();
                
                //olusan atlama hatasini gidermek için
                input.nextLine();
                //olusan atlama hatasini gidermek için

                if(onay1 == 1){
                    System.out.print("Kargoyu teslim alacak kisinin adini girin:");
                    String kisiAdi = input.nextLine();
                    System.out.print("Basinda sifir olmadan telefon numarası girin:");
                    long telNo = input.nextLong();
                    
                    //olusan atlama hatasini gidermek için
                    input.nextLine();
                    //olusan atlama hatasini gidermek için
                    
                    System.out.print("Kargonun gönderilecegi adresi girin:");
                    String adres = input.nextLine();

                    System.out.println("Kargoyu teslim alacak kisinin adi:"+kisiAdi);
                    System.out.println("Basinda sifir olmadan telefon numarası:"+telNo);
                    System.out.println("Kargonun gonderilecegi adres:"+adres);
                    System.out.println("Bilgileri onayliyor musunuz? Onayliyorsaniz 1'e, onaylamiyorsaniz ana menuye donmek icin baska herhangi bir tusa basin...");
                    
                    try{
                        int onay2 = input.nextInt();
                        
                        //olusan atlama hatasini gidermek için
                        input.nextLine();
                        //olusan atlama hatasini gidermek için

                        if(onay2 == 1){
                            System.out.println("Kredi karti bilgilerinizi girin...");
                            System.out.print("16 haneli kredi karti numarasini girin:");
                            long kkNo = input.nextLong();
                            
                            //olusan atlama hatasini gidermek için
                            input.nextLine();
                            //olusan atlama hatasini gidermek için
                            
                            System.out.print("Kredi kartinizin son kullanim tarihini AA/YY formatinda girin:");
                            String skt = input.nextLine();
                            
                            System.out.print("Kredi kartinizin arkasinda bulunan 3 haneli guvenlik kodunu girin:");
                            int cvc = input.nextInt();
                            
                            //saglamalar
                            int kkNoUzunluk = String.valueOf(kkNo).length();
                            int cvcUzunluk = String.valueOf(cvc).length();
                            
                            if(kkNoUzunluk == 16 && cvcUzunluk ==3){
                                
                                try{
                                    FileOutputStream f = new FileOutputStream("siparisler.txt",true) ;
                                    PrintStream yaz = new PrintStream(f);
                                    yaz.println("*-----*Uye: "+Uyelikler.simdikiUye+"*-----*");
                                    yaz.println(kisiAdi);
                                    yaz.println(telNo);
                                    yaz.println(adres);
                                    yaz.println("*-----*Kredi Karti*-----*");
                                    yaz.println(kkNo);
                                    yaz.println(skt);
                                    yaz.println(cvc);
                                    System.out.println("Siparisiniz basariyla olusturulmustur. Kargonuzu belirttiginiz adrese en kisa zamanda ulastiracagiz.");
                                    System.out.println("Ana menuye donuluyor...");
                                    KitapSatisOtomasyonu.anaMenu();
                                }
                                catch(IOException e){
                                    System.out.println("Bir hata olustu! Menuye yonlendiriliyorsunuz...");
                                    KitapSatisOtomasyonu.anaMenu();
                                }
                            }
                            else{
                                System.out.println("Kredi karti bilgileri hatali! Menuye yonlendiriliyorsunuz...");
                                siparisMenu();
                            }
                     
                        }
                        else{
                            KitapSatisOtomasyonu.anaMenu();
                        }
                    }
                    catch(Exception e){
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
        }
    }
}