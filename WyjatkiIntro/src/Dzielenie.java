public class Dzielenie {

    Dzielenie() throws StupidException{
        System.out.println("Konstruktor");
    }
    public double Podziel(double x, double y ) throws ArithmeticException, StupidException, NullPointerException {
        if (y == 0) {
            throw new StupidException();
        }
        double z = x/y;
        return z;
    }
}
