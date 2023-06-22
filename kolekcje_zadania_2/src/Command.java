public class Command {
    private String string;
    public Command(String string){
        this.setString(string);
    }
    public void setString(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }

    public void Operation(){
        System.out.println(this.getString());
    }
}
