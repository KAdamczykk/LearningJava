public class Auta {
    private String name;
    public Auta(String name){
        this.setName(name);
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.getName();
    }


}
