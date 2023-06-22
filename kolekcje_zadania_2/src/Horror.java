public class Horror extends Film{
    private final String typ = "Horror";

    public Horror(String tytul, int czasTrwania, boolean czyObejrzany) {
        super(tytul, czasTrwania, czyObejrzany);
    }

    public String getTyp() {
        return this.typ;
    }

    @Override
    public String toString() {
        return super.toString() + " Typ: " +this.getTyp();
    }
}
