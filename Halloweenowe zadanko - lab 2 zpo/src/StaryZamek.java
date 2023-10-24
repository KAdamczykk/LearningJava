public class StaryZamek extends Miejsca{
    static private int moc_bialych_dam = 20;
    static class BialaDama extends Straszydlaki{
        public void nastraszKogos(Gosc gosc){
            gosc.nastraszMnie(moc_bialych_dam);
        }
    }


    @Override
    public void nawiedz(Gosc gosc) {
        BialaDama bialaDama = new BialaDama();
        bialaDama.nastraszKogos(gosc);
        class Duch extends Straszydlaki{
            @Override
            public void nastraszKogos(Gosc gosc) {
                gosc.nastraszMnie(0);
            }
        }
        Duch duch1 = new Duch();
        Duch duch2 = new Duch();
        duch1.nastraszKogos(gosc);
        duch2.nastraszKogos(gosc);

    }
}
