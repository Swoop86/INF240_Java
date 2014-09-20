/**
 * Created by Filip on 19.09.2014.
 */
import java.util.*;
public class Person implements Comparable {

    private String _Fornavn;
    private String _Etternavn;
    private int _Fdato;
    private List<Bil> biler = new ArrayList<Bil>();

    public String getFornavn() {
        return _Fornavn;
    }

    public void setFornavn(String _Fornavn) {
        this._Fornavn = _Fornavn;
    }

    public String getEtternavn() {
        return _Etternavn;
    }

    public void setEtternavn(String _Etternavn) {
        this._Etternavn = _Etternavn;
    }

    public int getFdato() {
        return _Fdato;
    }

    public void setFdato(int _Fdato) {
        this._Fdato = _Fdato;
    }

    public Person(String Fornavn, String Etternavn, int Fdato)
    {
        this._Fornavn = Fornavn;
        this._Etternavn = Etternavn;
        this._Fdato = Fdato;
    }

    public void LeggTilBil(String Modell, String Type, int RegNR)
    {
        Bil bil = new Bil(Modell, Type, RegNR);
        biler.add(bil);
    }

    public int compareTo(Object o)
    {
        Person p = (Person) o;
        if (getFdato() == p.getFdato() || getEtternavn() == p._Etternavn || getFornavn() == p._Fornavn)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public List<String> Hentbiler()
    {
        for (Bil billiste : biler)
        {
            String modell = billiste.getModell();
            String type = billiste.getType();
            String regnr = Integer.toString(billiste.getRegNr());
            String output = modell + ", " + type + ", " + regnr;
            Hentbiler().add(output);
        }
        return Hentbiler();
    }

    @Override
    public String toString() {
        String fornavn = getFornavn();
        String etternavn = getEtternavn();
        return fornavn + ", " + etternavn;
    }

}
