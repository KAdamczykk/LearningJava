package Jachty;

public abstract class Jacht extends StatkiNawodne{
    protected int zanurzenie;

    public Jacht(int ciezar, String producent, int dlugosc, int zanurzenie) {
        super(ciezar, producent, dlugosc);
        this.setZanurzenie(zanurzenie);
    }

    public void setZanurzenie(int zanurzenie) {
        this.zanurzenie = zanurzenie;
    }

    public int getZanurzenie() {
        return zanurzenie;
    }

    @Override
    public String toString() {
        return super.toString() + ", zanurzenie: " +this.getZanurzenie();
    }



}

