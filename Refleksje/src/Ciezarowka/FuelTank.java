package Ciezarowka;

public class FuelTank extends Truck{
    private boolean napelniony;

    public void setNapelniony(boolean napelniony) {
        this.napelniony = napelniony;
    }

    @Override
    public String toString() {
        return "" + napelniony;
    }
}
