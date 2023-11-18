package Ciezarowka;

import Test.TireCompany;

public class SpareWheel extends KoloOdCiezarowki{
    @TireCompany(manufacturer = "ExampleCompany", tireSize = "225/60R16")
    private String info;

    @Override
    public String toString() {
        return "" + this.getTiresize();
    }
}
