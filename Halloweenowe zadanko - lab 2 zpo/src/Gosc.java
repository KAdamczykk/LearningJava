import java.util.Random;

public abstract class Gosc {
    private int odpornosc;
    public enum Stan {
        NORMALNY, PRZERAZONY, PANIKA;
    }
    private Stan stan;
    Gosc(){
        Random random = new Random();
        this.setOdpornosc(random.nextInt(10,21));
        this.setStan(Stan.NORMALNY);
    }

    public int getOdpornosc() {
        return odpornosc;
    }

    public Stan getStan() {
        return stan;
    }

    @Override
    public String toString() {
        return "" + this.getOdpornosc();
    }

    public void setOdpornosc(int odpornosc) {
        this.odpornosc = odpornosc;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
    }
    public void nastraszMnie(int moc){
        System.out.println("Nastraszyłej mnie mocą: " + moc);
        System.out.println(this);
    }
}
