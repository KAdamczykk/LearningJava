package Jachty;

public abstract class JachtyZaglowe extends Jacht {
    protected int powierzchniaozaglowania;

    public JachtyZaglowe(int ciezar, String producent, int dlugosc, int zanurzenie, int powierzchniaozaglowania) {
        super(ciezar, producent, dlugosc, zanurzenie);
        this.setPowierzchniaozaglowania(powierzchniaozaglowania);
    }

    public void setPowierzchniaozaglowania(int powierzchniaozaglowania) {
        this.powierzchniaozaglowania = powierzchniaozaglowania;
    }

    public int getPowierzchniaozaglowania() {
        return powierzchniaozaglowania;
    }

    @Override
    public String toString() {
        return super.toString() + ", powierzchnia ozaglowania: " + this.getPowierzchniaozaglowania();
    }
}
