package pl.edu.pw.po.roboty;

public class SztucznaInteligencja {
    public enum reprezentacja_danych  {binarna, rozmyta, przyblizona }
    private reprezentacja_danych rep;
    public SztucznaInteligencja(reprezentacja_danych rep){
        this.setRep(rep);
    }

    public void setRep(reprezentacja_danych rep) {
        this.rep = rep;
    }

    public reprezentacja_danych getRep() {
        return rep;
    }
}
