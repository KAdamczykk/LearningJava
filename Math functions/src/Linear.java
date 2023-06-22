public class Linear extends Function{
    double a;
    double b;
    Dziedzina domain;
    public Linear(double a, double b , Dziedzina domain){
        this.a = a;
        this.b = b;
        this.domain = domain;
    }
    public Linear(String string){

    }

    @Override
    public double Calculate(double x) {
        double y = x * this.a + this.b;
        if (this.isinDomain(x, this.domain)){
        return y; } else {
            return 0;
        }
    }

    @Override
    public double CalculateDerivative(double x) {
        if(this.isinDomain(x, this.domain)){
            return this.a;} else {
            return 0;
        }
    }
}
