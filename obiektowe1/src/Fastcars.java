public class Fastcars extends Car{
// w klasie dziedziczacej mozna dawac nowe wlasne zmienne i metody, ktore beda dostepne tylko z poziomu tej danej klasy
    int konie;
    Fastcars(String model, double price, String color, int konie) {
        super(model, price, color);//pozwala na przepisanie czescidanych od rodzica
        this.konie = konie;

    }
    Fastcars(){}
    public String toString(){
        return super.toString() +" "+ this.konie; //super tez dziala w toStringu
    }
    @Override
    void sound(){
        System.out.println("wrum "); //dziecko nadpisuje metode rodzica swoja, gdy maja ta sama nazwe i parametry
    }


}
