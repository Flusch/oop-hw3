//
//Yavuz Selim GÜLER
//1306160016
//

package kitap.satis.otomasyonu;

interface IKitapIslemleri{
    void kitapIslemleriMenu();
    void kitapIslemleriListe();
    void kitapIslemleriSecme();
    void kitapIslemleriSil(String id);
}

public class KitapIslemleri extends Kitaplar {
    void kitapIslemleriMenu(){
        super.kitapMenu();
    }
    void kitapIslemleriEkle(){
        super.kitapEkle();
    }
}