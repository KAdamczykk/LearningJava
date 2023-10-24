public class Turysta extends Gosc{
    static int count = 0;
    private int var;
    Turysta(){
        this.var = count;
        count++;
    }
    @Override
    public void nastraszMnie(int moc){
        if (moc > this.getOdpornosc() && this.getStan() == Stan.NORMALNY){
            this.setStan(Stan.PRZERAZONY);
        } else if (moc > this.getOdpornosc() && this.getStan() == Stan.PRZERAZONY) {
            this.setStan(Stan.PANIKA);
        } else if (moc < this.getOdpornosc() && this.getStan() == Stan.PANIKA) {
            this.setStan(Stan.PRZERAZONY);
        } else if (moc < this.getOdpornosc() && this.getStan() == Stan.PRZERAZONY) {
            this.setStan(Stan.NORMALNY);
        }
        super.nastraszMnie(moc);
    }


    @Override
    public String toString() {
        return "Turysta nr: " + this.var + " Odpornosc: " + super.toString() + " Stan: " + "" + this.getStan();
    }
}
