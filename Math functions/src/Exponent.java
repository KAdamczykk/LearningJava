public class Exponent extends Function{
    Dziedzina domain;
    public Exponent(Dziedzina domain){
        this.domain = domain;
    }

    @Override
    public double Calculate(double x) {
        if (this.isinDomain(x, this.domain)){
            return Math.exp(x);

        } else {
            return 0;
        }
    }

    @Override
    public double CalculateDerivative(double x) {
        if (this.isinDomain(x, this.domain)){
            return Math.exp(x);
        } else {
            return 0;
        }
    }
}
