public class Skateboard extends Item{
    static int liczba_stworzen =0;
    static double total_price = 0;
    Skateboard(int liczba_sztuk, double cena) {
        super(liczba_sztuk, cena);
        prom = Promotion.PERCENT;
        liczba_stworzen++;
        total_price = total_price + this.Calculate();
    }
    static double TotalPrice(){
      double cost;
        cost = total_price;

      return cost;
    }
}
