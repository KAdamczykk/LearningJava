public class OpuszczonySzpital extends Miejsca{
    @Override
    public void nawiedz(Gosc gosc) {
        Straszydlaki jednorazuwa_wariacie = new Straszydlaki() {
            @Override
            public void nastraszKogos(Gosc gosc) {
                if (gosc.getStan() == Gosc.Stan.NORMALNY){
                    gosc.nastraszMnie(15);
                }
            }
        };
        jednorazuwa_wariacie.nastraszKogos(gosc);
    }
}
