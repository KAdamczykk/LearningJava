public class ZadluzoneMieszkanieZZaleglosciamiZaWode extends ZadluzoneMieszkanie{

    ZadluzoneMieszkanieZZaleglosciamiZaWode(){
        this.setZadluzenie(random.nextInt(1,1001));
    }
    private class Wodnik extends Straszydlaki{
        private int moc;
        Wodnik(){
            this.moc = random.nextInt(10,31);
        }

        @Override
        public void nastraszKogos(Gosc gosc) {
            gosc.nastraszMnie(moc);
        }
    }
    private void nawiedzlazienke(Gosc gosc){
        Wodnik wodnik = new Wodnik();
        wodnik.nastraszKogos(gosc);
    }
    private void nawiedzpralnie(Gosc gosc){
        Komornik komornik = new Komornik();
        komornik.nastraszKogos(gosc);
    }
    @Override
    public void nawiedz(Gosc gosc){
        int probability = random.nextInt(0,2);
        if (probability == 0){
            this.nawiedzlazienke(gosc);
        } else {
            this.nawiedzpralnie(gosc);
        }
    }

}
