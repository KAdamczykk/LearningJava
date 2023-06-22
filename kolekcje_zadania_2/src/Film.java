public class Film {
    private int czasTrwania;
    private String tytul;
    private boolean czyObejrzany;
    public Film(String tytul, int czasTrwania, boolean czyObejrzany){
        this.setTytul(tytul);
        this.setCzasTrwania(czasTrwania);
        this.setCzyObejrzany(czyObejrzany);
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public void setCzasTrwania(int czasTrwania) {
        this.czasTrwania = czasTrwania;
    }

    public void setCzyObejrzany(boolean czyObejrzany) {
        this.czyObejrzany = czyObejrzany;
    }

    public String getTytul() {
        return this.tytul;
    }

    public int getCzasTrwania() {
        return this.czasTrwania;
    }
    public boolean getCzyObejrzany(){
        return this.czyObejrzany;
    }



    public String toString() {
        return "Tytul: " + this.getTytul() +", trwa: " +this.getCzasTrwania() + ", obejrzany: " + this.getCzyObejrzany() +".";
    }

}
