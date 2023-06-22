public class Mieso extends Spozywczy{
    private double cena;
    private double kg;
    public Mieso(double cena, double kg) {
        super(cena);
        this.setCena(cena, kg);
        this.setKg(kg);
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    public double getKg() {
        return kg;
    }

    public void setCena(double cena, double kg) {
        this.cena = cena * kg;
    }
}
