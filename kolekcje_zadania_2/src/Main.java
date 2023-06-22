import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Zadanko 1");
        Auta a1 = new Auta("Ferrari");
        Auta a2 = new Auta("Porshe");
        Auta a3 = new Auta("Tico");
        Auta a4 = new Auta("Fiat");
        Auta a5 = new Auta("Blaszak");
        Auta a6 = new Auta("Cabrio");
        Auta a7 = new Auta("Chevrolet");
        Auta a8 = new Auta("Forza");
        Auta a9 = new Auta("Golf");
        Auta a10 = new Auta("Passat");
        Auta a11 = new Auta("Seiczento");
        Auta[] komis = {a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11};
        List<Auta> salon = new ArrayList<>(Arrays.asList(komis));
        System.out.println(salon);
        salon.removeAll(salon.subList(2,7));
        System.out.println(salon);
        System.out.println();
        System.out.println("Zadanko 2");
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list1.add(i*4);
        }
        for (int j = 0 ; j < 5; j++){
            list2.add(5*j);
        }
        ListIterator<Integer> i = list1.listIterator(9);
        while (i.hasPrevious()){
            list2.add(i.previous());
        }
        System.out.println(list2);
        System.out.println();
        System.out.println("Zadanko 3");
        Command c1 = new Command("chuj");
        Command c2 = new Command("kss");
        Command c3 = new Command("chffuj");
        Command c4 = new Command("sdsds");
        Command c5 = new Command("sdsdsd");
        Command c6 = new Command("chujj");
        Command[] list = {c1,c2,c3,c4,c5,c6};
        Queue<Command> queue = new LinkedList<>();
        Kueue.wypelnij(queue, list);
        Konsumuj.jedzonko(queue);
        System.out.println();
        System.out.println("Zadanko 4");
        List<Kangur> kangurs = new ArrayList<>();
        for (int k =0; k<12; k++){
            Kangur kangur = new Kangur();
            kangurs.add(kangur);
        }
        for (int k = 0; k <12; k++){
            kangurs.get(k).skok();
        }
        ListIterator<Kangur> kangurListIterator = kangurs.listIterator();
        while (kangurListIterator.hasNext()){
            kangurListIterator.next().skok();
        }
        String[] imiona = {"Maciek", "Jacek", "Piotr", "Wiktoria", "Tryt", "Leon", "Haniek", "Maniek", "Wiktor", "Pop", "Fjut", "Docent"};
        HashMap<String, Kangur> hsh = new HashMap<>();
        for (int k = 0; k <12; k++){
            hsh.put(imiona[k], kangurs.get(k));
        }
        Iterator<String> hit = hsh.keySet().iterator();
        while (hit.hasNext()){
            String var = hit.next();
            hsh.get(var).skok();
        }
        System.out.println();
        System.out.println("Zadanko 5");
        Stos<Integer> stos = new Stos<>();
        System.out.println(stos.Empty());
        stos.push(12);
        stos.push(2);
        stos.push(1);
        stos.push(15);
        stos.push(122);
        stos.pop();
        System.out.println(stos);
        String wyrazenie =  "+B+a+ł---+a+g+a---+n-+w-+l+i+t---+e-+r+k--+a+c+h--";
        Stos<Character> charstos= new Stos<>();
        try {
            System.out.println(charstos.Oblicz_wyrazenie(wyrazenie));
        } catch (WrongTypeException e){
            System.out.println(e);
        }
        System.out.println();
        System.out.println("Zadanko 6 - proste");
        System.out.println();
        System.out.println("Zadanko 7 ");
        Film film1 = new Film("jeje", 145, true);
        Film film2 = new Film("jee", 155, false);
        Film film3 = new Film("eje", 45, true);
        Komedia komedia1 = new Komedia("je", 222, false);
        Komedia komedia2 = new Komedia("jejj", 22, false);
        Komedia komedia3 = new Komedia("jze", 230, true);
        Horror horror1 = new Horror("zee", 122, true);
        Horror horror2 = new Horror("zeez", 322, false);
        Horror horror3 = new Horror("zzee", 172, true);
        Film[] listaFilmow = {film1, film2, film3, komedia1, komedia2, komedia3, horror1, horror2, horror3};
        Map<Integer, Film> kontener = new TreeMap<>();
        for (int k = 0; k < 9; k++){
            kontener.put(k, listaFilmow[k]);
        }
        Iterator<Integer> iter = kontener.keySet().iterator();
        while (iter.hasNext()){
            int var = iter.next();
            System.out.println("Nr w kolekcji: "+var+ " "+ kontener.get(var));

        }

    }


}