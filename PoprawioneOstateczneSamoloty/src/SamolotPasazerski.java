public final class SamolotPasazerski extends Samolot{
    private int maxIloscMiejsc;
    private int liczbaPasazerow;
    public SamolotPasazerski(double iloscPaliwa, int iloscZalogi, String miejsceOdlotu, int[] data, int maxIloscMiejsc, int liczbaPasazerow) throws WyjatekTransportu {
        super(iloscPaliwa, iloscZalogi, miejsceOdlotu, data);
        if (liczbaPasazerow < maxIloscMiejsc/2){
            throw new WyjatekBiznesowy("Za malo pasazerow do odbycia lotu, przepraszamy.");
        } else {
            this.setLiczbaPasazerow(liczbaPasazerow);
        }
        this.setMaxIloscMiejsc(maxIloscMiejsc);
    }

    public int getMaxIloscMiejsc() {
        return maxIloscMiejsc;
    }

    public int getLiczbaPasazerow() {
        return liczbaPasazerow;
    }

    public void setMaxIloscMiejsc(int maxIloscMiejsc) {
        this.maxIloscMiejsc = maxIloscMiejsc;
    }

    public void setLiczbaPasazerow(int liczbaPasazerow) {
        this.liczbaPasazerow = liczbaPasazerow;
    }

    @Override
    public String toString() {
        return super.toString() + " ma na pokladzie " +this.getLiczbaPasazerow() + ", a maksymalna liczba miejsc wynosi: "+this.getMaxIloscMiejsc();
    }
}
