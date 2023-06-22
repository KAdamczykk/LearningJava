public class ZadaniaWatki {
    public static class WypiszWiadomosc implements Runnable{
        private int k;
        private String msg;
        private int p;
        public WypiszWiadomosc(int p, int k, String msg){
            this.k = k;
            this.msg = msg;
        }

        @Override
        public void run() {
            for (int i = 0; i < k; i++){
                System.out.println(msg);
            }
            try {
                Thread.sleep(p*1000);
            } catch (InterruptedException e) {
                System.out.println("It wasn't work");;
            }
            System.out.println("Done");
        }

    }
    public static class ModTablicy implements Runnable {
        private int[] list;
        private int zmienna;
        private int sleepy;
        public ModTablicy(int[] list, int zmienna, int sleepy){
            this.sleepy = sleepy;
            this.zmienna = zmienna;
            this.list = list;
        }

        @Override
        public void run() {
            int var = 999999999;
            int index = -1;
            for (int i = 0; i < list.length; i++) {
                if (list[i] < var){
                    var = list[i];
                    index = i;
                }
            }

            if (index == -1 || var > zmienna){
                return;
            } else {
                list[index] = zmienna;
                System.out.println(WypiszListe());
                try {
                    Thread.sleep(1000*sleepy);
                    System.out.println("I'm sleeping");
                    System.out.println("Done");
                } catch (InterruptedException e) {
                    System.out.println("Something wrong");
                }
            }

        }
        public String WypiszListe(){
            String str = "";
            for (int i: list) {
                str += ""+i+" ";
            }
            return str;
        }
    }
    public static void main(String[] args) {



        WypiszWiadomosc w1 = new WypiszWiadomosc(2, 20, "Ala ma kota.");
        WypiszWiadomosc w2 = new WypiszWiadomosc(3, 10, "xyzxyzxyzxyzxyzxyzxyzxyz");
        WypiszWiadomosc w3 = new WypiszWiadomosc(1, 30, "…………………………………..");

        Thread t1 = new Thread(w1);
        Thread t2= new Thread(w2);
        Thread t3 = new Thread(w3);
        t1.start();
        t2.start();
        t3.start();
        

        /*
        System.out.println("Zadanie 4");
        int[] lista = new int[20];
        for (int i = 0; i < lista.length; i++){
            lista[i] = 0;
        }
        ModTablicy m1 = new ModTablicy(lista, 20,3);
        ModTablicy m2 = new ModTablicy(lista, 11,1);
        ModTablicy m3 = new ModTablicy(lista, 30,1);
        ModTablicy m4 = new ModTablicy(lista, 15,4);

        Thread thread1 = new Thread(m1);
        Thread thread2 = new Thread(m2);
        Thread thread3 = new Thread(m3);
        Thread thread4 = new Thread(m4);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start(); */

    }
}
