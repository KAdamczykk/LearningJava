public class TelewizorCRT extends Telewizor{

    private String kolor;
    TelewizorCRT(int przekatna, String kolor){
        super(przekatna, Telewizor.RodzajSygnalu.ANALOGOWY);
        this.kolor = kolor;

    }

}
