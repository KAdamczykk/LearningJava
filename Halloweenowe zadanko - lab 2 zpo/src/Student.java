public class Student extends Gosc{
    static  int count = 0;
    private int var;
    Student(){
        this.var = count;
        count++;
    }
    @Override
    public String toString() {
        return "Student nr: " + this.var + " Odpornosc: "+ super.toString() + " Stan: " + "" + this.getStan();
    }
}
