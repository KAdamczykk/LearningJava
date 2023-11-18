package Ciezarowka;

import Ladunek.Cargo;

import java.util.ArrayList;
import java.util.List;

public class Truck {
    private List<Cargo> loadingBody = new ArrayList<>();
    private FuelTank fueltank;
    private SpareWheel spareWheel;
    private DriverCabin driverCabin;
    public List<Cargo> addCargos(List<Cargo> list){
        loadingBody.addAll(list);
        return loadingBody;
    }

    @Override
    public String toString() {
        if (spareWheel == null){return "Truck";}
        if (fueltank == null){return "Truck";}
        if (driverCabin == null){return "Truck, o spareWheel dlugosci: " +this.spareWheel + ", zatankowany: "+ this.fueltank;}
        return "Truck, o spareWheel dlugosci: " +this.spareWheel + ", zatankowany: "+ this.fueltank +", kierowca(trzezwy): " +this.driverCabin.getDriver() + ", CB radio: " + this.driverCabin.getCbRadio();
    }
}
