public class Bike extends Item{
    Bike(int liczba_sztuk, double cena, Promotion promotion) {
        super(liczba_sztuk, cena);
        this.prom = promotion;
    }
    static Item.Promotion[] ApplyBestPromotion(int[] lista_sztuk, double[] price){
        Item.Promotion[] promotions = new Promotion[lista_sztuk.length];
        for(int i=0;i < promotions.length; i++ ){
            Bike bike1 = new Bike(lista_sztuk[i], price[i], Promotion.AMOUNT);
            Bike bike2 = new Bike(lista_sztuk[i], price[i], Promotion.NONE);
            Bike bike3 = new Bike(lista_sztuk[i], price[i], Promotion.PERCENT);
            Bike bike4 = new Bike(lista_sztuk[i], price[i], Promotion.TWOFORONE);
            double cost1 = bike1.Calculate();
            double cost2 = bike2.Calculate();
            double cost3 = bike3.Calculate();
            double cost4 = bike4.Calculate();
            double min1 = Math.min(cost1, cost2);
            double min2 = Math.min(min1, cost3);
            double min_ost = Math.min(min2, cost4);
            if (min_ost == cost1) {
                promotions[i] = Promotion.AMOUNT;
                System.out.println("Amount");
            } else if (min_ost == cost2) {
                promotions[i] = Promotion.NONE;
                System.out.println("None");
            }else if (min_ost == cost3) {
                promotions[i] = Promotion.PERCENT;
                System.out.println("Percent");
            } else {
                promotions[i] = Promotion.TWOFORONE;
                System.out.println("TwoForOne");
            }
        }
        return promotions;
    }
}
