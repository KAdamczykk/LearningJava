public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.imie = "adrian";
        user.nazwisko = "wala";
        user.wiek = 17;
        System.out.println(user);
        user.Sprawdz_wiek_uzytkownika();
        user.Blokuj();
        System.out.println(user.Czy_admin());
        System.out.println();
        Admin admin = new Admin();
        admin.imie = "debil";
        admin.nazwisko = "tak";
        admin.wiek = 18;
        System.out.println(admin);
        System.out.println(admin.Czy_admin());
        admin.Blokuj();
    }
}