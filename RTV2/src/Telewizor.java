public abstract class Telewizor extends UrzadzenieRTV implements Obrazowanie{
    private int przekatna;
    protected enum RodzajSygnalu{
        CYFROWY,ANALOGOWY
    }
    RodzajSygnalu syg;
    private int odbieranyKanal;
    Telewizor(int przekatna, RodzajSygnalu syg){
        super();
        this.przekatna = przekatna;
        this.setRodzajSygnalu(syg);

    }
    public void setRodzajSygnalu(RodzajSygnalu syg){
        this.syg= syg;
    }
    public RodzajSygnalu getSyg(){
        return this.syg;
    }

    @Override
    public String toString() {
        if (this.isWlaczone() == true){
        return super.toString() + "o przekatnej " + this.przekatna + " odbiera sygnal " + this.getSyg() + " na kanale " + this.odbieranyKanal;}
    else {
        return super.toString() + " urzadzenie wylaczone. ";
        }
    }

    @Override
    public int Odbierz(int nr_kanalu) {
        return this.odbieranyKanal = nr_kanalu;
    }

    @Override
    public void WlaczObraz() {
        System.out.println("Wlaczono obraz");
    }

    @Override
    public void WylaczObraz() {
        System.out.println("Wylaczono Obraz");
    }

    @Override
    public void Wlacz() {
        super.Wlacz();
        if (this.wlaczone){this.WlaczObraz();}
    }

    @Override
    public void Wylacz() {
        this.WylaczObraz();
        super.Wylacz();
    }
}
