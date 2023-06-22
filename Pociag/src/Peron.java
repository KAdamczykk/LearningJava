import java.util.LinkedHashMap;


public class Peron {
    LinkedHashMap<Integer, Pasazer> kolejkaPeronowa = new LinkedHashMap<>();
    public Peron(){
        this.UzupelnijPeron();
    }
    private void UzupelnijPeron(){
        for(int i = 0; i <500; i++){
            Pasazer pasazer= new Pasazer();
            kolejkaPeronowa.put(i, pasazer);
        }

    }
}
