import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("twingo", 12000, "white", true);
        Car car2 = new Car("Seiczento", 100, "gold", false);
        car1.Zakupy();
        car2.Zakupy();
        Car car3 = new Car("ferrari", -150, "redzik");
        System.out.println(car3.getModel());
        System.out.println();
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);

        // lista obiektow

        Car[] shop = new Car[3];
        shop[0] = car1;
        shop[1] = car2;
        shop[2] = car3;
        System.out.println();
        System.out.println(shop[0]); //dziala przez to stringa

        // uzywanie klasy do klasy
        Garage garaz = new Garage();
        garaz.park(car1);
        // static w praktyce
        System.out.println();
        System.out.println(Car.amountofcars);
        Car.dislpaycars();
        System.out.println();

        //dziedzicznie
        Fastcars speedy = new Fastcars("tesla", 4444444, "green", 500);
        speedy.sound();
        System.out.println(speedy);
        System.out.println();
        //abstract
        // w klasach nie mozna wywolac czegos z danej klasy ale mozna stworzyc klase pochodna
        // metoda nie implementowana w danej klasie ale w sulasie juz moze byc
        Bulka bulka = new Bulka();
        bulka.zboze();
        System.out.println();

        // dotsep do klas/zmiennych
        // klasa > zmienna: jak klasa nie jest publiczna to zmienna tez nie bedzie
        // public - dostepne z kazdego miejsca w projekcie, z kazdego pakietu po zaimportowaniu
        // protected - dostepna z kazdego pakietu dopoki klasa jest rozszereniem klasy rodzica
        // bez modyfikacji - dostepna tylko w tym pakiecie
        // private - dostepna tylko w danej klasie nie w pochodnych

        // settery i gettery
        // gdy parametry w klasie sa prywatne mozna je ustawic i zmieniec przez odpowiednie metody
        // typ zwrotu getcos(){return this.cos}
        // void setcos( typ cos ){this.cos = cos} + potem mozna w konstruktorze tego uzyc jako this.cos = setcos(cos)

        // kopiowanie obiektow
        Car car4 = new Car(car2);
        System.out.println(car4);
        car4.setPrice(200);
        System.out.println(car2);
        System.out.println(car4);

        // interface
        // sluzydo okreslania jakie metody maja byc zastosowane po zaimplementowaniu ich do jakiejs klasy
        // uzyteczne, gdy chcemy uzyc kilku metod dla kilku roznych klas
        // jedna klasa moze implementowac wiecej niz 1 interface
        Szynka krakowska = new Szynka();
        krakowska.Kasa(10);
        System.out.println();

        // polimorfizm
        // trzymanie roznych typow w jednym przez wspolna ceche np po klasie rodzica
        Slowcars slowly = new Slowcars("fiesta", 1555, "green");
        Car[] store = {speedy, slowly}; //car mozna zastapic slowem object
        for (Car x : store){
            x.sound();
        }
        // dynamic polimorfizm
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        Car auto;
        System.out.println("Chcesz szybkie czy wolne auto? ");
        String x = scanner.nextLine();
        if (x.equals("szybkie")){
            auto = new Fastcars();
            auto.sound();
        } else if (x.equals("wolne")) {
            auto = new Slowcars();
            auto.sound();

        } else {
            auto = new Car();
            System.out.println("error");
        }

    }
}