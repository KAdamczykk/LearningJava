public class Main {
    public static void main(String[] args) {
        Skateboard skateboard1 = new Skateboard(15, 100);
        Bike bike1 = new Bike(24, 650, Item.Promotion.AMOUNT);
        Bike bike2 = new Bike(23,450, Item.Promotion.NONE);
        double[] ceny = {450,780,130,5150,23445};
        int[] sztuki = {3,99,555,34,100};
        Skateboard skateboard2 = new Skateboard(20,450);

        System.out.println(skateboard1.Calculate());
        System.out.println(bike1.Calculate());
        System.out.println(bike2.Calculate());
        System.out.println(bike1.GetAmount());
        Bike.ApplyBestPromotion(sztuki, ceny);
        bike1.Sell(15);
        System.out.println(bike1.isAvailable(15));
        System.out.println(Skateboard.TotalPrice());


    }
}