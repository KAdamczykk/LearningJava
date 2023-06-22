public class Obliczenia implements Runnable{
    private int k;
    private double wynik;
    public Obliczenia(int k){
        this.setK(k);
    }
    @Override
    public void run() { // metoda run z interfejsu runnable okresla co bedzie wykonywane w tym samym momencie
        System.out.println("Start");
        for (int i = 0; i <k;i++){
            wynik += 1;
        }
        System.out.println("Koniec");
    }

    public void setK(int k) {
        this.k = k;
    }

    public double getWynik() {
        return wynik;
    }
}
