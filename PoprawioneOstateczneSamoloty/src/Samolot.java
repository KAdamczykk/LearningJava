public abstract class Samolot implements Pojazd{
    private double iloscPaliwa;
    private int iloscZalogi;
    private String miejsceOdlotu;
    private int[] data = new int[2];
    public Samolot(double iloscPaliwa, int iloscZalogi, String miejsceOdlotu, int[] data) throws WyjatekTransportu{
        if (iloscPaliwa < 200){
            throw new WyjatekBrakPaliwa("Mamy wyciek paliwa, bez paniki proszę");
        } else {
            this.setIloscPaliwa(iloscPaliwa);
        }
        if (iloscZalogi<2){
            throw new WyjatekTransportu("Wczoraj były urodziny kapiutana, nie polecimy");
        } else {
            this.setIloscZalogi(iloscZalogi);
        }
        this.setData(data);
        this.setMiejsceOdlotu(miejsceOdlotu);
    }

    public void setMiejsceOdlotu(String miejsceOdlotu) {
        this.miejsceOdlotu = miejsceOdlotu;
    }

    public void setIloscPaliwa(double iloscPaliwa) {
        this.iloscPaliwa = iloscPaliwa;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public void setIloscZalogi(int iloscZalogi) {
        this.iloscZalogi = iloscZalogi;
    }

    public int getIloscZalogi() {
        return iloscZalogi;
    }

    public int[] getData() {
        return data;
    }


    @Override
    public double getIloscPaliwa() throws WyjatekBrakPaliwa {
        if (iloscPaliwa < 50){
         throw new WyjatekBrakPaliwa("Samolot został skierowany na lądowanie awaryjne na najbliższe lotnisko");
        }
        return this.iloscPaliwa;
    }

    @Override
    public boolean zuzyciePaliwa(double iloscTraconego) {
        try {
            this.setIloscPaliwa(this.getIloscPaliwa() - iloscTraconego);
        } catch (WyjatekBrakPaliwa e) {
            return false;
        }
        return true;
    }

    public String getMiejsceOdlotu() {
        return miejsceOdlotu;
    }

    @Override
    public String toString() {
        return "Samolot odlecial z " +this.getMiejsceOdlotu() + " o " +this.getData()[0] +":"+this.getData()[1] + " ilosc zalogi " +this.getIloscZalogi();
    }
}
