package Ciezarowka;

import Ciezarowka.Truck;

public class CBRadio extends Truck {
    private boolean dziala;

    public void setDziala(boolean dziala) {
        this.dziala = dziala;
    }

    @Override
    public String toString() {
        return "" + this.dziala;
    }
}
