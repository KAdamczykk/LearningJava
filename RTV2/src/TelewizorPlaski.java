public class TelewizorPlaski extends Telewizor implements OdbieranieRozszerzone{
    TelewizorPlaski(int przekatna,  RodzajSygnalu syg, matryca matryca) {
        super(przekatna,syg);
        this.setmatryca(matryca);
    }

    @Override
    public void OdbierzSygnal(RodzajSygnalu syg) {
        this.setRodzajSygnalu(syg);
    }

    protected enum matryca {lcd,led,plazma};
    private matryca matryca;
    public  void setmatryca(matryca matryca){
        this.matryca = matryca;
    }
}
