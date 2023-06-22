public final class Radio extends UrzadzenieRTV implements Udzwiekowienie{
    Radio(){
        super();
    }

    @Override
    public String toString() {
        if (this.isWlaczone() == true) {
            return super.toString() + "";
        } else {
            return super.toString() + "urzadzenie wylaczone";
        }
    }

    @Override
    public String Odbierz(Radio.czestotliwosc hz) {
        String s = null;
        switch (hz){
            case UHF -> {
                s = "10m -1m";
            }
            case SREDNIE -> {s = "1000m – 200m";}
            case KROTKIE -> {s = "200m – 10m";}
            case DLUGIE -> {s = "20km – 1km";}

        }
        return s;

    }

    @Override
    public void WlaczDzwiek() {
        System.out.println("Wlaczono dzwiek");
    }

    @Override
    public void WylaczDzwiek() {
        System.out.println("Wylaczono dzwiek");
    }

    public enum czestotliwosc {DLUGIE, SREDNIE, KROTKIE , UHF}

    @Override
    public void Wlacz() {
        super.Wlacz();
        if (this.isWlaczone()){
            this.WlaczDzwiek();
        }
    }

    @Override
    public void Wylacz() {
        super.Wylacz();
        this.WylaczDzwiek();
    }
}
