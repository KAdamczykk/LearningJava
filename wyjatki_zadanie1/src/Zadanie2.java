public class Zadanie2 {
    public static void main(String[] args) {
        int[] list = new int[5];
        for (int i = 0; i <5; i++){
            list[i] = 4*i;
        }
        try {
            list[10] = 4;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Przekroczono zakres listy");
            System.out.println(e);
        } catch (Exception e){
            System.out.println("Blad ogolny \n" + e );
        }


    }
}
