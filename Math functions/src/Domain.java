public class Domain {
    public enum Dziedzina{
        R, RMINUS, RPLUS
    }
    Double ogr_dolne, ogr_gorne;

    public void wybierzDziedzine(Domain.Dziedzina dziedzina){


        switch (dziedzina){
            case R -> {
                ogr_gorne = Double.POSITIVE_INFINITY;
                ogr_dolne = Double.NEGATIVE_INFINITY;

            }
            case RPLUS -> {
                ogr_gorne = Double.POSITIVE_INFINITY;
                ogr_dolne = Double.valueOf(0);
            }
            case RMINUS -> {
                ogr_gorne = Double.valueOf(0);
                ogr_dolne = Double.NEGATIVE_INFINITY;

            }


        }
    }


    public void Wypisz_Dziedziny(){
        Dziedzina[] dziedzina = Dziedzina.values();
        System.out.println("Dziedziny:");
        for (int i= 0; i<dziedzina.length; i++){
            System.out.println("* " + dziedzina[i]);
        }
    }
    public boolean isinDomain(double x, Domain.Dziedzina dziedzina){
        wybierzDziedzine(dziedzina);
        if (x<ogr_gorne & x > ogr_dolne){
            return true;
        } else {
            return false;
        }
    }
}
