package Ciezarowka;

public class Driver extends Truck{
    private boolean trzezwy;

    public void setTrzezwy(boolean trzezwy) {
        this.trzezwy = trzezwy;
    }
    public void drive(){
        System.out.println("Jedziemy");
    }

    @Override
    public String toString() {
        return "" + this.trzezwy;
    }
}
