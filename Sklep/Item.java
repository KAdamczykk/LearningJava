public abstract class Item implements Sellable {
    static int liczba_sprzedarzy_rowerow = 0;
    static int liczba_sprzedarzy_skate = 0;
    enum Promotion {NONE, PERCENT, AMOUNT, TWOFORONE}
    public double Calculate(){
        double cena_koncowa;
        if (this.prom == Promotion.PERCENT){
            cena_koncowa = cena * liczba_sztuk* 0.6;
        } else if (this.prom == Promotion.NONE) {
            cena_koncowa = cena * liczba_sztuk;

        } else if (this.prom == Promotion.AMOUNT) {
            double cena_produktu = cena * 0.9;
            cena_koncowa = cena_produktu * liczba_sztuk;
        } else{
            if (liczba_sztuk % 2 == 0){
                cena_koncowa = cena * (liczba_sztuk /2);
            } else {
                cena_koncowa = cena * (liczba_sztuk%2) + cena;
            }
        }

        return cena_koncowa;
    }
    double cena;
    int liczba_sztuk;
    Promotion prom;
    Item(int liczba_sztuk, double cena ){
        this.cena = cena;
        this.liczba_sztuk = liczba_sztuk;
    }
    public int GetAmount(){
        return liczba_sztuk;
    }
    public boolean isAvailable(int liczba){
        if (liczba > liczba_sztuk){
            return false;
        } else {
            return true;
        }

    }
    public double getCost(){
        return Calculate();
    }

    @Override
    public boolean Sell(int liczba) {
        if (liczba > this.liczba_sztuk){
            System.out.println("Amount not available!");
            return false;
        } else {
            if (this instanceof Bike && liczba_sprzedarzy_rowerow == 0){
                System.out.println("First bike has been sold");
                liczba_sprzedarzy_rowerow ++;
                liczba_sztuk = liczba_sztuk - liczba;
            } else if (this instanceof Skateboard && liczba_sprzedarzy_skate == 0) {
                System.out.println("First skateboard has been sold");
                liczba_sprzedarzy_skate ++;
                liczba_sztuk = liczba_sztuk - liczba;

            } else if (this instanceof Bike) {
                liczba_sztuk = liczba_sztuk - liczba;
                System.out.println("Bikes sold");
                liczba_sprzedarzy_rowerow++;
            } else {
                liczba_sztuk  = liczba_sztuk - liczba;
                System.out.println("SkateBoards sold");
                liczba_sprzedarzy_skate++;}
            return true;
        }
    }
}
