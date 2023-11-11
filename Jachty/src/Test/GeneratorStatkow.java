package Test;

import Jachty.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GeneratorStatkow implements Statki {
    List<StatkiNawodne> listaStatkow;
    Random random = new Random();
    String[] producenci = {"Regal", "REGAL", "REgal", "Promt", "XD", "PolskiSuperPrzewoznik", "Barka", "Ridl", "Romper", "Zubr",
    "zywiec", "polskapartiaprzyjaciolpiwa", "aferakielbasiana2", "walaszekgrubasiekiedynowybomba", "egzorcysta", "wrr", "wow", "Regex", "linuxtoguwno","realoverbarca"};
    String[] type = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
    public void generujStatkiNawodne(){
        listaStatkow = new ArrayList<>();
        int ciezar, index,dlugosc,zanurzenie,moc, ozeglowanie, indextype;
        String producent;

        for (int i = 0; i < 100; i++){
            // kajaki
            ciezar = random.nextInt(500,2750);
            index = random.nextInt(0, producenci.length);
            producent = producenci[index];
            dlugosc = random.nextInt(50,1001);
            listaStatkow.add(new Kajak(ciezar, producent, dlugosc));
            // motorowe
            ciezar = random.nextInt(500,2750);
            index = random.nextInt(0, producenci.length);
            indextype = random.nextInt(0, type.length);
            producent = producenci[index];
            dlugosc = random.nextInt(50,1001);
            moc = random.nextInt(100,1000);
            zanurzenie = random.nextInt(15,100);
            listaStatkow.add(new JachtMotorowy(ciezar, producent, dlugosc,zanurzenie,moc, type[indextype]));
            // kabinowe
            ciezar = random.nextInt(500,2750);
            index = random.nextInt(0, producenci.length);
            producent = producenci[index];
            dlugosc = random.nextInt(50,1001);
            zanurzenie = random.nextInt(15,100);
            ozeglowanie = random.nextInt(50,400);
            listaStatkow.add(new JachtKabinowy(ciezar, producent, dlugosc, zanurzenie, ozeglowanie));
            // niekabinowe
            ciezar = random.nextInt(500,2750);
            index = random.nextInt(0, producenci.length);
            producent = producenci[index];
            dlugosc = random.nextInt(50,1001);
            zanurzenie = random.nextInt(15,100);
            ozeglowanie = random.nextInt(50,400);
            listaStatkow.add(new JachtOdkrytoPokladowy(ciezar, producent, dlugosc, zanurzenie, ozeglowanie));

        }
    }

    @Override
    public StatkiNawodne getNajciezszyStatek() {
        return listaStatkow.stream().max(Comparator.comparingInt(StatkiNawodne::getCiezar)).get();
    }

    @Override
    public StatkiNawodne getStatekONajdluzszejNazwieProducentaNaR() {
        return listaStatkow.stream().filter(s -> s.getProducent().charAt(0) == 'R').max(Comparator.comparingInt(a -> a.getProducent().length())).get();
    }

    @Override
    public JachtMotorowy getJachtMotorowyONajwiekszejMocySilnika() {
        return listaStatkow.stream().filter(s -> s instanceof JachtMotorowy).map(s -> (JachtMotorowy) s).max(Comparator.comparingInt(JachtMotorowy::getMoc_silnika)).get();
    }

    @Override
    public JachtKabinowy getLekkiJachtKabinowyONajmniejszymOzaglowaniu() {
        return listaStatkow.stream().filter(s -> s instanceof JachtKabinowy).map(s -> (JachtKabinowy) s).filter(s -> s.getCiezar() < 1000).
                min(Comparator.comparingInt(JachtKabinowy::getPowierzchniaozaglowania)).get();
    }

    @Override
    public Set<StatkiNawodne> getCoNajwyzej11DlugichICiezkichJachtow() {
        return listaStatkow.stream().filter(s -> s.getCiezar() > 1400).filter(s -> s.getDlugosc() > 700).limit(11).collect(Collectors.toSet());
    }

    @Override
    public List<StatkiNawodne> getStatkiPosortowaneWzgledemDlugosciBez2() {
        return listaStatkow.stream().skip(2).sorted(Comparator.comparingInt(StatkiNawodne::getDlugosc).reversed()).collect(Collectors.toList());
    }

    @Override
    public List<JachtyZaglowe> getPierwsze8ZPosortowanychWzgledemOzaglowaniaBezTrzechPierwszych() {
        return listaStatkow.stream().filter(s -> s instanceof JachtyZaglowe).map(s -> (JachtyZaglowe) s).sorted(Comparator.comparingInt(JachtyZaglowe::getPowierzchniaozaglowania).reversed()).skip(2).limit(8).collect(Collectors.toList());
    }

    @Override
    public void oznaczJachtyDobreNaPlycizny() {
        listaStatkow.stream().filter(s -> s instanceof JachtKabinowy).map(s -> (JachtKabinowy) s).filter(s -> s.getZanurzenie() <= 30).
                filter(s -> s.getCiezar() <= 1300).toList().forEach(s -> System.out.println("Jachtem " + s.getTyp() + ", " + s.getProducent() +", wplyniesz wszedzie"));
    }

    @Override
    public String get12UnikalnychNazwTypow() {
        return listaStatkow.stream().filter(s -> s.getCiezar() > 2000).map(StatkiNawodne::getProducent).distinct().skip(3).limit(12).collect(Collectors.joining("-"));
    }

    @Override
    public Map<String, JachtMotorowy> getMapaJachtowMotorowych() {
        return listaStatkow.stream().filter(s -> s instanceof JachtMotorowy).map(s -> (JachtMotorowy) s).collect(Collectors.toMap(
                JachtMotorowy::getType,
                jacht -> jacht, (exist, replace) -> {
                    if (exist.getProducent().length() > replace.getProducent().length()){
                        return exist;
                    } else {
                        return replace;
                    }
                }
        ));
    }

    @Override
    public List<Jacht> getJachtyOdkrytopokladoweIMotoroweJednePoDrugich() {
        Stream<Jacht> stream1 = listaStatkow.stream().filter(s -> s instanceof JachtOdkrytoPokladowy).map(s -> (Jacht) s).
                filter(s -> s.getProducent().equalsIgnoreCase("regal")).skip(5).limit(10);
        Stream<Jacht> stream2 = listaStatkow.stream().filter(s -> s instanceof JachtMotorowy).map(s -> (Jacht) s).
                filter(s -> s.getProducent().equalsIgnoreCase("regal")).skip(5).limit(10);
        return Stream.concat(stream1, stream2).collect(Collectors.toList());
    }
}
