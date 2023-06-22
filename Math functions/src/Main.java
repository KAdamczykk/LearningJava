import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Domain domain = new Domain();
        domain.Wypisz_Dziedziny();
        domain.wybierzDziedzine(Domain.Dziedzina.RPLUS);
        //System.out.println(domain.isinDomain(-2));
        //System.out.println(domain.isinDomain(5));

        System.out.println();
        Linear f1 = new Linear(4,3,Domain.Dziedzina.R);
        System.out.println(f1.Calculate(4));
        System.out.println(f1.CalculateDerivative(10));
        System.out.println();

        Exponent e = new Exponent(Domain.Dziedzina.RPLUS);
        System.out.println(e.Calculate(0.5));
        System.out.println(e.CalculateDerivative(2));
        System.out.println();

        Sinus sin = new Sinus(Domain.Dziedzina.RMINUS);
        System.out.println(sin.Calculate(-0.5));
        System.out.println(sin.CalculateDerivative(-Math.PI));
        System.out.println();


        System.out.println(Function.CalculateSum(f1, e, 13));
        System.out.println(Function.CalculateSumDerivative(e,sin,4));
        Function[][] macierz = {{f1, e}, {}, {f1, sin}, {e} };
        double[] wektor = Function.CalculateRowSum(macierz, 3);
        System.out.println(Arrays.toString(wektor));





    }
}