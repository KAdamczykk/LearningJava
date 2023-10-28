public class Main {
    public static void main(String[] args) {
        System.out.println("Dodanie");
        System.out.println("------------------------------");
        Lotnisko lotnisko = new Lotnisko(7);
        lotnisko.dzialaniaLotniskowe();
        System.out.println("------------------------------");
        lotnisko.OdprawaSamolotow();
        System.out.println("------------------------------");
        lotnisko.dzialaniaLotniskowe();
        System.out.println("------------------------------");
        lotnisko.sortowanieSamolotow();
        System.out.println("------------------------------");
        lotnisko.sortowanieLosowe();
    }
}