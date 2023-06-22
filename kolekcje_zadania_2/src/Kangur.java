public class Kangur {
    private static int nr = 1 ;
    private int nrKangura;
    public Kangur(){
        this.setNrKangura(nr);
        nr++;
    }



    public int skok(){
        System.out.println("Kangur nr " + this.nrKangura + " wykonal skok");
        return this.nrKangura;
    }

    public void setNrKangura(int nrKangura) {
        this.nrKangura = nrKangura;
    }
}
