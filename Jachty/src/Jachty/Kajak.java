package Jachty;

public class Kajak extends StatkiNawodne{
    protected String typ = "Kajak";
    public Kajak(int ciezar, String producent, int dlugosc) {
        super(ciezar, producent, dlugosc);
        this.setTyp(typ);
    }
}
