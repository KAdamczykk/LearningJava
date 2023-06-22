import javax.xml.namespace.QName;

public class Car {
    private String model;
    // zmienne pisane na zewnatrz jako zmienne globalne dostepne w calej klasie, a nie w poszczegolnych metodach
    private double price;
    private String color;
    private boolean bity;
    static int amountofcars = 0;
    Car( String model, double price, String color) { // moze byc kilka kontruktorow z innymi parametrami
        this.setModel(model);
        this.setPrice(price);
        this.setColor(color);
        amountofcars ++;
    }
    Car( String model, double price, String color, boolean bity) { // konstruktor tj init w pythonie
        this.setModel(model);
        this.setPrice(price);
        this.setColor(color);
        this.setBity(bity);
        amountofcars++;
    }
    Car(Car x){
        this.copy(x);
    }

    Car() {

    }

    public String getModel() {
        return this.model;
    }

    public double getPrice() {
        return this.price;
    }
    public String getColor(){
        return this.color;
    }
    public boolean getBity(){
        return this.bity;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBity(boolean bity) {
        this.bity = bity;
    }

    static void dislpaycars(){
            System.out.println("number of cars is " +amountofcars);
        }
    // static odnosi sie do calej klasy a nie do rzeczy w niej tworzonych, moze to byc zmienna lub metoda
    // toString = str pythonowy
    public String toString(){
        return this.model + " " + this.price + " " + this.color;
    }
    void Zakupy(){
        System.out.println(">Hello I want buy "+this.color+ " "+this.model + " what is the price?");
        System.out.println(">Hi the price it is "+this.price);
        System.out.println(">Is it bity?");
        System.out.println(this.bity);
        if (this.bity == true){
            System.out.println("A to chuj");
        } else {
            System.out.println("biere");
        }
    }
    void sound(){
        System.out.println("brum");
    }
    public void copy(Car x){
        this.setModel(x.getModel());
        this.setPrice(x.getPrice());
        this.setColor(x.getColor());
        this.setBity(x.getBity());
    }

}
