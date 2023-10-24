import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------Poczatek---------------");
        StaryZamek staryZamek = new StaryZamek();
        OpuszczonySzpital opuszczonySzpital = new OpuszczonySzpital();
        ZadluzoneMieszkanieZNiesplacanymKredytem zadluzoneMieszkanieZNiesplacanymKredytem = new ZadluzoneMieszkanieZNiesplacanymKredytem();
        ZadluzoneMieszkanieZZaleglosciamiZaWode zadluzoneMieszkanieZZaleglosciamiZaWode = new ZadluzoneMieszkanieZZaleglosciamiZaWode();
        Miejsca[] miejsca = {staryZamek, opuszczonySzpital, zadluzoneMieszkanieZZaleglosciamiZaWode, zadluzoneMieszkanieZNiesplacanymKredytem};
        List<Gosc> list = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Turysta turysta = new Turysta();
            Student student = new Student();
            list.add(turysta);
            list.add(student);
            System.out.println(turysta);
            System.out.println(student);
        }
        System.out.println("---------------Straszenie---------------");
        for (Gosc gosc:list) {
            for (Miejsca miejsce:miejsca) {
                miejsce.nawiedz(gosc);
            }
        }
    }
}