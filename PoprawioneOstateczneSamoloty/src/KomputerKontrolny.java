import java.util.*;

public class KomputerKontrolny {
    public static void main(String[] args) {
        Random random = new Random();
        String[] miasta = {"Londyn", "Paryz", "LA", "Warszawa", "Berlin", "Praga", "NY", "Pekin"};
        Map<Integer, Samolot> samoloty = new LinkedHashMap<>();
        List<Samolot> listasamolotow = new ArrayList<>();
        int maxIloscMiejsc = 300;
        int i = 0;
        while (i < 10){
            double iloscPaliwa = random.nextDouble(0, 500);
            int zaloga = random.nextInt(0,11);
            int index = random.nextInt(0,miasta.length);
            String miasto = miasta[index];
            int godzina = random.nextInt(20,25);
            int minuta;
            if (godzina == 24){
                minuta = 0;
            } else {
                minuta = random.nextInt(0,60);
            }
            int[] data = {godzina, minuta};
            int liczbaPasazerow = random.nextInt(0,301);
            boolean z  =true;
            try {
                SamolotPasazerski samolotPasazerski = new SamolotPasazerski(iloscPaliwa, zaloga,miasto, data, maxIloscMiejsc, liczbaPasazerow);
                samoloty.put(i,samolotPasazerski);
            } catch (WyjatekBrakPaliwa e) {
                System.out.println(e);
                z = false;
            } catch (WyjatekBiznesowy e){
                System.out.println(e);
                z = false;
            } catch (WyjatekTransportu e){
                System.out.println(e);
                z = false;
            }
            if (z){
                i++;
            }
        }
        for (int j: samoloty.keySet()) {
            listasamolotow.add(samoloty.get(j));
        }
        System.out.println(listasamolotow);
        System.out.println(samoloty);
        System.out.println();

        while (!listasamolotow.isEmpty()){
            ListIterator<Samolot> iterator = listasamolotow.listIterator();
            while (iterator.hasNext()){
                double zurzucie = random.nextDouble(50,200);
                boolean k = iterator.next().zuzyciePaliwa(zurzucie);
                if (!k){
                    iterator.remove();
                    System.out.println("Usunieto samolot");
                }

            }
        }
    }
}
