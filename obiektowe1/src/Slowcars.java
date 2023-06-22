public class Slowcars extends Car{
    Slowcars(String model, double price, String color) {
        super(model, price, color);
    }

    Slowcars(String model, double price, String color, boolean bity) {
        super(model, price, color, bity);
    }

    Slowcars(Car x) {
        super(x);
    }
    Slowcars(){}

    @Override
    void sound() {
        System.out.println("grhh");
    }
}
