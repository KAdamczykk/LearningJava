public class Main {
    public static void main(String[] args) {
        Radio radio1 = new Radio();
        Radio radio2 = new Radio();
        TelewizorCRT crt1 = new TelewizorCRT(32,"red");
        TelewizorCRT crt2 = new TelewizorCRT(35, "Kred");
        TelewizorPlaski p1 = new TelewizorPlaski(50, Telewizor.RodzajSygnalu.ANALOGOWY, TelewizorPlaski.matryca.led);
        TelewizorPlaski p2 = new TelewizorPlaski(55, Telewizor.RodzajSygnalu.CYFROWY, TelewizorPlaski.matryca.plazma);
        crt1.Odbierz(15);
        crt2.Odbierz(53);
        p1.Odbierz(11);
        p2.Odbierz(12);
        radio1.Odbierz(Radio.czestotliwosc.DLUGIE);
        radio2.Odbierz(Radio.czestotliwosc.UHF);
        UrzadzenieRTV[] lista = {radio1, radio2, crt1, crt2, p1,p2};
        for (int i =0; i < lista.length; i++){
            if (lista[i] instanceof Telewizor){
                lista[i].Wlacz();
            }
        }
        for (int j = 0; j< lista.length; j++){
            System.out.println(lista[j]);
        }
    }
}