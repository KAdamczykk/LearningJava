public class Main {
    public static void main(String[] args) {
        Apis apis = new Apis("Anna", 25, 0);
        apis.zyciePszczol();
        apis.addPszczolka(new Apis.Pszczola.KrolowaMatka("Wioletta", 15,0,0));
        apis.addPszczolka(new Apis.Pszczola.Robotnica("Ada", 8,10));
        for (Apis.Pszczola item: apis.ul) {
            System.out.println(item);
        }
        apis.sortuj();
        System.out.println("Po sortowaniu: ");
        for (Apis.Pszczola item: apis.ul) {
            System.out.println(item);
        }
        apis.addPszczolka(apis.dodajZolnieza("Halina", 15,99));
        System.out.println("Dodanie zolnierza: ");
        for (Apis.Pszczola item: apis.ul) {
            System.out.println(item);
        }
        System.out.println();
        apis.watkiPszczol();



    }
}