public class Main {
    public static void main(String[] args) {
        Apis apis = new Apis("Anna", 25, 0);
        apis.zyciePszczol();
        apis.addPszczolka(apis.new KrolowaMatka("Wioletta", 15,0,0));
        apis.addPszczolka(apis.new Robotnica("Ada", 8,10));
        for (Apis.Pszczolka item: apis.getUl()) {
            System.out.println(item);
        }
        apis.sortuj();
        System.out.println("Po sortowaniu: ");
        for (Apis.Pszczolka item: apis.getUl()) {
            System.out.println(item);
        }
        apis.addPszczolka(apis.dodajZolnieza("Halina", 15,99));
        System.out.println("Dodanie zolnierza: ");
        for (Apis.Pszczolka item: apis.getUl()) {
            System.out.println(item);
        }
        System.out.println();
        System.out.println("Watki pszczolek");
        apis.watkiPszczol();
    }
}