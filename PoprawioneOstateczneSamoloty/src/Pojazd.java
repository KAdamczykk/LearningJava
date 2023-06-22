public interface Pojazd {
    double getIloscPaliwa() throws WyjatekBrakPaliwa;
    boolean zuzyciePaliwa(double iloscTraconego);
}
