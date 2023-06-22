import java.util.HashMap;

public class Korytarz {
    private HashMap<Integer, Pasazer> mapa = new HashMap<>();
    static private int counter = 0;

    public HashMap<Integer, Pasazer> getMapa() {
        return mapa;
    }

    public Korytarz(){}
    public void addPerson(Pasazer pasazer){
        mapa.put(counter, pasazer);
        counter++;
    }
}
