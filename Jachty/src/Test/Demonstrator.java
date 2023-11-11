package Test;

public class Demonstrator {
    public static void main(String[] args) {
        GeneratorStatkow generatorStatkow = new GeneratorStatkow();
        generatorStatkow.generujStatkiNawodne();
        generatorStatkow.listaStatkow.forEach(System.out::println);
        System.out.println("------------Najciezszy------------");
        System.out.println(generatorStatkow.getNajciezszyStatek());
        System.out.println("------------Najdluzsza Na R ------------");
        System.out.println(generatorStatkow.getStatekONajdluzszejNazwieProducentaNaR());
        System.out.println("------------Max moc------------");
        System.out.println(generatorStatkow.getJachtMotorowyONajwiekszejMocySilnika());
        System.out.println("------------Min ozaglowanie dla lekki kabinowy------------");
        System.out.println(generatorStatkow.getLekkiJachtKabinowyONajmniejszymOzaglowaniu());
        System.out.println("------------11 pierwszych ciezkich i dlugich------------");
        generatorStatkow.getCoNajwyzej11DlugichICiezkichJachtow().forEach(System.out::println);
        System.out.println("------------Dlugosc mal bez 2 pierwszych------------");
        System.out.println(generatorStatkow.getStatkiPosortowaneWzgledemDlugosciBez2().size());
        generatorStatkow.getStatkiPosortowaneWzgledemDlugosciBez2().forEach(System.out::println);
        System.out.println("------------Zaglowe po ozaglowaniu od 3 max 8------------");
        generatorStatkow.getPierwsze8ZPosortowanychWzgledemOzaglowaniaBezTrzechPierwszych().forEach(System.out::println);
        System.out.println("------------Kabinowe ktore wplyna wszedzie------------");
        generatorStatkow.oznaczJachtyDobreNaPlycizny();
        System.out.println("------------12 unikalnych nazw merge------------");
        System.out.println(generatorStatkow.get12UnikalnychNazwTypow());
        System.out.println("------------Map typow motor------------");
        generatorStatkow.getMapaJachtowMotorowych().forEach((key, value) -> System.out.println("Klucz: " + key + ", Wartość: " + value));
        System.out.println("------------Po kolei ostatnie------------");
        generatorStatkow.getJachtyOdkrytopokladoweIMotoroweJednePoDrugich().forEach(System.out::println);
    }
}
