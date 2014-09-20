/**
 * Created by Filip on 19.09.2014.
 */
import java.io.IOError;
import java.io.IOException;
import java.util.*;

public class Kontroller {
    private static Kontroller kontroller = new Kontroller();
    private List<Person> personer = new ArrayList<Person>();

    private Kontroller() { }

    public static Kontroller getKontroller()
    {
        return kontroller;
    }

    public void LeggTilPerson(String Fornavn, String Etternavn, int Fdato)
    {
            Person person = new Person(Fornavn, Etternavn, Fdato);
            personer.add(person);
    }

    public Person HentPerson(String søkefelt)
    {
        for (Person person : personer)
        {
            if (person.compareTo(person) > 0)
            {
                    return person;
            }
        }

        return null;
    }

    public void LeggTilBil(String Modell, String Type, int RegNr, Object Eier)
    {
        for (Person eier : personer)
        {
            if (eier.compareTo(Eier) > 0)
            {
                eier.LeggTilBil(Modell, Type, RegNr);
            }
        }
    }

    public List<Person> HentPersoner()
    {
        return personer;
    }

    public String VisNavn(Person p)
    {
        String fornavn = p.getFornavn();
        String etternavn = p.getEtternavn();

        return fornavn + ", " + etternavn;
    }

}
