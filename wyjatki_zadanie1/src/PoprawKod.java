public class PoprawKod {
    public static void main(String[] args) {
        Integer x = null;
        Integer liczba = null;
        try {
          //  liczba = 10 / 0;
            x = liczba / 10;

        } catch (NullPointerException | ArithmeticException e){
            System.out.println("liczba jest nullem lub blad aytmetyczy");
            System.out.println(e);
        }
   //     catch(ArithmeticException e) {
   //         System.out.println("Nieprawidłowa operacja arytmetyczna");
   //         System.out.println(e);
         catch(Exception e) {
            System.out.println("Blad ogolny");
            System.out.println(e);
        } finally {
            System.out.println("Finally " +liczba);
        }
    }
}
