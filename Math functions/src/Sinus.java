public class Sinus extends Function{
    Dziedzina domain;
    public Sinus(Dziedzina domain){
        this.domain = domain;
    }

    @Override
    public double Calculate(double x) {
        if(this.isinDomain(x, this.domain)){
        return Math.sin(x);} else {
            return 0;
        }
    }

    @Override
    public double CalculateDerivative(double x) {
        if(this.isinDomain(x, this.domain)){
            return Math.cos(x);} else {
            return 0;
        }
    }
}
