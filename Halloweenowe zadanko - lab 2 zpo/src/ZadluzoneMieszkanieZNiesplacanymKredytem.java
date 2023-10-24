public class ZadluzoneMieszkanieZNiesplacanymKredytem extends ZadluzoneMieszkanie{
    ZadluzoneMieszkanieZNiesplacanymKredytem(){
        this.setZadluzenie(random.nextInt(1,10001));
    }
    private void nawiedzlazienke(Gosc gosc){
        Komornik komornik1 = new Komornik();
        Komornik komornik2 = new Komornik();
        komornik1.nastraszKogos(gosc);
        komornik2.nastraszKogos(gosc);

    }

    private void nawiedzpralnie(Gosc gosc){
        Komornik komornik = new Komornik();
        komornik.nastraszKogos(gosc);
    }
    @Override
    public void nawiedz(Gosc gosc){
        this.nawiedzlazienke(gosc);
        this.nawiedzpralnie(gosc);
    }
}
