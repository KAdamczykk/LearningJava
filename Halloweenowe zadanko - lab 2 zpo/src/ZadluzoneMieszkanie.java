public abstract class ZadluzoneMieszkanie extends Miejsca{
    private int zadluzenie;
    ZadluzoneMieszkanie(){}

    public int getZadluzenie() {
        return zadluzenie;
    }

    public void setZadluzenie(int zadluzenie) {
        this.zadluzenie = zadluzenie;
    }
    protected class Komornik extends Straszydlaki{
        private int moc;
        Komornik(){
            this.moc = getZadluzenie() / 500;
        }

        @Override
        public void nastraszKogos(Gosc gosc) {
            gosc.nastraszMnie(moc);
        }
    }
}
