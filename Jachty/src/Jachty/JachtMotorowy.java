package Jachty;

public class JachtMotorowy extends Jacht {
    protected int moc_silnika;
    protected String typ = "Jacht Motorowy";
    protected String type;

    public JachtMotorowy(int ciezar, String producent, int dlugosc, int zanurzenie, int moc_silnika, String type) {
        super(ciezar, producent, dlugosc, zanurzenie);
        this.setMoc_silnika(moc_silnika);
        this.setTyp(typ);
        setType(type);
    }


    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setMoc_silnika(int moc_silnika) {
        this.moc_silnika = moc_silnika;
    }

    public int getMoc_silnika() {
        return moc_silnika;
    }

    @Override
    public String toString() {
        return super.toString() + ", moc silnika: " + this.getMoc_silnika();
    }


}
