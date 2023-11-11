package Jachty;

public abstract class StatkiNawodne {
    protected int ciezar;
    protected String producent;
    protected int dlugosc;
    protected String typ;
    public StatkiNawodne(int ciezar, String producent, int dlugosc){
        this.setCiezar(ciezar);
        this.setDlugosc(dlugosc);
        this.setProducent(producent);
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public void setCiezar(int ciezar) {
        this.ciezar = ciezar;
    }

    public void setDlugosc(int dlugosc) {
        this.dlugosc = dlugosc;
    }

    public String getProducent() {
        return producent;
    }

    public int getCiezar() {
        return ciezar;
    }

    public int getDlugosc() {
        return dlugosc;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getTyp() {
        return typ;
    }

    @Override
    public String toString() {
        return this.getTyp() + ", producent: " + this.getProducent() + ", ciezar: " + this.getCiezar() + ", dlugosc: " + this.getDlugosc();
    }
}
