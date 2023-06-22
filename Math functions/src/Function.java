public abstract class Function extends Domain implements Derivable{
    public double Calculate(double x) {
        return 0;
    }
    boolean isindomain;



    protected void handloisnotinDomain(){
        boolean b = this.isindomain;
        if (b == false){
            System.out.println("Punkt poza dziedzina");
        }
    }
    static double CalculateSum(Function f1, Function f2, double x){
        double sum = f1.Calculate(x) + f2.Calculate(x);
        return sum;
    }
    static double CalculateSumDerivative(Function f1, Function f2, double x){
        double sum = f1.CalculateDerivative(x) + f2.CalculateDerivative(x);
        return sum;
    }
    static double[] CalculateRowSum(Function[][] funs, double x){
        double[] wektor = new double[funs.length];
        for (int i = 0; i < funs.length; i++){
            double sum = 0;
            for(int j = 0; j<funs[i].length; j++){
                sum = sum + funs[i][j].Calculate(x);
            }
            wektor[i] = sum;
        }
        return wektor;
    }
}
