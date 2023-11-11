package Jachty;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Statki {
    StatkiNawodne getNajciezszyStatek();
    StatkiNawodne getStatekONajdluzszejNazwieProducentaNaR();
    JachtMotorowy getJachtMotorowyONajwiekszejMocySilnika();
    JachtKabinowy getLekkiJachtKabinowyONajmniejszymOzaglowaniu();
    Set<StatkiNawodne> getCoNajwyzej11DlugichICiezkichJachtow();
    List<StatkiNawodne> getStatkiPosortowaneWzgledemDlugosciBez2();
    List<JachtyZaglowe> getPierwsze8ZPosortowanychWzgledemOzaglowaniaBezTrzechPierwszych();
    void oznaczJachtyDobreNaPlycizny();
    String get12UnikalnychNazwTypow();
    Map<String, JachtMotorowy> getMapaJachtowMotorowych();
    List<Jacht> getJachtyOdkrytopokladoweIMotoroweJednePoDrugich();

}
